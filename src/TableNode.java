public class TableNode {
  private Card card;
  private TableNode next;
  
  public TableNode(Card card1) {
    card = card1;
    next = null;
  }
  
  public void setNext(TableNode nextcard) {
    next = nextcard;
  }
  
  public TableNode getNext() {
    return next;
  }
  
  public Card getCard() {
    return card;
  }
}