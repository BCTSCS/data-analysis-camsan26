import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        ArrayList<String> lines = FileOperator.getStringList("data.txt");
        String line = lines.get(0);
        Article c = Camila.parseJson(line);
        System.out.println(c);

    }
    public void addArticle(Article article) {

    }
    public Article parseJson(String jsonLine) {
        // Pattern l = Pattern.compile("re");
        Pattern h = Pattern.compile("re");
        Pattern c = Pattern.compile("re");
        Pattern e = Pattern.compile("re");
        Pattern a = Pattern.compile("re");
        Pattern d = Pattern.compile("re");
        
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher lm =l.matcher(jsonLine); //parameter - line of text
        String lt = lm.find() ? lm.group(1) : ""; //extract the destined part
        Article result=new Article(lt, " "," "," "," "," ");
        return result;
    }
    public String removeStopWords(String text) {
        String result="";
        return result;
    }
}
