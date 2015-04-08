public class Table
{
  TableNode head;
  
  public Table()
  {
   head = null; 
  }
  
  public void add(Card card)
  {
    TableNode newNode = new TableNode(card);

      newNode.setNext(head);
      head = newNode;
  }
  
  public void removeSet(Card card1, Card card2, Card card3)
  {
    if (card1.isSet(card2, card3) == false)
      return;
    
    if (card1.isSet(card2, card3) == true)
    {
     TableNode ref = head;
     
     Card removedCard1;
     Card removedCard2;
     Card removedCard3;
     

      
      
     }
  }
  
  public int numCards()
  {
    TableNode ref = head;
    int numCards = 1;
    
    if (ref == null)
      return 0;
    
    while (ref.getNext() != null)
    {
     ref.getNext();
     numCards += 1;
    }
    
    return numCards;
  }
  
  public Card getCard(int cardIndex)
  {
    TableNode ref = head;
    if (ref == null)
      return null;
    
    for (int n = 0; n < cardIndex; n++)
    {
      ref = ref.getNext();
      
      if (ref == null)
        return null;
    }
    
    return ref.getCard();
  }
  
  public int numSets()
  {
    int numSets = 0;
    
   for (int i = 0; i < numCards() - 2; i++)
   {
    for (int j = i + 1; j < numCards() - 1; j ++)
    {
      for (int k = j + 1; j < numCards(); k++)
      {
        if (getCard(i).isSet(getCard(j), getCard(k)) == true)
          numSets += 1;
      }
    }
   }
   
   return numSets;
  }
}