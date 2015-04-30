public class Table {
  private TableNode head;
  private int theLength;
  
  public Table() {
    //intialize head//
    //intialized the length as well//
     head = null;
     theLength = 0;
    
  }
  
  public void add(Card theCard) {
    //head insert card//
    TableNode theNode = new TableNode(theCard);
    theLength += 1;
    if (head == null) {
      head = theNode;
    }
    else {
      theNode.setNext(head);
      head = theNode;
    }

  }
  
  private boolean theTable(Card theCard) {
    //Got a pointer from a friend in class//
    TableNode nerf = head;
    while (nerf != null) {
      if (nerf.getCard().equals(theCard)) {
        return true;
      }
      nerf = nerf.getNext();
    }
    return false;
  }
  
  private void removeCard(Card theCard) {
    //removeCard helps to set up for removeSet//
    TableNode nerf= findNerf(theCard);
    theLength -= 1;
    if (nerf == null) {
      head = head.getNext();
    }
    else {
      TableNode buff = nerf.getNext();
      nerf.setNext(buff.getNext());
    }
  }
  
  private TableNode findNerf(Card theCard){
    //in order for removeCard to work had to make a method of findNerf, which I used in removeCard//
    TableNode nerf = null;
    TableNode buff = head;
    
    while (buff != null) {
      Card buffCard = buff.getCard();
      if (buffCard.equals(theCard)) {
        return nerf;
      }
      nerf = buff;
      buff = buff.getNext();
    }
    return null;
  }
     
       
  
  public void removeSet(Card card1, Card card2, Card card3) {
    //Worked with John Ferguson in lab 4/23 to fix Table//
    //If 3 cards don't form a set or if any of the cards are not on the table, return//
    //Otherwise: remove card1, card2, card3 preserving the relative order of the rest of the cards//
    //since I made a removeCard method, I was able to use it in the removeSet method to help remove the cards from the set//
   TableNode nerf = head;
   TableNode buff = null;
   
   if (!card1.isSet(card2, card3)) {
     return;
   }
   
   if (!theTable(card1)) {
     return;
   }
   
   if (!theTable(card2)) {
     return;
   }
   
   if (!theTable(card3)) {
     return;
   }
   
   removeCard(card1);
   removeCard(card2);
   removeCard(card3); 
        
  }
  
  public int numCards() {
    //If we haven't stored the length of the list, we have to iterate through the list and count the cards (while loop)//
    TableNode nerf = head; 
    int theCards = 0;
    if (nerf == null) {
      return 0;
    }
    while (nerf != null) {
      theCards += 1; 
      nerf = nerf.getNext();
    }
    return theCards;
  }
    
  
  public Card getCard(int index) {
    //Iterate through the list index number of times, return the node there//
    //If index is out of bounds, return null//
    TableNode buff = head;
    if (index >= theLength || buff == null) {
      return null;
    }
  
    if (index == 0) {
      return buff.getCard();
    }
   
    else {
      for (int i = 0; i < index; i++) {
        buff = buff.getNext();
      }
     return buff.getCard();
    }
     
  }
  
  
  public int numSets() {
    //Get all triples of cards on the table and check isSet on each one (3 deep nested loop)//
    
    int theSetIs = 0;
    
    for (int m = 0; m < theLength - 2; m++) {
      for (int n = m + 1; n < theLength - 1; n++) {
        for (int p = n + 1; p < theLength; p++) {
         
          Card cardA = getCard(m);
          Card cardB = getCard(n);
          Card cardC = getCard(p);
          if (cardA.isSet(cardB, cardC)) {
            theSetIs += 1;
          }
          
        }
      }
    }     
   return theSetIs; 
  }
  
}


   