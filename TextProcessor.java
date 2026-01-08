import java.util.ArrayList;

public class TextProcessor {
    private ArrayList<String> textList;   // The list of text from the file
    /*
     * Constructor to create a TextProcessor with the specified filename
     */
    public TextProcessor(ArrayList<String> lines) {
        setTextList(lines);
    }
    /*
    * Changes the textList to the newTextList
    */
   public void setTextList(ArrayList<String> newTextList) {
    textList = newTextList;
   }
   
    /*
   * Finds and removes all occurrences of each stop word from textList
   */
/*
   * Finds and removes all occurrences of each stop word from textList
   */
  public void removeStopWords(ArrayList<String> stopWords) {
    for (String stop : stopWords) {
      // get each line in textList
      for (int i = 0; i < textList.size(); i++) {
        String line = textList.get(i);
        line = line.replaceAll(" "+stop+" "," "); // middle
        line = line.replace(stop+" ",""); // beginning 
        line = line.replace(stop+"\n", "\n"); // end
        textList.set(i, line);
      }
    }
  }
   /*
   * Returns a String containing the text in textList
   */
  public String toString() {
    String text = "";

    for (String value : textList) {
      text = text + value + "\n";
    }

    return text;
  }






    public static void main(String[] args) {
        ArrayList<String> stopwords = FileOperator.getStringList("/home/codespace/github-classroom/BCTSCS/data-analysis-camsan26/stopwords.txt");
        ArrayList<String> posts = FileOperator.getStringList("/home/codespace/github-classroom/BCTSCS/data-analysis-camsan26/posts.txt");
        TextProcessor t = new TextProcessor(posts);
        t.removeStopWords(stopwords);
        System.out.println(t);
    }
    
}
