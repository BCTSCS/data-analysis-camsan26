import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleAnalyzer {
    private ArrayList<String> stopWords;
    private ArrayList<Article> articles;
    private static ArrayList<String> words = new ArrayList<>();
    private static ArrayList<Double> values = new ArrayList<>();
    public ArticleAnalyzer() {
        stopWords = FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word Count: " + stopWords.size());
        articles = new ArrayList<>();
        words = new ArrayList<>();
        values = new ArrayList<>();
        System.out.println("Articles Count: " + articles.size());
    }
    public static void main(String[] args) {
        ArticleAnalyzer Camila = new ArticleAnalyzer();
        // ArrayList<String> lines = FileOperator.getStringList("data.txt");
        // for (String line:lines) {
        //     // String line = lines.get(0);
        //     Article c = Camila.parseJson(line);
        //     String clean = Camila.removeStopWords(c.getDescription());
        //     System.out.println(c);
        //     Camila.addArticle(c);
        // }
        ArrayList<String> sentiments = FileOperator.getStringList("sentiments.txt");
        for (String sentiment:sentiments) {
            Pattern l = Pattern.compile("((?i)[A-Za-z0-9]+),(-?\\d+.\\d+)");  //r write regex to extract the word before, and value after
            Matcher lm =l.matcher(sentiment); //parameter - line of text
            boolean found = lm.find(); 
            String word = found ? lm.group(1) : ""; 
            Double value = found ? Double.parseDouble(lm.group(2)) : 0.0;
            System.out.println(word+"   ----  "+value);
            words.add(word);
            values.add(value);
        }
    }
    public void addArticle(Article article) {
        articles.add(article);
    }
    public Article parseJson(String jsonLine) {   
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher lm =l.matcher(jsonLine); //parameter - line of text
        String lt = lm.find() ? lm.group(1) : ""; //extract the destined part

        Pattern h = Pattern.compile("\"headline\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher hm =h.matcher(jsonLine); //parameter - line of text
        String ht = hm.find() ? hm.group(1) : ""; //extract the destined part

        Pattern c = Pattern.compile("\"category\"\\s*:\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher cm =c.matcher(jsonLine); //parameter - line of text
        String ct = cm.find() ? cm.group(1) : ""; //extract the destined part

        Pattern d = Pattern.compile("\"short_description\"\\s*:\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher dm =d.matcher(jsonLine); //parameter - line of text
        String dt = dm.find() ? dm.group(1) : ""; //extract the destined part

         Pattern a = Pattern.compile("\"authors\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher am =a.matcher(jsonLine); //parameter - line of text
        String at = am.find() ? am.group(1) : ""; //extract the destined part

        Pattern t = Pattern.compile("\"date\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher tm =t.matcher(jsonLine); //parameter - line of text
        String tt = tm.find() ? tm.group(1) : ""; //extract the destined part

        Article result=new Article(lt, ht,ct,dt,at,tt);
        return result;
    }
    public String removeStopWords(String text) {
        for (String word : stopWords) {
            text = text.replace("\\b"+word+"\\b", " ");
        }
        return text;
    }
}
