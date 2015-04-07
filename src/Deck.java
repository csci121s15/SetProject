import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  public ArrayList<Card> cards = new ArrayList<Card>(81);
  public int nextCardIndex;
  
  public Deck() {
    //Deck d = new Deck()//
    //while(d.hasNext())//
    cards = new ArrayList<Card>(81);
    for (int cardA = 1; cardA < 4; cardA++) {
      for (int cardB = 1; cardB < 4; cardB++) {
        for (int cardC = 1; cardC < 4; cardC++) {
          for (int cardD = 1; cardD < 4; cardD++) {
            cards.add(new Card(cardA, cardB, cardC, cardD));
          }
        }
      }
    }
    nextCardIndex = 0;
    Collections.shuffle(cards);
    
  }
  
  public boolean hasNext() {
    //False when nextCardIndex is out of bounds, so when it is the same as the length//
    //True if nextCardIndex is valid//
    if (nextCardIndex >= cards.size()) {
      return false;
    }
    else {
      return true;
    }
      
    
  }
  
  public Card getNext() {
    //Got from notes taken in class :if hasNext() returns false, then it wil return null but if not increment index first then return one less than index//
    //so then we would return (nextCardIndex - 1) if hasNext() is true//
    if (hasNext() == true) {
      nextCardIndex++;
      return cards.get(nextCardIndex - 1);
    }
    else {
      return null;
    }
      
    
    
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
