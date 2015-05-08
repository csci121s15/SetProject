import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{ 
  private int nextCardIndex = 0;
  private ArrayList<Card> cards = new ArrayList<Card>(81);
  
  public Deck()
  {
    for(int quan = 1; quan < 4; quan++)
    {
      for(int col = 1; col < 4; col++)
      {
        for(int shade = 1; shade < 4; shade++)
        {
          for(int shap = 1; shap < 4; shap++)
          {
            Card card = new Card(quan,col,shade,shap);
            cards.add(card);
          }
        }
      }
    }
    nextCardIndex = 0;
    Collections.shuffle(cards);
  }
  public boolean hasNext()
  {
    if(nextCardIndex < cards.size())
      return true;
    else
      return false;
  }
  public Card getNext()
  {
    if(hasNext() == false)
      return null;
    nextCardIndex ++;
    return cards.get(nextCardIndex-1);
  }
  
  public Deck(String filename)
  { 
    try
    {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null)
      {
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
    catch(Exception e)
    {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
}
