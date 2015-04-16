public class Table {
  private TableNode head;
  
  public Table() {
    head = null;
  }
  
  public void add(Card card) {
    TableNode newNode = new TableNode(card);
    newNode.setNext(head);
    head = newNode;
  }
  
  public void removeSet(Card card1, Card card2, Card card3) {
        
    if(!(card1.isSet(card2, card3))) {
      return;
    }
    
    if(head == null) {
      return;
    }
    
    if(!(findMatch(card1) && findMatch(card2) && findMatch(card3))) {
      return;
    }
    
    removeCard(card1);
    removeCard(card2);
    removeCard(card3);
  }

    //TableNode temp = head;
//    System.out.println(numCards());
//    //int count = 0;
//    //while(count < numCards() - 1 && head.getNext() != null) {
//    
//    while(head.getNext() != null) {      
//      
//      int g = 0;
//      TableNode node = head;  
//      while(node != null) {
//        System.out.println(node.getCard());
//        g += 1;
//        node = node.getNext();
//        
//      }
//      System.out.println("t");
//      
//      while(head.getNext().getCard() == card1 || 
//            head.getNext().getCard() == card2 || 
//            head.getNext().getCard() == card3) {
//        System.out.println("test");
//        if(head.getNext().getNext() != null) {
//          head.setNext(head.getNext().getNext());
//        }
//        else {
//          break;
//        }
//      }
//    head = head.getNext();
//    //count += 1;
//    //System.out.println(count);
//    }
//    System.out.println(numCards());
//      int e = 0;
//      TableNode d = head;  
//      while(d != null) {
//        System.out.println(d.getCard());
//        e += 1;
//        d = d.getNext();
//        
//      }
//  }
//    TableNode temp = head;
//    System.out.println(numCards());
//    int count = 0;
//    while(count < numCards() || head != null) {
//      System.out.println("test");
//      while(temp.getCard() == card1 || 
//            temp.getCard() == card2 || 
//            temp.getCard() == card3) {
//        System.out.println(temp);
//        System.out.println(temp.getNext());
//        temp = temp.getNext();
//      }
////head.setNext(temp.getNext());
//      head = temp.getNext();
//      count += 1;
//    }
//  }

  

//    TableNode node = head;
//    
//    System.out.println(numCards());
//    while(node != null && node.getNext() != node) {
//      if(node.getNext().getCard() == card1 || 
//         node.getNext().getCard() == card2 || 
//         node.getNext().getCard() == card3) {
//        node.setNext(node.getNext().getNext());
//      }
//      else {
//        node.setNext(node.getNext());
//      }
//      node = node.getNext();
//    }
//    System.out.println(numCards());
    
    //TableNode prev = findPrev(card1);
    //TableNode curr = prev.getNext();
    
  //  System.out.println("end of removeSet");
//    
//    // notes from lab
//    //printer void removeCard(Card c)
//    {
//    //remove(a/d(c1);
//    //...
//    //node prev = findPrev(c1)
//    //node curr = prevgetNext()
//    //if(prev==null) //head remove
//    // head = head.getNext()
//    //else // middle of tail remove
//    //if(!onTable(c1)) {
//    // return;
//    //Node curr prev.getNext();
//    //prev.setNext()(curr.getNext()).
    //getCard

//        //prev.setNext(curr.getNext());
//      }
////    if(node != null) {
////      node.setNext(node.getNext());
////    }
//    }
  

  public void removeCard(Card card) {
    TableNode prev = null;
    TableNode curr = head;
    if(head.getCard() == card) {
      head = head.getNext();
    }
    while(curr.getCard() != card || curr.getNext() != null) {
      prev = curr;
      if(curr.getNext() != null) {
        curr = curr.getNext();
      }
      else {
        break;
      }
    }    
    prev.setNext(curr.getNext());
  }
  
  
  // Check if card is in table
  public boolean findMatch(Card card) {
    for(int i = 0; i < numCards(); i++) {
      if(getCard(i).equals(card)) {
        System.out.println("Match found");
        return true;
      }
    }
    System.out.println("Match not found");
    return false;
  }
  
  public Card findPrev(Card card) {
    for(int i = 0; i < numCards(); i++) {
      if(getCard(i) == card) {
        return getCard(i - 1);
      }
    }
    return null;
  } 
  
  public int numCards() {
    int count = 0;
    TableNode node = head;  
    while(node != null) {
      count += 1;
      node = node.getNext();
    }
    return count;
  }
  
  public Card getCard(int index) {    
    TableNode loc = head;  
    if(index < numCards() && index >= 0) {
      for(int i = 0; i < index; i++) {
        loc = loc.getNext();
      }
      return loc.getCard();
    }
    else {
      return null;
    }
  }
  
  // 1 and 2 prevent repeats
  public int numSets() {
    int numSets = 0;
    for(int a = 0; a < numCards() - 2; a++) {
      for(int b = 1; b < numCards() - 1; b++) {
        for(int c = 2; c < numCards(); c++)
          if(getCard(a).isSet(getCard(b), getCard(c)) && 
        a < b && b < c) {
             numSets++;
        }
      }
    }
    return numSets;
  }
  
}
