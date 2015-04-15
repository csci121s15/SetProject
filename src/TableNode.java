public class TableNode {
  private Card card;
  private TableNode next;

  public TableNode(Card a) {
    card = a;
    next = null;
  }
  
  public TableNode getNext() {
    return next;
  }
  
  public void setNext(TableNode newNext) {
    next = newNext;
  }
  
  public Card getCard() {
    return card;
  }
}
