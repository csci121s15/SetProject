import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
  public ArrayList<Card> cards; 
  public int nextCardIndex;
  
  public Deck() {
    cards = new ArrayList<Card>(81);
    for(int var1 = 1; var1 <= 3; var1++) {
      for(int var2 = 1; var2 <= 3; var2++) {
        for(int var3 = 1; var3 <= 3; var3++) {
          for(int var4 = 1; var4 <= 3; var4++) {
             cards.add(new Card(var1, var2, var3, var4));
          }
        }
      }
    }
    int nextCardIndex = 0;
    Collections.shuffle(cards);
  }
  
  public boolean hasNext() {
    if (nextCardIndex >= cards.size()) {
      return false;
    }
    else {
      return true;
    }
  }
  
  public Card getNext() {
    if (hasNext() == false) {
      return null;
    }
    else {
      nextCardIndex += 1;
      return cards.get(nextCardIndex - 1);
    }
  }
  
  // Implement the rest of this class yourself
  
  public Deck(String filename) {
    cards = new ArrayList<Card>(81);
    
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
        nextCardIndex = 0;
      }
    }
    catch(Exception e) {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
}
