public class Table {
  private TableNode head;
  
  public Table() {
    //initialize head
    head = null;
  }
  
  public void add(Card card) {
    TableNode newTableNode = new TableNode(card);
    newTableNode.setNext(head);
    head = newTableNode;
  }
  
  private boolean onTable(Card c) {
    TableNode curr = head;
    
    while (curr != null) {
      if (curr.getCard().equals(c)) {
        return true;
      }
        curr = curr.getNext();
    }
        return false;
  }
  
  private void removeCard(Card c) {
    TableNode prev = findPrev(c);
    
    if (prev == null) // head remove
      head = head.getNext();
    else {// middle or tail remove 
      TableNode curr = prev.getNext();
      prev.setNext(curr.getNext());
    }
  }
  
  private TableNode findPrev(Card c) {
    TableNode curr = head;
    TableNode prev = null;
    
    while (curr != null) {
      if (c.equals(curr.getCard())) {
        return prev;
      }
      else {
        prev = curr;
        curr = curr.getNext();
      }
    }
    return null;
  }
  
  public void removeSet(Card c1, Card c2, Card c3) {
    //if 3 cards dont form a set or if any of the cards are not on the table,
    // return.
    //otherwise:
    // remove c1, c2, and c3 preserving the relative order of the rest of the cards.
    
    if (! c1.isSet(c2,c3))
      return;
    if (! onTable(c1))
      return;
    if (! onTable(c2))
      return;
    if (! onTable(c3))
      return;
    removeCard(c1);
    removeCard(c2);
    removeCard(c3);   
  }
  
  public int numCards() {
    //if we havent stored the length of the list, we have to iterate through the
    //list and count the cards.
    
    TableNode curr = head;
    int count = 0;
    
    while (curr != null) {
      count += 1;
      curr = curr.getNext();
    }
    return count;
  }
  
  public Card getCard(int index) {
    //if index is out of bounds, return null.
    //otherwise:
    // iterate through the list index number of times,
    // return the node there
    
    TableNode temp = head;
    if (temp == null)
      return null;
    
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
      
      if (temp == null)
        return null;
    }
    return temp.getCard();
  }
  
  public int numSets() {
    //get all triples of cards on the table, and check isSet(). Create a counter and
    //everytime isSet() == true, update the counter by 1.
    int count = 0;
    int length = numCards();
    
    for (int i = 0; i < length - 2; i++) {
      for (int t = i + 1; t < length -1; t++) {
        for (int h = t + 1; h < length; h++) {
          
          Card c1 = getCard(i);
          Card c2 = getCard(t);
          Card c3 = getCard(h);
          
          if (c1.isSet(c2, c3))
            count +=1;
        }
      }
    }
    return count;
  }
}