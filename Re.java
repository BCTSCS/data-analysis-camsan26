import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Re {
    public static void main(String[] args) {
        String re = "[A-Z]{5,}";
        String text = "ABBBBBBBBBBBBA";
        // boolean result = text.matches(re);
        // read posts. txt
        if (text.matches(re)) {
            System.out.println("Valid input: " + text);
        } else {
            System.out.println("Invalid inpu: " + text);
        }
        ArrayList<String> posts = FileOperator.getStringList("/home/codespace/github-classroom/BCTSCS/data-analysis-camsan26/posts.txt");
        // iterate each post and find #\w
        // for(String post : posts) {
        //     String result = post.matches(re);
        // }
        Pattern hashtagPattern = Pattern.compile("#\\w+");
        for (String post : posts) {
            Matcher result = hashtagPattern.matcher(post);
            while (result.find()) {
                System.out.println("Found hashtag: " + result.group());
            }
        }
        System.out.println(posts);
    }
}
