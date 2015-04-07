import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Deck {
  // Implement the rest of this class yourself
  private int nextCardIndex = 0;
  private ArrayList<Card> cards = new ArrayList<Card>(81);
  
  public Deck(){
    for (int i=1; i<=3; i++) {
      for (int j=1; j<=3; j++) {
        for (int k=1; k<=3; k++) {
          for (int m=1; m<=3; m++) {
            Card card = new Card(i, j, k, m);
          }
        }
      }
    }
    
    Collections.shuffle(cards);  
  }
  
  public boolean hasNext() {
    if (nextCardIndex < cards.size()) {
      return true;
    }
    else {
      return false;
    } 
  }
  
  public Card getNext() {
    //returns card
    
    if (hasNext() == true) {
      nextCardIndex +=1;
      return cards.get(nextCardIndex-1);
    }
    
    else{
      return null;
    }
  }
  
  public Deck(String filename) {
    //file is named 3cards.txt
    //ArrayList cards = new ArrayList<Card>(81);
    
    try {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null) {
        // Blank lines might contain white space, so trim it off
        line = line.trim();
        
        // ignore blank lines
        if(line.length() == 0)
          continue;
        
        // ignore comments
        if(line.startsWith("#"))
          continue;
            
        // a valid line contains 4 integers
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        int quantity = Integer.parseInt(tokenizer.nextToken());
        int color = Integer.parseInt(tokenizer.nextToken());
        int shading = Integer.parseInt(tokenizer.nextToken());
        int shape = Integer.parseInt(tokenizer.nextToken());
        
        cards.add(new Card(quantity, color, shading, shape));
        int nextCardIndex = 0;
      }
    }
    catch(Exception e) {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
  
}
