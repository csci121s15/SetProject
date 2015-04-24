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
    if(numCards() >12 && numSets() >=1)
    {
      for(int j = 0; j < 3; j++)
      {
        t.removeSet(t.getCard(j), t.getCard(j + 1), t.getCard(j + 2));
      }
      
    }
    if(numSets() >=1 && d.hasNext() != true)
    {
      for(int k = 0; k<3; k++)
      {
        t.removeSet(t.getCard(k), t.getCard(k + 1), t.getCard(k + 2));
      }
      isGameOver();
    }
    if(numSets() == 0 && d.hasNext() == true)
    {
      
      for(int i = 0; i<3; i++)
        t.add(d.getNext());
      return;
    }
    //We start with 12 cards on the table and some cards in the deck and when we finish
    //a round, we take a set away and then add more cards to the table
    while(numSets() > 0)
    {
      for(int j = 0; j< numCards()-2; j++)
      {
      for(int k =  j + 1; k< numCards()-1; k++)
       {
        for(int z = k + 1; z< numCards(); z++)
        {
          Card i = t.getCard(j);
          Card e = t.getCard(k);
          Card o = t.getCard(z);
          
          if(i.isSet(e,o))
          {
            t.removeSet(i,e,o);
          }
          if(numCards() < 12 && d.hasNext() == true)
          {
            for(int m = 0; m<3; m++)
            {
              t.add(d.getNext());
            }
            return;
          }
        }
      }
    }
    
  }
  }
  
  public boolean isGameOver()
  {
    if(t.numCards() == 0 && numSets() == 0)
      return true;
    else
      return false;
  }
}