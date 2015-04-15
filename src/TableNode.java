public class TableNode {
  
  private Card card;
  private TableNode next;
  
  TableNode(Card card) {
    this.card = card;
    next = null;
  }
  
  public void setNext(TableNode newNext) {
    next = newNext;
  }
  
  public TableNode getNext() {
    return next;
  }
  
  public Card getCard() {
    return card;
  }

}
    
    
   