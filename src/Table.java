public class Table{
  private TableNode head;
  private int length;
  
  public Table(){
    head = null;
    length = 0;
  }
  
  public void add(Card c1){
    TableNode tempNode = new TableNode(c1);
    tempNode.setNext(head); 
    head = tempNode;
  }
  
  public void removeSet(Card c1, Card c2, Card c3){
    TableNode curr = head;
    if (c1.isSet(c2, c3) == false){
      return;
    }
    else if (c1.isSet(c2, c3)){
     
     c1 = null;
     c2 = null;
     c2 = null;
    }
    else{
      return;
    }
  }
  
  public int numCards(){
    TableNode curr = head;
    int cardCount = 0;
    
      if (curr == null){
      return 0;
    }
      else{
    
    while (curr != null){
      curr = curr.getNext();
      cardCount += 1;
    }
    return cardCount;
  }
 }
  
  public Card getCard(int index){
    TableNode curr = head;
    
     if (curr == null){
      return null;
     }
     else{
    for (int i = 0; i < index; i++){
        curr = curr.getNext();
    }
     }

     return curr.getCard();
  }
 
  
  public int numSets(){
    TableNode curr = head;
    TableNode curr2 = curr.getNext();
    TableNode curr3 = curr2.getNext();
    int setCount = 0;
    if (curr.getCard().isSet(curr2.getCard(), curr3.getCard()) == true){     
      setCount +=1;
     }
    return setCount;
 }
}
 