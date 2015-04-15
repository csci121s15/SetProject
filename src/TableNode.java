public class TableNode {
  private Card card;
  private TableNode next;
 
  public TableNode(Card x){
   next = null;
   card = x;
  }
                   
  public TableNode getNext(){
    return next;
  }
  
  public void setNext(TableNode node){
    next = node;
  }
  
  public Card getCard(){
    return card;
  }
}