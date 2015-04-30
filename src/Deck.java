import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck 
{
  // Implement the rest of this class yourself
  private int nextCardIndex = 0;
  private ArrayList<Card> cards;
  
  public Deck()
  {
    cards = new ArrayList<Card>(81);
    for(int q = 1; q<=3; q++)
    {
      for(int c = 1; c<=3; c++)
      {
        for(int s = 1; s<=3; s++)
        {
          for(int sh = 1; sh<=3; sh++)
          {
            Card leaf = new Card(q, c, s, sh);
          }
        }
      }
    }
    Collections.shuffle(cards);
  }
  
  
  public Deck(String filename) 
  {
    cards = new ArrayList<Card>(81);
    
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
  public boolean hasNext()
  {
    //Returns true if any cards are left, false otherwise
    if(nextCardIndex < cards.size())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public Card getNext()
  {
    //Returns the next card in the deck if there is one. null otherwise.
    if(hasNext() == true)
    {
      nextCardIndex++;
      return cards.get(nextCardIndex-1);
    }
    else
    {
      return null;
    }
    //You can call hasNext() within this method to see if you should return
    //a card or null
  }
}
