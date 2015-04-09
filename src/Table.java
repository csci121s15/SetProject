public class Table{
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card c) {
    
  }
  
  public void removeSet(Card c1, Card c2, Card c3) {
    
  }
  
  public int numCards() {
    return 0;
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
    return 0;
  }
}