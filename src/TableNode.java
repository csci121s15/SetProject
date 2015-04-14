public class TableNode {
  private Card card;
  private TableNode next;
  
  public TableNode(Card superFantasticCard) {
    card = superFantasticCard;
    next = null;
  }
  
  public void setNext(TableNode theNext) {
    next = theNext;
    
  }
  
  public TableNode getNext() {
    return next;
    
  }
  
  public Card getCard() {
    return card;
    
  }
  
}

  