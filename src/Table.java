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
    //if the 3 cards don't form a set or if any of the cards are not on the table, return
    //otherwise, remove c1, c2, c3, preserving relative order of the rest of the cards
    /*if (c1.isSet(c2, c3)) {
      Card remove1 = null;
      Card remove2 = null;
      Card remove3 = null;
      
      TableNode temp = head;
      TableNode  prev = head;
      while (temp != null) {
        if (temp.getCard() == c1) {
          temp = temp.getNext();
          c1 = null;
        }
      }   
    }
    else {
      return;
    }*/  
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
    //if index is out of bounds, return null
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