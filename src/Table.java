public class Table{
    private TableNode head;
    
    public Table(){
        head = null;
    }
    
    public void add(Card newCard){
        //new cards should be added to the front of the list
        
        TableNode newTableNode = new TableNode(newCard);
        
        // for an empty table
        if (head == null) {
            head = newTableNode;
        }
        
        else {
            newTableNode.setNext(head);
            head = newTableNode;
        }  
    }
    
    
    public void removeSet(Card card1, Card card2, Card card3){
      //removes set from table
      
      //makes sure they're a set
      if (card1.isSet(card2,card3) != true) {
        return;
      }
      
      //make sure the table isn't empty
      if (head == null) {
        return;
      }
      
      //check if they're on the table and if they are assign them to variables
      Card firstCard = null; 
      Card secondCard = null;
      Card thirdCard = null;
      
      //temp traverses through the list
      TableNode temp = head;
      TableNode prev = head;
      int i = 0;
      //goes through list
      while (temp != null) {
        //check for first card 
        
        //make instance of card class
        //Card c = new Card
        
        //THIS IS WHERE THE PROBLEM OCCURS 
        //temp.getCard() is equal to 1ROO, as is card1
        // when I run it through the debugger it confirms this, 
        // however the if statement seems to ignore this
        // and procedes to move to the else statement, 
        // but for some reason it will recognize the
        // second card that is also equal to 1ROO when temp is 
        // equal to its Node to it in the linked list.
        if (card1.equals(temp.getCard())) {
          firstCard = card1;
          //temp = head;
          //check for second
          //while (temp != null) {
        }
        else if (card2.equals(temp.getCard())) {
          secondCard = card2;
              //temp = head;
              //check for third
              //while (temp != null) {
        }
        else if (card3.equals(temp.getCard())) {
          thirdCard = card3;
        }
                //else {
                 // temp = temp.getNext();
             //   }
           //   }
           // }
            //else {
             // temp = temp.getNext();
       //     }
       //   }
      //  }
        else {
          temp = temp.getNext();
        }
      }
      
      //if all cards are on table variables will equal cards given in parameter
      if (firstCard == card1 && secondCard == card2 && thirdCard == card3) {

        //sets the temp back to the head
          temp = head;
          prev = head;
          
            //loop until end to remove cards
            while (temp.getNext() != null) { 
              //1st card: for removing head or middle
              if (temp.getCard() == card1){
                if (temp == head){
                  head = temp.getNext();
                  prev = head;
                  temp = head;
                }
                else {
                  temp = temp.getNext();
                  prev.setNext(temp);
                }
              }
              else {
                temp = temp.getNext();
                if (prev != head){
                  prev=prev.getNext();
                }
              }
            }
            
            //for last card
            if (temp.getNext()==null) {
              if (temp.getCard() == card1){
                prev.setNext(null);
              }
              //might not need to be here
              else {
                while (temp.getNext() != null) { 
                  //2nd card: for removing head or middle
                  if (temp.getCard() == card2){
                    if (temp == head){
                      head = temp.getNext();
                      prev = head;
                      temp = head;
                    }
                    else {
                      temp = temp.getNext();
                      prev.setNext(temp);
                    }
                  }
                  else {
                    temp = temp.getNext();
                    if (prev != head){
                      prev=prev.getNext();
                    }
                  }
                }
                
                //for last card
                if (temp.getNext()==null) {
                  if (temp.getCard() == card2){
                    prev.setNext(null);
                  }
                  //might not need to be here
                  else {
                    while (temp.getNext() != null) { 
                      //2nd card: for removing head or middle
                      if (temp.getCard() == card2){
                        if (temp == head){
                          head = temp.getNext();
                          prev = head;
                          temp = head;
                        }
                        else {
                          temp = temp.getNext();
                          prev.setNext(temp);
                        }
                      }
                      else {
                        temp = temp.getNext();
                        if (prev != head){
                          prev=prev.getNext();
                        }
                      }
                    }
                    
                    //for last card
                    if (temp.getNext()==null) {
                      if (temp.getCard() == card2){
                        prev.setNext(null);
                      }
                      //might not need to be here
                      else {
                        return;
                      }
                    }
                  }
                }
                  }
                }
              }
      //if cards are not on table the method ends
      else {
        return;
      }
    }
    
    
    
    public int numCards(){
        //returns number of cards on table
        TableNode temp = head;
        int i = 0;
        if (head == null) {
            return 0;
        }
        else{
            while (temp != null) {
                i += 1;
                temp = temp.getNext();
            }
            return i;
        }
    }
    
    public Card getCard(int index){
      // parameter is the index although it will remove the (n-1)th card on the table
        //returns card at given int
 
        TableNode temp = head;
        if (temp == null) {
            return null;
        }
        if (index == 0) {
            return temp.getCard();
        }
        else {  // this may cause errors maybe change to j < index
          for (int j = 0; j<index; j++){
            temp = temp.getNext();
            }
          if (temp == null) {
            return null;
          }
          else {
            return temp.getCard();
          }
        }
    }
    
    public int numSets(){
        //returns the number of Sets on the table
      int sets = 0;
      int numCards = numCards();

        for (int i=0; i<numCards-2; i++) {
            for (int j=i+1; j<numCards-1; j++){
                for (int k=j+1; k<numCards; k++){
                  
                        Card card1 = getCard(i);
                        Card card2 = getCard(j);
                        Card card3 = getCard(k);
                  
                  if (card1.isSet(card2,card3)) {
                    sets += 1;
                  }
                }
            }
        }
        return sets;
    }
    
    //end
}