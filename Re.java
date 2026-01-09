import java.util.ArrayList;
public class Re {
    public static void main(String[] args) {
        String re = "#\\w\\s";
        String text = "ABBBBBBBBBBBBA";
        // boolean result = text.matches(re);
        // read posts. txt
        ArrayList<String> posts = FileOperator.getStringList("/home/codespace/github-classroom/BCTSCS/data-analysis-camsan26/posts.txt");
        // iterate each post and find #\w
        for(String post : posts) {
            String result = post.matches(re);
        }
        System.out.println(posts);
    }
}
