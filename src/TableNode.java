public class TableNode {
  private Card card;
  private TableNode next;
  
  public TableNode(Card c) {
    card = c;
    next = null;
  }
  
  public void setNext(TableNode node) {
    next = node;
  }
  
  public TableNode getNext() {
    return next;
  }
  
  public Card getCard() {
    return card;
  }
}