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
    
    TableNode ref = head;
     
    Card removedCard1;
    Card removedCard2;
    Card removedCard3;
     

      
      
     
  }
  
  public int numCards()
  {
    TableNode ref = head;
    int numCards = 1;
    
    if (ref == null)
      return 0;
    
    while (ref.getNext() != null)
    {
     ref = ref.getNext();
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
    TableNode n1 = head;
    
    while (n1 != null && n1.getNext() != null && n1.getNext().getNext() != null)
    { 
      TableNode n2 = n1.getNext();
      
      while (n2 != null && n2.getNext() != null)
      {
        TableNode n3 = n2.getNext();
        
        while (n3 != null)
        {
          if (n1.getCard().isSet(n2.getCard(), n3.getCard()) == true)
            numSets += 1;
          
          n3 =n3.getNext();
        }
        
        n2 = n2.getNext();
      }
      
      n1 = n1.getNext();
    }
   
    return numSets;
  }
}