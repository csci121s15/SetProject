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
      //check if they're on the table
      
      TableNode temp = head;
      TableNode prev = head;
      int i = 0;
      
      while (temp != null) {
        
        //check for first card
        if (temp.getCard() == card1) {
          i+=1;
          temp = head;
          prev = head;
          while (temp != null) {
            //only checks for second card if first is there
            if (temp.getCard() == card2) {
              i+=1;
              temp = head;
              prev = head;
              while (temp != null) {
                //only checks for third card if 1&2 are there
                if (temp.getCard() == card3) {
                  i+=1;
                  temp = head;
                  prev = head;
                }
                //3rd card check
                else {
                  temp = temp.getNext();
                }
              }
            }
            //2nd card check 
            else {
              temp = temp.getNext();
            }
          }
        }
        //moves through list for first card
        else {
          temp = temp.getNext();
        }
      }
      
      //if all cards are on the table i will equal 3
      if (i == 3) {

        //If they are on table.
          temp = head;
          prev = head;
          
          /// for an empty list
          if (head == null) {
            return;
          }
          
          else {
            //loop until end.
            while (temp.getNext() != null) { 
              //for removing head first
              if (temp.getCard() == card1 || temp.getCard() == card2 || temp.getCard() == card3){
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
              if (temp.getCard() == card1 || temp.getCard() == card2 || temp.getCard() == card3){
                prev.setNext(null);
              }
              //might not need to be here
              else {
                return;
              }
            }
          }
        }
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

        for (int i=0; i==numCards()-2; i++) {
            for (int j=1; j==numCards()-1; j++){
                for (int k=2; k==numCards(); k++){
                  
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