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
     
    Card removedCard1 = null;
    Card removedCard2 = null;
    Card removedCard3 = null;
    
    int removedCards = 0;
     
    while (ref != null)
    {
     if (ref.getCard().equals(card1))
       removedCard1 = card1;
     if (ref.getCard().equals(card2))
       removedCard2 = card2;
     if (ref.getCard().equals(card3))
       removedCard3 = card3;
     
       ref = ref.getNext();
    }
    
    if (removedCard1 != null && removedCard2 != null && removedCard3 != null)
    {  
      if (removedCard1.equals(card1) && removedCard2.equals(card2) && removedCard3.equals(card3))
      {
        TableNode curr = head;
        TableNode prev = null;
        int prevNumCards = numCards();
      
        while (curr != null)
        {
          if (curr.getCard().equals(card1) || curr.getCard().equals(card2) || curr.getCard().equals(card3))
          {
            if (removedCards == 3)
              return;
            
              if (curr == head)
              {
                prev = head;
                head = head.getNext();
                prev.setNext(null);
                curr = head;
                prev = null;
                
                removedCards += 1;
              }
              
              else
              {
                prev.setNext(curr.getNext());
                curr.setNext(null);
                
                removedCards += 1;
              }
            }
          
            if (numCards() == 0)
              return;
       
            if (curr.getNext() == null && prev != null)
              curr = prev.getNext();
          
       
            if (prevNumCards == numCards())
            {
              prev = curr;
              curr = curr.getNext();
            }
            
            prevNumCards = numCards();
        }
      }
    }
    
    return;
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
          
          n3 = n3.getNext();
        }
        
        n2 = n2.getNext();
      }
      
      n1 = n1.getNext();
    }
   
    return numSets;
  }
}