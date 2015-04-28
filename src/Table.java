public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card card) {
    TableNode newNode = new TableNode(card);
    newNode.setNext(head);
    head = newNode;
  }
  
  public void removeSet(Card card1, Card card2, Card card3) {      
    if(!(card1.isSet(card2, card3))) {
      return;
    }
    if(head == null) {
      return;
    }
    if(!(findMatch(card1) && findMatch(card2) && findMatch(card3))) {
      return;
    }
    removeCard(card1);
    removeCard(card2);
    removeCard(card3);
  }

  public void removeCard(Card card) {
    TableNode prev = null;
    TableNode curr = head;
    if(head.getCard().equals(card)) {
      head = head.getNext();
      return;
    }
    while(curr != null) {
      if(curr.getCard().equals(card)) {
        prev.setNext(curr.getNext());
        return;
      }
      prev = curr;
      curr = curr.getNext();
    }    
  }
  
  // Check if card is in table
  public boolean findMatch(Card card) {
    for(int i = 0; i < numCards(); i++) {
      if(getCard(i).equals(card)) {
        //System.out.println("Match found");
        return true;
      }
    }
    //System.out.println("Match not found");
    return false;
  }
  
  public Card findPrev(Card card) {
    for(int i = 0; i < numCards(); i++) {
      if(getCard(i) == card) {
        return getCard(i - 1);
      }
    }
    return null;
  } 
  
  public int numCards() {
    int count = 0;
    TableNode node = head;  
    while(node != null) {
      count += 1;
      node = node.getNext();
    }
    return count;
  }
  
  public Card getCard(int index) {    
    TableNode loc = head;  
    if(index < numCards() && index >= 0) {
      for(int i = 0; i < index; i++) {
        loc = loc.getNext();
      }
      return loc.getCard();
    }
    else {
      return null;
    }
  }
  
  // 1 and 2 prevent repeats
  public int numSets() {
    int numSets = 0;
    for(int a = 0; a < numCards() - 2; a++) {
      for(int b = a + 1; b < numCards() - 1; b++) {
        for(int c = b + 1; c < numCards(); c++) {
          if(getCard(a).isSet(getCard(b), getCard(c))) {
            numSets++;
          }
        }
      }
    }
    return numSets;
  }
}
