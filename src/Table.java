public class Table {
  private TableNode head;
  
  
  public Table() {
    head = null;
  }
  
  public void add(Card card) {
    TableNode node = new TableNode(card);
    if (head == null) {
      head = node;
    }
    else {
      node.setNext(head);
      head = node;
    }
  }
  
  public void removeSet(Card c1, Card c2 , Card c3) {
    if (c1.isSet(c2,c3) == false) {
      return;
    }
    TableNode temp = head;
    Card removeC1 = null;
    Card removeC2 = null;
    Card removeC3 = null;
    
    while (temp != null) {
      if (temp.getCard() == c1) {
        removeC1 = c1;
      }
      if (temp.getCard() == c2) {
        removeC2 = c2;
      }
      if (temp.getCard() == c3) {
        removeC3 = c3;
      }
      
      temp = temp.getNext();
    }
    
    if (removeC1 == c1 && removeC2 == c2 && removeC3 == c3) {
      TableNode curr = head;
      TableNode prev = null;
      int prevNumCards = numCards();
      
      while (curr != null) {
        if (curr.getCard() == c1 || curr.getCard() == c2 || curr.getCard() == c3) {
          if (curr == head) {
            prev = head;
            head = head.getNext();
            prev.setNext(null);
            curr = head;
            prev = null;
          }
          else {
            prev.setNext(curr.getNext());
            curr.setNext(null);
          }
        }
        if (numCards() == 0) {
          return;
        }
        if (curr.getNext() == null && prev != null) {
          curr = prev.getNext();
        }
        if (prevNumCards == numCards()) {
          prev = curr;
          curr = curr.getNext();
        }
        prevNumCards = numCards();
      }
    }
    return;
  }
  
  public int numCards() {
    TableNode temp = head;
    int card = 0;
    if (head == null) {
      return 0;
    }
    else {
      while (temp != null) {
        temp = temp.getNext();
        card += 1;
      }
      return card;
        
        
    }
  }
  
  public Card getCard(int index) {
    TableNode temp = head;
    if (temp == null) {
      return null;
    }
    for (int d = 0; d < index; d++) {
      temp = temp.getNext();
      if (temp == null) {
        return null;
      }
    }
    return temp.getCard();
    
    
  }
  
  public int numSets() {
    int isSet = 0;
    int numCards = numCards();
    for (int a = 0; a < numCards - 2; a++) {
      for (int b = 1; b < numCards - 1; b++) {
        for (int c = 2; c < numCards; c++) {
          
          Card card1 = getCard(a);
          Card card2 = getCard(b);
          Card card3 = getCard(c);
          
          if (card1.isSet(card2,card3)) {
            isSet += 1;
          }
        }
      }
    }
    return isSet;
  }
}