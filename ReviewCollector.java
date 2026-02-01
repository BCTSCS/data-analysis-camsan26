import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector() {
        reviewList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public double getSentiments(String word) {
        ArrayList<String> lines = FileOperator.getStringList("sentiments.txt");

        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+),(-?\\d+\\.\\d+)");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                String sentimentWord = matcher.group(1);
                double sentimentValue = Double.valueOf(matcher.group(2));

                if (sentimentWord.equalsIgnoreCase(word)) {
                    System.out.println(sentimentWord + ": " + sentimentValue);
                    return sentimentValue;
                }
            }
        }
            return 0.0;
    }

    public void addReview(ProductReview prodReview) {
        reviewList.add(prodReview);
        if (!productList.contains(prodReview.getName())) {
            productList.add(prodReview.getName());
        }

    }  
    public int getNumGoodReviews(String prodName) {
        getSentiments("total");
        for (ProductReview pr : reviewList) {
            String r = pr.getReview();
        }
    return 0;
    }
    public static void main(String[] args) {
        ReviewCollector rc = new ReviewCollector();
        System.out.println(rc.getNumGoodReviews("productA"));
    }
}
