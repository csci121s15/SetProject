import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Deck{
  private int nextCardIndex;
  private ArrayList<Card>cards;

public void Deck() {
  cards = new ArrayList<Card>(81);
  for (int quantity = 1; quantity <= 3; quantity++) {
    for(int color = 1; color <= 3; color++) {
      for(int shading = 1; shading <= 3; shading++) {
        for(int shape = 1; shape <= 3; shape++) {
          Card r = new Card(quantity, color, shading, shape);
          cards.add(r);
        }
      }
    }
  }
  nextCardIndex = 0;
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
  
public Card getNext() {
  if(hasNext() == false) {
    return null;
  }
  else { 
    nextCardIndex ++;
    return cards.get(nextCardIndex -1);
  }
}

public boolean hasNext() {
  if( cards.size() < nextCardIndex -1) {
    return false; 
  }
  else {
    return true;
  }
}
}
