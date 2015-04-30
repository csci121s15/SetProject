public class Game
{
  private Table t;
  private Deck d;
  
  public Game()
  {
    d = new Deck();
    t = new Table();
    
    for(int i = 0; i< 12; i++)
    {
      if(d.hasNext() == true)
      {
        t.add(d.getNext());
      }
    }
  }
  
  public Game(String filename)
  {
    d = new Deck(filename);
    t = new Table();
    
    int j = 0;
    while(d.hasNext() == true)
    {
      t.add(d.getNext());
      j++;
      
      if(t.numCards() == 12)
        return;
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
    if(numSets() >=1)
    {
      for(int j = 0; j < numCards()-2; j++)
      {
        for(int k = j + 1; k< numCards()-1; k++)
        {
          for(int x = k + 1; x< numCards(); x++)
          {
            if(t.getCard(j).isSet(t.getCard(k), t.getCard(x)))
            {
              t.removeSet(t.getCard(j), t.getCard(k), t.getCard(x));
              if(numCards() < 12)
              {
                for(int y = 0; y < 3 && d.hasNext(); y++)
                {
                  t.add(d.getNext());
                }
              }
              return;
              
            }
          }
        }
      }
      
    }
    if(numSets() == 0)
    {
      
      for(int i = 0; i<3 && d.hasNext(); i++)
        t.add(d.getNext());
      return;
    }
  }
  
  public boolean isGameOver()
  {
    if(numSets() == 0 && !d.hasNext())
      return true;
    else
      return false;
  }
}