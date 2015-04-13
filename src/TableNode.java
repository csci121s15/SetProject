public class TableNode{
  private Card card;
  private TableNode next;
  
  public TableNode(Card){
    //should set card to given parameter and next field to null
    next = null;
  }
  
  public void setNext(Node newNext){
    next = newNext;
  }
    
  public TableNode getNext(){
    return next;
  }
  
  public Card getCard(){
    return Card;
  }
  
}
