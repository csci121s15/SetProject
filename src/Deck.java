import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  private int nextCardIndex;
  private ArrayList<Card> cards;
  
  public Deck() {
    cards = new ArrayList<Card>(81);
    
    for (int Q = 1; Q <= 3; Q++) {
      for (int C = 1; C <= 3; C++) {
        for (int S = 1; S <= 3; S++) {
          for (int Sh = 1; Sh <= 3; Sh++) {
            Card c = new Card(Q, C, S, Sh);
            cards.add(c);
          }
        }
      }
    }
    Collections.shuffle(cards);
  }
  

  
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
  
  public boolean hasNext() {
    if (nextCardIndex < cards.size()) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public Card getNext() {
    if (hasNext() != false) {
      nextCardIndex += 1;
      return cards.get(nextCardIndex - 1);
    }
    else {
      return null;
    }
  }
}
