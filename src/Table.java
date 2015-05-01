public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card newCard) {
    TableNode newTableNode = new TableNode(newCard);
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
  
  private void removeCard(Card c1) {
    TableNode prev = findPrev(c1);
    // remove from beginning
    if (prev == null) {
      head = head.getNext();
    }
    // remove from middle or end
    else {
      TableNode curr = prev.getNext();
      prev.setNext(curr.getNext());
    }
  }
       
  
  
  private TableNode findPrev(Card c1) {
    TableNode curr = head;
    TableNode prev = null;
    
    while (curr != null) {
      if (c1.equals(curr.getCard())) {
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
    TableNode curr = head;
    TableNode prev = null;
    
    if (!c1.isSet(c2, c3)) {
          return;
    }
        
    if (!onTable(c1)) {
          return;
    }
        
    if (!onTable(c2)) {
          return;
    }
        
    if (!onTable(c3)) {
          return;
    }
        
        removeCard(c1);
        removeCard(c2);
        removeCard(c3);
  }

        
  
  public int numCards() {
    TableNode curr = head;
    int count = 0;
    
    while (curr != null) {
      count += 1;
      curr = curr.getNext();
    }
    return count;
    }
  
  public Card getCard(int index) {
    TableNode temp = head;
    if (temp == null) {
      return null;
    }
    
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
      
      if (temp == null) {
        return null;
      }
    }
    return temp.getCard();  
  }
  
  public int numSets() {
    int count = 0;
    int length = numCards();
    
    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
    
          Card c1 = getCard(i);
          Card c2 = getCard(j);
          Card c3 = getCard(k);
          
          if (c1.isSet(c2, c3)) {
            count += 1;
          }
        }
      }
    }
    return count;
  }
}


