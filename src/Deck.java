import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

// instance variables must be named cards and nextCardIndex
// for provided constructor to work.
public class Deck {
  private ArrayList<Card> cards;
  private int nextCardIndex;
  
  // Creates deck with 81 set cards shuffled
  public Deck() {
    cards = new ArrayList<Card>(81);
//    while(hasNext()) {
//      cards.add(getNext());
//    }
    for(int a = 1; a < 4; a++) { 
      for(int b = 1; b < 4; b++) { 
        for(int c = 1; c < 4; c++) { 
          for(int d = 1; d < 4; d++) { 
            cards.add(new Card(a, b, c, d));
          }
        }
      }
    }
    nextCardIndex = 0;
    Collections.shuffle(cards);
  }
  
  // Crates deck from file named filename
  // Does not shuffle the deck
  // Usage in test code and later code
  // Deck d = new Deck("example.dot");
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
  
  // Returns next card in deck if there is one or otherwise null
  public boolean hasNext() {
    return nextCardIndex >= 0 && nextCardIndex < cards.size();
  }
  // You can call hasNext() within this method to see if you
  // should return a card or return null
  public Card getNext() {
    if(!(hasNext())) {
      return null;
    }
    else {
      nextCardIndex += 1;
      return cards.get(nextCardIndex - 1);
    }
  }
}
