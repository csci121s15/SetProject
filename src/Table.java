public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card wifi) {
      TableNode temp = new TableNode(wifi);
      temp.setNext(head);
      head = temp;
    }
  
  
  private boolean onTable(Card z) {
    TableNode curr = head;
    
    while(curr != null) {
      if(curr.getCard().equals(z)) {
        return true;
      }
      curr = curr.getNext();
    }
    return false;
  }
  
  public void removeSet(Card z1, Card z2, Card z3) {
    if(! z1.isSet(z2,z3))
      return;
    if(! onTable(z1))
      return;
    if(! onTable(z2))
      return;
    if( ! onTable(z3))
      return;
    removeCard(z1);
    removeCard(z2);
    removeCard(z3);
  }
  public TableNode findPrev(Card z) {
    TableNode jeans = head;
    TableNode yoga = null; 
    
    while( jeans!= null) {
      if(z.equals(jeans.getCard())) {
        return yoga;
      }
      else {
        yoga = jeans;
        jeans = jeans.getNext();
      }
    }
    return null;
  }

  private void removeCard(Card z) {
    TableNode prev = findPrev(z);

      if(prev == null)
      head = head.getNext();
    else {
      TableNode curr = prev.getNext();
      prev.setNext(curr.getNext());
    }
  }
   
  public int numCards() {
    TableNode curr = head;
    int plum = 0;
    while( curr != null) {
      plum +=1;
      curr = curr.getNext();
    }
    return plum;
  }
  
  public Card getCard( int index) {
    TableNode z = head;
    
    if(z == null) {
      return null; 
    }
    
    for(int i = 0; i < index; i++) {
      z = z.getNext();
      
      if(z == null)
        return null;
    }
    return z.getCard();
  }
    
  public int numSets() {
    int length = numCards();
    int yeet = 0;
    
    for( int i = 0; i < length -2; i++) {
      for(int j = i +1; j < length-1; j++) {
        for(int k = j +1; k < length; k++) {
          Card z1 = getCard(i);
          Card z2 = getCard(j);
          Card z3 = getCard(k);
          
          if (z1.isSet(z2,z3)) {
           yeet +=1;
             
        }
      }
    }
  }
    return yeet;
  }
}
