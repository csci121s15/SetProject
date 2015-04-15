public class TableNode {
  private Card card;
  private TableNode next;
  
  public TableNode(Card c1) {
    
    card = c1;
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