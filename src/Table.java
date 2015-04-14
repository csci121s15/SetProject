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
    if (head == null) {
      head = theNode;
    }
    else {
      theNode.setNext(head);
      head = theNode;
    }

  }
  
  public void removeSet(Card card1, Card card2, Card card3) {
    //If 3 cards don't form a set or if any of the cards are not on the table, return//
    //Otherwise: remove card1, card2, card3 preserving the relative order of the rest of the cards//
    TableNode burr = head;
    
    Card theCard1;
    Card theCard2;
    Card theCard3;
    
    if (card3.isSet(card1, card2) != true) {
      return; 
    }
    else if (card3.isSet(card1, card2) == true) {
      theCard1 = null;
      theCard2 = null;
      theCard3 = null;
    }
   //Had a lot of trouble with removeSet//
    while (burr != null) {
      if (burr.getCard() == card1)
        theCard1 = card1;
      if (burr.getCard() == card2)
        theCard2 = card2;
      if (burr.getCard() == card3)
        theCard3 = card3;
      
      burr = burr.getNext();
    }
    while (burr == null) {
      if (burr.getCard() != card1)
        theCard1 = card1;
      if (burr.getCard() != card2)
        theCard2 = card2;
      if (burr.getCard() != card3)
        theCard3 = card3;
    }
    
  
    
        
  }
  
  public int numCards() {
    //If we haven't stored the length of the list, we have to iterate through the list and count the cards (while loop)//
    TableNode ref = head; 
    int theCards = 0;
    if (ref == null) {
      return 0;
    }
    while (ref != null) {
      theCards += 1; 
      ref = ref.getNext();
    }
    return theCards;
  }
    
  
  public Card getCard(int index) {
    //Iterate through the list index number of times, return the node there//
    //If index is out of bounds, return null//
    TableNode app = head;
    if (app == null) {
      return null;
    }
  
    if (index == 0) {
      return app.getCard();
    }
    else if (index != 0) {
      return null;
    }
    else {
      for (int i = 0; i < index; i++) {
        app = app.getNext();
      }
     return app.getCard();
    }
     
  }
  
  
  public int numSets() {
    //Get all triples of cards on the table and check isSet on each one (3 deep nested loop)//
    TableNode card1 = head;
    TableNode card2 = head;
    TableNode card3 = head;
    int theSetIs = 0;
    for (int m = 0; m < theLength - 2; m++) {
      for (int n = 1; n < theLength - 1; n++) {
        for (int p = 2; p < theLength; p++) {
         
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


   