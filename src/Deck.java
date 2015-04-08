import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  private ArrayList <Card> cards;
  private int nextCardIndex;
  
  public Deck() {
    // Creates a deck with all standard 81 set cards, shuffled.
    cards = new ArrayList<Card>(81);
    for(int i = 0; i < 81; i++) {
      for (int quantity =1; quantity <= 3; quantity ++) {
        for (int color =1; color <= 3; color++) {
          for (int shading =1; shading <= 3; shading++) {
            for (int shape =1; shape <= 3; shape++) {
              Card c = new  Card(quantity, color, shading, shape);
              cards.add(c);
            }
          }
        }
      }
    }
    Collections.shuffle(cards);  
  }
  
//  public Deck(String filename) {
//    Creates a pre-defined deck from a file named filename, and does not shuffle it.
//    Usage (in test code, and in the later code):
//      Deck d = new Deck("example.dat");
//  }
  
  public boolean hasNext() {
    // Returns true if any cards left, false otherwise.
    if(nextCardIndex < cards.size())
      return true;
    else
      return false;
  }
  
  public Card getNext() {
    // Returns the next card in the deck if there is one, null otherwise.
    if (hasNext() == true) {
      nextCardIndex += 1;
      return cards.get(nextCardIndex -1);
    }
    else
      return null;
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
}
