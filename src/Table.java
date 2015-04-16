public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card c) {
    TableNode n = new TableNode(c);
    n.setNext(head);
    head = n;
  }
  
  public void removeSet(Card c1, Card c2, Card c3) {
    if (c1.isSet(c2, c3) == false) {
      return;
    }
    
    else {
      boolean isRemove1 = false;
      boolean isRemove2 = false;
      boolean isRemove3 = false;
      
      TableNode temp = head;
      
      while (temp != null) {
        if (c1.equals(temp.getCard())) {
          isRemove1 = true;
        }
        if (c2.equals(temp.getCard())) {
          isRemove2 = true;
        }
        if (c3.equals(temp.getCard())) {
          isRemove3 = true;
        }
        temp = temp.getNext();
      }
      
      if (isRemove1 && isRemove2 && isRemove3) {
        temp = head;
        TableNode prev = null;
        
        while (temp != null) {
          if (c1.equals(temp.getCard()) || c2.equals(temp.getCard()) || c3.equals(temp.getCard())) {
            if (temp == head) {
              temp = temp.getNext();
              head = head.getNext();
            }
            else {
              prev.setNext(temp.getNext());
              temp = temp.getNext();
            }
          }
          else {
            prev = temp;
            temp = temp.getNext();
          }
        }
      }
    }
  }
  
  public int numCards() {
    TableNode temp = head;
    int num = 0;
    while (temp != null) {
      num += 1;
      temp = temp.getNext();
    }
    return num;
  }
  
  public Card getCard(int index) {
    if (index > numCards() - 1) {
      return null;
    }
    
    TableNode temp = head;
    if (temp == null) {
      return null;
    }
    
    else {
      for (int i = 0; i < index; i++) {
        temp = temp.getNext();
      }
    return temp.getCard();
    }
  }
  
  public int numSets() {
    int num = 0;
    if (numCards() < 3) {
      return 0;
    }
    else {
      TableNode n1 = head;
      while (n1 != null && n1.getNext().getNext() != null) {
        TableNode n2 = n1.getNext();
        while (n2 != null && n2.getNext() != null) {
          TableNode n3 = n2.getNext();
          while (n3 != null) {
            if (n3.getCard().isSet(n2.getCard(), n1.getCard()) == true) {
              num += 1; 
            }
            n3 = n3.getNext();
          }
          n2 = n2.getNext();
        }
        n1 = n1.getNext();

      }
      return num;
    }
  }
}