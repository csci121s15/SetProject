public class Table {
  private TableNode head;
  private int isLength;
  
  public Table() {
    head = null;
    isLength = 0;
  }
  
  public void add(Card card) {
    TableNode node = new TableNode(card);
    isLength += 1;
    if (head == null) {
      head = node;
    }
    else {
      node.setNext(head);
      head = node;
    }
  }
  
  private boolean onTable(Card card) {
    //got help from Hailey Kester in lab
    TableNode temp = head;
    while (temp != null) {
      if (temp.getCard().equals(card)) {
        return true;
      }
      temp = temp.getNext();
    }
    return false;
  }
  
  private void removeCard(Card card) {
    //help from hailey kester in lab
    TableNode temp = findTemp(card);
    isLength -= 1;
    if (temp == null) {
      head = head.getNext(); 
    }
    else {
      TableNode john = temp.getNext();
      temp.setNext(john.getNext());
    }
  }
  
  private TableNode findTemp(Card card) {
    //help from hailey kester in lab
    TableNode temp = null;
    TableNode john = head;
    while (john != null) {
      Card johnCard = john.getCard();
      if (johnCard.equals(card)) {
        return temp;
      }
      temp = john;
      john = john.getNext();
    }
    return null;
  }
        
    
  public void removeSet(Card c1, Card c2 , Card c3) {
    //got help from Hailey Kester in lab
    TableNode temp = head;
    TableNode john = null;
    
    if (!c1.isSet(c2, c3)) {
      return;
    }
    if(!onTable(c1)) {
      return;
    }
    if(!onTable(c2)) {
      return;
    }
    if(!onTable(c3)) {
      return;
    }
    removeCard(c1);
    removeCard(c2);
    removeCard(c3);
    
        
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
    if (index >= isLength || temp == null) {
      return null;
    }
    
    if (index == 0) {
      return temp.getCard();
    }
    
    else {
      for (int i = 0; i < index; i++) {
        temp = temp.getNext();
      }
      return temp.getCard();
    }
  }
  
  public int numSets() {
    int theSet = 0;
    for (int a = 0; a < isLength - 2; a++) {
      for (int b = a + 1; b < isLength - 1; b++) {
        for (int c = b + 1; c < isLength; c++) {
          Card c1 = getCard(a);
          Card c2 = getCard(b);
          Card c3 = getCard(c);
          
          if(c1.isSet(c2, c3)) {
            theSet += 1;
          }
        }
      }
    }
    return theSet;
  }
}