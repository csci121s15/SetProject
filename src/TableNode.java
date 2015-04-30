public class TableNode
{
  private Card card;
  private TableNode next;
  
  public TableNode(Card c)
  {
    card = c;
    next = null;
  }
  
  public void setNext(TableNode t)
  {
    next = t;
  }
  
  public TableNode getNext()
  {
    return next;
  }
  
  public Card getCard()
  {
    return card;
  }
}