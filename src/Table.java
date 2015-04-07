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
    int numCards = 0;
    
    while (ref.getNext() != null)
    {
     numCards += 1;
    }
    
    return numCards;
  }
  
  public Card getCard(int cardIndex)
  {
    TableNode ref = head;
    
    for (int n = 0; n < cardIndex; n++)
    {
      ref = ref.getNext();
    }
    
    return ref.getCard();
  }
  
  public int numSets()
  {
   return 0; 
  }
}