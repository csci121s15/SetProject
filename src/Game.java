public class Game
{
  private int removedCards = 0;
  private int sets = 0;
  private int numRounds = 0;
  Table t = new Table();
  Deck d;
  
  public Game()
  {
    d = new Deck();
    for(int i=0; i<12; i++)
    {
      if(d.hasNext())
        t.add(d.getNext());
    }
  }
  
  public Game(String filename)
  {
    d = new Deck(filename);
    for(int i=0; i<12; i++)
    {
      if(d.hasNext())
        t.add(d.getNext());
    }
  }
  
  public int numSets()
  {
    return t.numSets();
  }
  
  public int numCards()
  {
    return t.numCards();
  }
  
  public void playRound()
  {
    if(isGameOver() == false)
    {
      if(t.numSets() > 0)
      {
        Card a = null;
        Card b = null;
        Card c = null;
        boolean findSet = false;
        
        for(int i=0; i<t.numCards(); i++)
        {
          for(int j=i+1; j<t.numCards(); j++)
          {
            for(int k=j+1; k<t.numCards(); k++)
            {
              if(findSet == false)
              {
                a = t.getCard(i);
                b = t.getCard(j);
                c = t.getCard(k);
                
                if(a.isSet(b,c) == true)
                {
                  t.removeSet(a,b,c);
                  findSet = true;
                }
              }
            }
          }
        }
        sets++;
        removedCards += 3;
        if(t.numCards() < 12) //if table has less than 12 cards
        {
          for(int i=0; i<3; i++) //runs 3 times
          {
            if(d.hasNext() == true) //if deck has another card
              t.add(d.getNext()); //add next card
          }
        }
      }
      else // if t.numSets = 0 
      {
        for(int i=0; i<3; i++) //3 times
        {
          if(d.hasNext() == true) //if deck has card
            t.add(d.getNext()); //add next card
        }
      }
      numRounds++;
    }
  }
 
  public boolean isGameOver()
  {
    if(t.numSets() == 0 && d.hasNext() == false)
      return true;
    return false;
  }
}
