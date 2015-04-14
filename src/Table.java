public class Table{
    private TableNode head;
    private int theLength;
    
    public Table(){
        head = null;
        theLength = 0;
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
      
      TableNode temp = head;
      TableNode prev = head;
      TableNode newNext = head;
      
      /// for an empty list
      if (head == null) {
        break;
      }
      
      else {
        
        ///if you're removing the head first GET RID OF THIS MAYBE
        if (temp.getCard == card1 || temp.getCard == card2 || temp.getCard == card3){
          head = temp.getNext();
          temp = head;
          prev = head;
          newNext = head;
          //loop until end.
          while (temp.getNext != null) { 
            //for removing head first
            if (temp.getCard == card1 || temp.getCard == card2 || temp.getCard == card3){
              head = temp.getNext();
              prev = head;
              temp = head;
              newNext = head;
              
              // this can probably go too
              if (temp.getCard == card1 || temp.getCard == card2 || temp.getCard == card3){
                head = temp.getNext();
                prev = temp;
                temp = head;
              }
            }
            else {
              prev = temp;
              temp = temp.getNext();
              newNext = head;
              
            }
          }
          ///FROM SORTED LINKED LIST NEEDS TO BE CHANGED
          if (temp.getNext() == null){
            if (temp.getCard == card1 || temp.getCard == card2 || temp.getCard == card3){
              prev.setNext(null);
            }
            //adds to the end
            else {
              temp.setNext(newNode);
            }
          }
          ///FROM SORTED LINKED LIST NEEDS TO BE CHANGED
        }
              
         
        }
        
        ///otherwise
        else{
          temp = temp.getNext();
          
          if (temp.getCard == card1 || temp.getCard == card2 || temp.getCard == card3){
            newNext = temp.getNext();
            prev.setNext(newNext);
          }
          
          //if the head is the only item
          if (temp == null){
            prev.setNext(newNode);
          }
        }
        //
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
      // find out if its asking for the index or for the nth card on the table
        //returns card at given int
 
        TableNode temp = head;
        if (temp == null) {
            return null;
        }
        if (index == 0) {
            return temp.getCard();
        }
        else {  // this may cause errors maybe change to j < index
          for (int j = 0; j==index; j++){
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
}