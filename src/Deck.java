import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  // Instance variables must be cards and nextCardIndex for the
  // provided constructor to work
  ArrayList<Card> cards;
  int nextCardIndex = 0;
  
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
  
  public Deck() {
    // Creates a deck with all standard 81 set cards, shuffled.
    // Usage (in test mode, and in the later code):
    //   Deck d = new Deck()
    cards = new ArrayList<Card>(81);
    
    for (int quantity = 1; quantity < 4; quantity++) {
      for (int color = 1; color < 4; color++) {
        for (int shading = 1; shading < 4; shading++) {
          for (int shape = 1; shape < 4; shape++) {
            cards.add(new Card(quantity, color, shading, shape));
          }
        }
      }
    }
    Collections.shuffle(cards);    
  }
  
  public boolean hasNext() {
    if (nextCardIndex < cards.size()-1)
      return true;
    return false;
  }
  
  public Card getNext() {
    // Returns the next card in the deck if there is one,
    // and null, otherwise
    // You can call hasNext within this method to see if you
    // should return a card or return null
    if (hasNext() == false)
      return null;
    nextCardIndex++;  
    return cards.get(nextCardIndex-1); 
  }
}
