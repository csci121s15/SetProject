public class Table {
  TableNode head;
 
  public Table() {
    head = null;
  }
  
  public void add(Card newCard) {
    TableNode temp = new TableNode(newCard);
    temp.setNext(head);
    head = temp;
  }
  
  public void removeSet(Card c1, Card c2, Card c3) {
    if (! c1.isSet(c2, c3)) {
      return;
    }
    
    if (! onTable(c1)) {
      return;
    }
    
    if (! onTable(c2)) {
      return;  
    }
    
    if (! onTable(c3)) {
      return;
    }
    
    removeCard(c1);
    removeCard(c2);
    removeCard(c3);
  }
  
  public int numCards() {
    TableNode curr = head;
    int num = 0;
    while (curr != null) {
      num ++ ;
      curr = curr.getNext();
    }
    return num;
  }
      
  public Card getCard(int cardIndex) {
    TableNode curr = head; 
    int c = 0;
    while (c != cardIndex) {
      curr = curr.getNext();
      c++;
    }
  return curr.getCard();
  }

  public int numSets() {
    int sumSets = 0;
    for (int i = 0; i < numCards(); i++) {  
      for (int j = i + 1; j < numCards(); j++) {   
        for (int k = j + 1; k < numCards(); k ++) { 
          if (getCard(i).isSet(getCard(j), getCard(k))) {
            sumSets++;
        }
      }
    }
  }
  return sumSets;
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
    if (prev == null) { 
     head = head.getNext();
    }
    else {
      TableNode curr = prev.getNext();
      prev.setNext(curr.getNext());
    }
  }
  
  private TableNode findPrev(Card c) {
    TableNode curr = head;
    TableNode prev = null;
    while (curr != null) {
      if (curr.getCard().equals(c)) {
        return prev;
      }
      else {
        prev = curr;
        curr = curr.getNext();
      }
    }
  return null;
  }
}
  
    