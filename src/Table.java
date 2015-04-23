public class Table {
  private TableNode head;
  private int amount;
  
  public Table() {
    head = null;
  }
  
  public void add(Card marlon) {
    TableNode newNode = new TableNode(marlon);
    newNode.setNext(head);
    head = newNode;
  }
  
  private boolean onTable(Card m){
    TableNode curr = head;
    
    while(curr != null){
      if(m.equals(curr.getCard())){
        return true;
      }
      else{
       curr = curr.getNext();
      }
    }
    return false;
  }
  private void removeCard(Card m){
    if (head == null)
    return;
    TableNode prev = null;
    TableNode curr = head;
    if (m.equals(head.getCard()))
      head = head.getNext();  
    else{
      while(!m.equals(curr.getCard())){
        prev = curr;
        curr = curr.getNext();
      }
      prev.setNext(curr.getNext());
    }
  }

      
    
      
  
  public void removeSet(Card m1, Card m2, Card m3) {
    if(m1.isSet (m2, m3) == false)
      return;
    if(!onTable(m1))
      return;
    if(!onTable(m2))
      return;
    if(!onTable(m3))
      return;
    removeCard(m1);
    removeCard(m2);
    removeCard(m3);
  }
        
  
  public int numCards(){
    TableNode temp = head;
    amount = 0;
    if(head == null)
      return 0;
    while(temp != null)
    {
      amount++;
      temp = temp.getNext();
    }
    return amount;
  }
  
  public Card getCard(int index) {
    TableNode curr = head;
    if(head == null)
      return null;
    if(index < numCards())
    {
      for(int i = 0; i<index; i++)
      {
       curr = curr.getNext();
      }
      return curr.getCard();
    }
    else
      return null;
  }
  
  public int numSets() {
    TableNode m = head;
    TableNode mm = null;
    TableNode mmm = null;
    int numSets = 0;
    
    while(m != null && m.getNext() != null && m.getNext().getNext() != null){
      mm = m.getNext();
      while(mm != null && mm.getNext() != null){
        mmm = mm.getNext();
        while(mmm != null){
          if(m.getCard().isSet(mm.getCard(),mmm.getCard()))
            numSets++;
          mmm = mmm.getNext();
        }
        mm = mm.getNext();
      }
      m = m.getNext();
    }
    return numSets;
  }
}