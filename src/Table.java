public class Table
{
  private TableNode head;
  private int length;
  
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
      length++;
      n.setNext(head);
      head = n;
    }
  }
  
  private boolean onTable(Card p)
  {
    TableNode curr = head;
    while(curr!= null)
    {
      if(curr.getCard().equals(p))
      {
        return true;
      }
      curr= curr.getNext();
    }
    
    return false;
  }
  
  private void removeCard(Card y)
  {
    TableNode prev = findPrev(y);
    length-=1;
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
  
  private TableNode findPrev(Card c)
  {
    TableNode prev = null;
    TableNode curr = head;
    
    while(curr!= null)
    {
      Card n = curr.getCard();
      if(n.equals(c))
      {
        return prev;
      }
      prev = curr;
      curr = curr.getNext();
    }
    return null;
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
    if(curr == null)
    {
      return 0;
    }
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
    if(index >= length || p == null)
      return null;
    if(index == 0)
      return p.getCard();
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
    
    for(int j = 0; j< length-2; j++)
    {
      for(int k =  j + 1; k< length-1; k++)
      {
        for(int z = k + 1; z< length; z++)
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