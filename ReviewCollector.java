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
        String prodName = prodReview.getName();
        boolean found = false;
        for (String name : productList) {
            found = true;
        }
        if (!found) {
            productList.add(prodName);
        }
        System.out.println(reviewList.size());

    }  
    public int getNumGoodReviews(String prodName) {
        int goodCount = 0;
        for (ProductReview elem : reviewList) {
            if (elem.getName().equals(prodName)) {
                String review = elem.getReview();
                String [] words = review.split(" ");
                double total = 0.0;
                for (String word : words) {
                    total=total + getSentiments(word);
                }
                if (total > 0) {
                    goodCount+=1;
                }
            }

        }
        return goodCount;
    }
    public static void main(String[] args){
        ReviewCollector reviewCollector= new ReviewCollector();
        ArrayList<String> lines =FileOperator.getStringList("product.txt");
        Pattern productPattern = Pattern.compile("Product:\\s*(.+)");
        Pattern reviewPattern = Pattern.compile("Review:\\s*(.+)");

        String productName = null;
        String review =null;
        for (String line : lines) {
            Matcher productMatcher = productPattern.matcher(line);
            Matcher reviewMatcher = reviewPattern.matcher(line);

            if (productMatcher.find()) {
                productName = productMatcher.group(1);
            } else if (reviewMatcher.find()) {
                review= reviewMatcher.group(1);}
            if(productName!=null &review!=null ){
                ProductReview product=new ProductReview(productName,review);
                reviewCollector.addReview(product);
                System.out.println(product);
            }
        }
}
}
