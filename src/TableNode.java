public class TableNode{
    private Card card;
    private TableNode next;
    
    public TableNode(Card newCard){
        //should set card to given parameter and next field to null
      card = newCard;
      next = null;
    }
    
    public void setNext(TableNode newNext){
        next = newNext;
    }
    
    public TableNode getNext(){
        return next;
    }
    
    public Card getCard(){
        return card;
    }
    
}
