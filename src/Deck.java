import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.StringTokenizer; 
import java.util.ArrayList; 
import java.util.Collections; 
 
public class Deck { 
   
  private ArrayList<Card> cards = new ArrayList<Card>(81); 
  private int nextCardIndex = 0; 
   
   public Deck() { 
    
    for ( int quant = 1; quant <= 3; quant ++) { 
      
      for (int clr = 1; clr <= 3; clr ++) { 
        
        for (int shd = 1; shd <= 3; shd ++) {
          
          for (int shp = 1; shp <=3; shp ++) { 
            
            Card card = new Card(quant, clr, shd, shp); 
            cards.add(card);
          } 
        } 
      } 
    }    
    
    Collections.shuffle(cards); 
    
  }
  
    public boolean hasNext(){ 

      if (nextCardIndex < cards.size()){ 
        return true; 
      } 
      
      else { 
        
        return false; 
      } 
      
    }
    
    public Card getNext(){ 
     
    if (hasNext() == false){ 
      
      return null; 
    } 
     
    else { 
      
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