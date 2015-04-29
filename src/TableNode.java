public class TableNode {
  
  private Card card;
  private TableNode next; 
  
  public TableNode(Card z) {
    card = z;
    next = null;
    
  }
  
  public void setNext(TableNode b) {
   
    next = b;
  }
  
  public TableNode getNext() {
    
    return next;
    
  }
  
  public Card getCard() {
    
    return card;
  }
}