import java.util.ArrayList;

public class ArticleAnalyzer {
    private ArrayList<String> stopWords;
    private ArrayList<String> articles;
    public ArticleAnalyzer() {
        stopWords = FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word Count: " + stopWords.size());
        articles = new ArrayList<>();
        System.out.println("Articles Count: " + articles.size());
    }
    public static void main(String[] args) {
        ArticleAnalyzer Camila = new ArticleAnalyzer();
    }
    public void addArticle(Article article) {

    }
    public Article parseJson(String jsonLine) {
        Article result;
        Pattern l = Pattern.compile("re");
        Pattern h = Pattern.compile("re");
        Pattern c = Pattern.compile("re");
        Pattern e = Pattern.compile("re");
        Pattern a = Pattern.compile("re");
        Pattern d = Pattern.compile("re");
        return result;
    }
    public String removeStopWords(String text) {
        String result;
    }
}
