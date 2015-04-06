import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  private ArrayList<Card> cards = new ArrayList<Card>();
  private int nextCardIndex;
  
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
  
  public boolean hasNext(){
    //for (nextCardIndex = 0; nextCardIndex <=  cards.size(); nextCardIndex++){
      if (nextCardIndex < cards.size()){
        return true;
      }
      else{
        return false;
      }
    }
    //return hasNext();
 
   
  public Card getNext(){
    
    if (hasNext() == false){
      return null;
    }
    
    else{
      nextCardIndex += 1;
      return cards.get(nextCardIndex-1);
    }
  }
}

  
    
    
    