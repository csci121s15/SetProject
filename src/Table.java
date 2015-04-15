public class Table
{
  private TableNode head;
  
  public Table()
  {
    //initialize head
    head = null;
  }
  
  public void add(Card card)
  {
    if(head == null)
      head = new TableNode(card);
    else
    {
      TableNode n = new TableNode(card);
      n.setNext(head);
      head = n;
    }
  }
  
  private boolean onTable(Card p)
  {
    TableNode curr = head;
    while(curr!= null)
    {
      if(curr.getCard().toString().equals(p))
      {
        return true;
      }
    }
    
    return false;
  }
  
  private void removeCard(Card y)
  {
    TableNode prev = head;
    if(prev == null)
    {
      head = head.getNext();
    }
    else
    {
      TableNode curr = prev.getNext();
      prev.setNext(curr.getNext());
    }
  }
  
  public void removeSet(Card c1, Card c2, Card c3)
  {
    if(!c1.isSet(c2, c3))
    {
      return;
    }
    if(!onTable(c1))
    {
      return;
    }
    if(!onTable(c2))
    {
      return;
    }
    if(!onTable(c3))
    {
      return;
    }
    removeCard(c1);
    removeCard(c2);
    removeCard(c3);
    //if 3 cards dont form a set or if any of the cards are not on the table,
    // return.
    //otherwise:
    // remove c1, c2, and c3 preserving the relative order of the rest of the cards.
  }
  
  public int numCards()
  {
    int count = 0;
    TableNode curr = head;
    while(curr!= null)
    {
      count++;
      curr = curr.getNext();
    }
    //if we havent stored the length of the list, we have to iterate through the
    //list and count the cards.
    return count;
  }
  
  public Card getCard(int index)
  {
    TableNode p = head;
    //if index is out of bounds, return null.
    //otherwise:
    // iterate through the list index number of times,
    // return the node there
    if(head == null)
      return null;
    for(int j = 0; j < index; j++)
    {
      p = p.getNext();
    }
    return p.getCard();
  }
  
  public int numSets()
  {
    //get all triples of cards on the table, and check isSet(). Create a counter and
    //everytime isSet() == true, update the counter by 1.
    int counter = 0;
    int n = numCards();
    
    for(int j = 0; j< n-2; j++)
    {
      for(int k = 0; k< n-1; k++)
      {
        for(int z = 0; z< n; z++)
        {
          Card i = getCard(j);
          Card e = getCard(k);
          Card o = getCard(z);
          
          if(i.isSet(e,o))
          {
            counter++;
          }
        }
      }
    }
    return counter;
  }
}