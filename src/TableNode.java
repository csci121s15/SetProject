public class TableNode
{
  Card card;
  TableNode next;
  
  public TableNode(Card card1)
  {
    card = card1;
    next = null;
  }
  
  public void setNext(TableNode node)
  {
    next = node;
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