public class Table{
  private TableNode head;
  private int length;
  
  public Table(){
    head = null;
    length = 0;
  }
  
  public void add(Card A) {
    TableNode tempNode = new TableNode(A);
    tempNode.setNext(head); 
    head = tempNode;
  }
  
  public void removeSet(Card A, Card B, Card C){
    
    TableNode cp = head;
    
    if (A.isSet(B, C) == false) {
      
      return;
    }
    
    else if (A.isSet(B, C)) {
      
     A = null;
     B = null;
     C = null;
     
    }
  
    else {
      
      return;
    }
    
  }
  
  public int numCards(){
    TableNode curr = head;
    int numCardCount = 0;
    
      if (curr == null){
      return 0;
    }
      else {
    
    while (curr != null){
      curr = curr.getNext();
      numCardCount += 1;
    }
    return numCardCount;
  }
 }
  
  public Card getCard (int index) {
    TableNode cp = head;
    
     if (cp == null){
      return null;
     }
     
     else {
       
    for (int i = 0; i < index; i++){
        cp = cp.getNext();
    }
    
     }

     return cp.getCard();
  }
 
  
  public int numSets()
  {
    int numSetCount = 0;
    TableNode cp = head;
   
    while (cp != null && cp.getNext() != null && cp.getNext().getNext() != null)
    {
      TableNode cp2 = cp.getNext();
     
      while (cp2 != null && cp2.getNext() != null)
      {
        TableNode cp3 = cp2.getNext();
       
        while (cp3 != null)
        {
          if (cp.getCard().isSet(cp2.getCard(), cp3.getCard()) == true)
            numSetCount += 1;
         
          cp3 =cp3.getNext();
        }
       
        cp2 = cp2.getNext();
      }
     
      cp = cp.getNext();
    }
    return numSetCount;
  }
}