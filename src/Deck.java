import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  private ArrayList<Card> cards; 
  private int nextCardIndex = 0;
  
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
  
  public Deck(){ 
    cards = new ArrayList<Card>(81); 
    int quantity = 1; 
    int color = 1;
    int shading = 1;
    int shape = 1;
    
    for(int i = 1; i <= 3; i++){
      shape = i;
    
      for(int k = 1; k <= 3; k++){
        color = k;
        
        for(int y = 1; y <= 3; y++){
          shading = y;
          
          for(int x = 1; x <= 3; x++){
            quantity = x;
            Card card = new Card(quantity, color, shading, shape);
            cards.add(card);
          }
        }
      }
    }
    Collections.shuffle(cards);
  }
  public boolean hasNext(){
    if(nextCardIndex < cards.size()){
      return true;
    } else {
      return false;
    }
  }
  
  public Card getNext(){
    Card temp = cards.get(nextCardIndex);
    nextCardIndex++;
    return temp;
  }
}
