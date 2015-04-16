public class Table {
  private TableNode head;
  private int length;
  
  public Table() {
    head = null;
    length = 0;
  }
  
  public void add(Card card) {
    TableNode newNode = new TableNode(card);
    if (head == null) {
      head = newNode;
    }
    else {
      newNode.setNext(head);
      head = newNode;
    }
  }
  
  public boolean onTable(Card card){
    TableNode node = head;
    while (node != null) {
      if (node.getCard().equals(card)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }
 
 
  public void removeCard(Card card){
    TableNode newnode = null;
    TableNode node = head;
    while (node != null) {
      if (node.getCard().equals(card)) {
        if (newnode == null) {
          head = node.getNext();
        }
        else {
          newnode.setNext(node.getNext());
        }
        return;
      }
      newnode = node;
      node = node.getNext();
    }
  }
  
  public void removeSet(Card card1, Card card2, Card card3) {
    TableNode node = head;
    TableNode curr = null;
    
    if(!card1.isSet(card2, card3)){
      return;
    }
    if(!onTable(card1) || !onTable(card2) || !onTable(card3)){
      return;
    }
    removeCard(card1);
    removeCard(card2);
    removeCard(card3);
  }
  
  public int numCards() {
    TableNode temp = head;
    int numcount = 0;
    if (temp == null) {
      return 0;
    }
    while (temp != null) {
      numcount += 1;
      temp = temp.getNext();
    }
      return numcount;
  }
  
  public Card getCard(int index){
    TableNode temp = head;
    if(temp == null) {
      return null;
    }
    for(int t = 0; t < index; t++) {
      temp = temp.getNext();
      if(temp==null) {
        return null;
      }
    }
    return temp.getCard();
  }
  
  
  public int numSets(){
    int length = numCards();
    int count = 0;
    for(int i= 0; i < length; i++){
      Card icard = getCard(i);
      for(int j = i + 1; j < length; j++){
        Card jcard = getCard(j);
        for(int k = j + 1; k < length; k++){
          Card kcard = getCard(k);
          if(icard.isSet(jcard, kcard)){
            count++;
          }
        }
      }
    }
    return count; 
  }
}
