import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  private int nextCardIndex = 0;
  private ArrayList<Card> cards;

  public Deck(){
    cards = new ArrayList<Card>(81);
    
    for(int mar1 = 1; mar1 <= 3; mar1++){
      for (int mar2 = 1; mar2<= 3; mar2++){
        for (int mar3 = 1; mar3 <= 3; mar3++){
          for(int mar4 = 1; mar4 <= 3; mar4++){
            cards.add(new Card(mar1, mar2, mar3, mar4));
            nextCardIndex=0;
          }
        }
      }
    }
    Collections.shuffle(cards);
  }
  public boolean hasNext(){
     if (nextCardIndex < cards.size())
      return true;
    else
      return false;
  }
    
  
  public Card getNext(){
    if (hasNext() == false){ 
      return null; 
    } 
     
    else{ 
      nextCardIndex += 1; 
      return cards.get(nextCardIndex-1);
    }
  }
    
    
  public Deck(String filename) {
    cards = new ArrayList<Card>(81);
    
    try {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null) {
      
        line = line.trim();
        
        if(line.length() == 0)
          continue;
        
        if(line.startsWith("#"))
          continue;
        
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        int quantity = Integer.parseInt(tokenizer.nextToken());
        int color = Integer.parseInt(tokenizer.nextToken());
        int shade = Integer.parseInt(tokenizer.nextToken());
        int shape = Integer.parseInt(tokenizer.nextToken());
        
        cards.add(new Card(quantity, color, shade, shape));
        nextCardIndex = 0;
      }
    }
    catch(Exception e) {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
}
