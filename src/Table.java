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

      //goes through list
      while (temp != null) {
        //check for first card 
        
        //make instance of card class
        
        //This if statement is where the infinite loop occurs
        if (card1.equals(temp.getCard())) {
          firstCard = card1;
          temp = temp.getNext();
        }
        else if (card2.equals(temp.getCard())) {
          secondCard = card2;
          temp = temp.getNext();
        }
        else if (card3.equals(temp.getCard())) {
          thirdCard = card3;
          temp = temp.getNext();
        }
        else{
          temp = temp.getNext();
        }
      }
      
      if (firstCard == null || secondCard == null || thirdCard == null) {
        return;
      }
      
      //if all cards are on table variables will equal cards given in parameter
      if (card1.equals(firstCard) && card2.equals(secondCard) && card3.equals(thirdCard)) {
        int i = 0;
        while(i < 3) {

          //sets the temp back to the head
          temp = head;
          prev = head;
          
          //loop until end to remove cards
          while (temp.getNext() != null && i < 3) {
            //for removing card at head or in middle
            if (card1.equals(temp.getCard()) || card2.equals(temp.getCard()) || card3.equals(temp.getCard())){
              if (temp == head){
                head = temp.getNext();
                prev = head;
                temp = head;
                i+=1;
              }
              else {
                temp = temp.getNext();
                prev.setNext(temp);
                i+=1;
              }
            }
            else {
              if (temp == head){
                temp = temp.getNext();
              }
              else{
                temp = temp.getNext();
                prev = prev.getNext();
              }
            }
          }
          
          //for last card
          if (temp.getNext()==null) {
            if (card1.equals(temp.getCard()) || card2.equals(temp.getCard()) || card3.equals(temp.getCard())){
              if (head.getNext()==null){
                head=null;
                i+=1;
              }
              else{
              prev.setNext(null);
              i+=1;
              }
            }
            //might not need to be here
            else {
              return;
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