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
  
  public void removeSet(Card card1, Card card2, Card card3) {
    if (card1.isSet(card2, card3) == false) {
      return;
    }
    TableNode temp = head;
    Card cardnum1 = null;
    Card cardnum2 = null;
    Card cardnum3 = null;
    
    while(temp !=null) {
      if(temp.getCard() == card1) {
        temp = temp.getNext();
        card1 = null;
      }
    }
  }
    
    //while (curr != null) {
      //if (curr.getCard() == card1) {
        //cardnum1 = card1;
     // }
      //if (curr.getCard() == card2) {
        //cardnum2 = card2;
      //}
      //if (curr.getCard() == card3) {
        //cardnum3 = card3;
      //}
      //curr = curr.getNext();
    //}
    
   // while (curr == null) {
      //if (curr.getCard() != card1) {
        //cardnum1 = card1;
      //}
      //if (curr.getCard() != card2) {
        //cardnum2 = card2;
      //}
      //if (curr.getCard() != card3) {
        //cardnum3 = card3;
      //}
    //}
  //}
  
  public int numCards() {
    TableNode temp = head;
    int card = 0;
    if (temp == null) {
      return 0;
    }
    else {
      while (temp != null) {
        card += 1;
        temp = temp.getNext();
      }
      return card;
    }
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
  
  public int numSets() {
   TableNode card1 = head;
   TableNode card2 = head;
   TableNode card3 = head;
   int setnum = 0;
   for (int a = 0; a < length - 2; a++) {
     for (int b = 1; b < length - 1; b++) {
       for (int c = 2; c < length; c++){
         
         Card carda = getCard(a);
         Card cardb = getCard(b);
         Card cardc = getCard(c);
         if(carda.isSet(cardb, cardc)) {
           setnum += 1;
         }
       }
     }
   }
   return setnum;
  }
}
