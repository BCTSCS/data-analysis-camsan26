import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Re {
    public static void main(String[] args) {
        // String re = "#\\d{4}-d{2}-d{4}\\";
        // String text = "616-33-4565";
        // iterate each post and find #\w
        // for(String post : posts) {
        //     String result = post.matches(re);
        // }
        String re = "\\w\\s";
        String text = "ABBBBBBBBBBBBA";
        boolean r = text.matches(re);
        ArrayList<String> posts = FileOperator.getStringList("/home/codespace/github-classroom/BCTSCS/data-analysis-camsan26/posts.txt");
        System.out.println(posts);
        for (String post : posts) {
            boolean result = post.matches(re);
            System.out.println(result);
        }
        System.out.println(posts);
    }
}
