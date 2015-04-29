public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card card) {
    TableNode Node1 = new TableNode(card);
    Node1.setNext(head);
    head = Node1;
  }
  
  public void removeSet(Card c1, Card c2, Card c3) {
    if (c1.isSet(c2, c3) == false) {
      return;
    }
    
    else {
      Card remove1 = null;
      Card remove2 = null;
      Card remove3 = null;
      
      TableNode temp = head;
      
      while (temp != null) {
        if (c1.equals(temp.getCard())) 
          remove1 = c1;
        
        if (c2.equals(temp.getCard())) 
          remove2 = c2;
        
        if (c3.equals(temp.getCard())) 
          remove3 = c3;
        
          temp = temp.getNext();
      }
      
      if (remove1 != null && remove2 != null && remove3 != null) {
        TableNode curr = head;
        TableNode prev = null;
        
        while (curr != null) {
          
          if (c1.equals(curr.getCard()) || c2.equals(curr.getCard()) || c3.equals(curr.getCard())) {
            if (curr == head) {
              curr = curr.getNext();
              head = head.getNext();
            }
            else {
              prev.setNext(curr.getNext());
              curr = curr.getNext();
            }
          }
          else {
            prev = curr;
            curr = curr.getNext();
          }
        }
      }
    }
  }
  
  public int numCards() {
    TableNode currNode = head;
    int count = 0;
    while (currNode != null) {
      count += 1;
      currNode = currNode.getNext();
    }
    return count;
  }
  
  public Card getCard(int index) {
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
    int count = 0;
    TableNode n1 = head;
    
      while (n1 != null && n1.getNext().getNext() != null) {
        TableNode n2 = n1.getNext();
        
        while (n2 != null && n2.getNext() != null) {
          TableNode n3 = n2.getNext();
          
          while (n3 != null) {
            if (n3.getCard().isSet(n2.getCard(), n1.getCard()) == true) {
              count += 1; 
            }
            n3 = n3.getNext();
          }
          n2 = n2.getNext();
        }
        n1 = n1.getNext();

      }
      return count;
  }
}
 // d