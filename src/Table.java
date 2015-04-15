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
    int n = 0;
    if (c1.isSet(c2, c3) == false) {
      return;
    }
    
    else {
      Card remove1 = null;
      Card remove2 = null;
      Card remove3 = null;
      
      TableNode temp = head;
      
      while (temp != null) {
        if (c1 == temp.getCard()) {
          remove1 = c1;
          c1 = null;
          temp = temp.getNext();
        }
        if (c2 == temp.getCard()) {
          remove2 = c2;
          c2 = null;
          temp = temp.getNext();
        }
        if (c3 == temp.getCard()) {
          remove3 = c3;
          c3 = null;
          temp = temp.getNext();
        }
        return;
      }
      
      if (c1 == remove1 && c2 == remove2 && c3 == remove3) {
        temp = head;
        TableNode prev = null;
        
        while (temp != null && n < 3) {
          if (c1 == temp.getCard() || c2 == temp.getCard() || c3 == temp.getCard()) {
            if (temp == head) {
              prev = temp;
              temp = temp.getNext();
              prev.setNext(null);
              temp = null;
              n += 1;
            }
            else {
              prev.setNext(temp.getNext());
              temp.setNext(null);
              n += 1;
            }
          }
          return;
        }
        
        if (temp.getNext() == null && prev != null) {
          temp = prev.getNext();
        }
      }
    }
    return;
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