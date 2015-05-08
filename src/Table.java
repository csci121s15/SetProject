public class Table
{  
  private TableNode head;
  private int cardsOnTable = 0;
  
  public Table()
  {
    head = null;
  }
  
  public void add(Card card)
  {
    TableNode newCard = new TableNode(card);
    newCard.setNext(head);
    head = newCard;
    cardsOnTable ++;
  }
  public void removeSet(Card one, Card two, Card three)
  {
    if(one.isSet(two,three) == true && onTable(one,two,three) == true)
    {
      removeCard(one);
      removeCard(two);
      removeCard(three);
    }
  }
  private boolean onTable(Card one)
  {
    for(int i=0; i<cardsOnTable; i++)
    {
      if(getCard(i).equals(one))
        return true;
    }
    return false;
  }
  private boolean onTable(Card one,Card two,Card three)
  {
    if((onTable(one)==true) && (onTable(two)==true) && (onTable(three)==true))
      return true;
    else
      return false;
  }
  public int numCards()
  {
    TableNode current = head;
    int numCards = 0;
    if(current == null)
      return 0;
    while (current != null)
    {
      numCards += 1;
      current = current.getNext();
    }
    return numCards;
  }
  public int numSets()
  {
    int numSets = 0;
    
    for(int i=0; i<(cardsOnTable-2); i++)
    {
      for(int j=i+1; j<(cardsOnTable-1); j++)
      {
        for(int k=j+1; k<cardsOnTable; k++)
        {
          Card a = getCard(i);
          Card b = getCard(j);
          Card c = getCard(k);
          
          if(a.isSet(b,c) == true)
            numSets++;
        }
      }
    }
    return numSets;
  }
  public Card getCard(int index)
  {
    TableNode current = head;
    current.setNext(head.getNext());
    if(index >= 0 && index < cardsOnTable)
      for(int i=0; i < index; i++)
        current = current.getNext();
    else
      return null;
    return current.getCard();
  }
  public void removeCard(Card remove)
  {
    TableNode current = head;
    for(int i=0; i < numCards(); i++)
    {
      if((current.getCard()).equals(remove))
      {
        head = current.getNext();
        cardsOnTable--;
        return;
      }
      if(((current.getNext()).getCard()).equals(remove))
      {
        current.setNext((current.getNext()).getNext());
        cardsOnTable--;
        return;
      }
      current = current.getNext();
    }
  }
}
