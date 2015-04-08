import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  //Instrance variables must be cards and nextCardIndex for the provided constructor
  //to work
  public ArrayList<Card> cards;
  public int nextCardIndex;
  
  public Deck() {
    // Creates a deck with all standard 81 set cards, shuffled
    //Usage (in test code, and in the later code); Deck d = new Deck()
    cards = new ArrayList<Card>(81);
    
    for (int q = 1; q <= 3; q++) {
      for (int c = 1; c <= 3; c++) {
        for (int shd = 1; shd <= 3; shd++) {
          for (int shp = 1; shp <= 3; shp++) {
            cards.add(new Card (q, c, shd, shp));
          }
        }
      }
    }
    Collections.shuffle(cards);
    nextCardIndex = 0;
  }
  
  public Deck(String filename) {
    //Creates a pre-defined deck from a file named filename and does not shuffle
    //Usage (in test code, and in the later code); Deck d = new Deck("example.dat")
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
    //Returns true if any cards are left, false otherwise
    if (nextCardIndex < cards.size()) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public Card getNext() {
    //Returns the next card in the deck if there is one, null otherwise
    //You can call hasNext within this method to see if you should return
    //a card or return null
    int cardIndex = nextCardIndex;
    nextCardIndex += 1;
    if (hasNext() == false) { 
      return null;
    }
    else {
      return cards.get(cardIndex);
    }
  }
}
