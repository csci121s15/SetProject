public class Table{
    private TableNode head;
    private int theLength;
    //  Card newCard = new Card();
    
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