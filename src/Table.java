public class Table{ 
  private TableNode head = null;
  
  public void add(Card card ){ 
     TableNode newNode = new TableNode(card);
     newNode.setNext(head);
     head = newNode;
    
  }
  private boolean isOnTable(Card card){
   TableNode node = head;
    boolean foundMatch = false;
    while (node != null && !foundMatch) {
      if (node.getCard().equals(card)) {
        foundMatch = true;
      }
      else {
        node = node.getNext();
      }
    }
    return foundMatch;
  }
  
  private void removeCard(Card card){
    TableNode lastNode = null;
    TableNode node = head; 
    while (node != null) {
      if (node.getCard().equals(card)) {
        if (lastNode == null) {
          head = node.getNext();
        } else {
          lastNode.setNext(node.getNext());
        }
        return;
      }
      lastNode = node;
      node = node.getNext();
    } 
    
  }
   //removing a card but keeping track of where it is in an a linked list so that it can be called on later
   //if the 3 cards don't form a set or if any of the cards are not on the table, return
   //otherwise:
   //remove card1, card2, and card3, perserving the relative order of the rest of the cards
  public void removeSet(Card card1, Card card2, Card card3){
    if(!card2.isSet(card1, card3)){
      return;
    }
    if(!isOnTable(card1) || !isOnTable(card2) || !isOnTable(card3)){
      return;
    }
    removeCard(card1);
    removeCard(card2);
    removeCard(card3);
  }
  
  public int numCards(){
    int count = 0;
    TableNode node = head;
    while(node != null){
      count += 1;
      node = node.getNext();
    }
    return count;
  }
    //if we haven't stored the length of the list, we have to
    //iterate through the list and count the cards
    //using a while loop
    //gives me the length of the list
  
  //if index is out of bounds, return null
  //otherwise:
  //iterate through the list index number of times, return
  //the node there
  public Card getCard(int index){
    int length = numCards();
    if(head == null || index >= length){
     return null; 
    }else {
     TableNode temp = head;
     for(int i=0; i < index; i++){
      temp = temp.getNext();
     }
     return temp.getCard();
     }
    }
   //number of sets currently on the table
    //get all triples of cards on the table, and check isSet on each one
    //need a three deep nested loop!!
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
