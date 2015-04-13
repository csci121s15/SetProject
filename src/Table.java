public class Table{
  private TableNode head;
//  private int theLength;
  

  public Table()
    //
  {
    head = null;
//    theLength = 0;
  }
  public class Table{
  private TableNode head;
//  private int theLength;
  Card card = new Card();

  public Table()
    //
  {
    head = null;
//    theLength = 0;
  }
  
  public void add(Card){
    //new cards should be added to the front of the list
    
    TableNode newCard = new TableNode(Card);
    
    // for an empty table
    if (head == null) {
      head = newNode;      
    }
    
    else {
    newCard.setNext(head);
    head = newCard;
    }  
      
  }
  
  public void removeSet(Card, Card, Card){
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
    for (int j = 0; j<index; j++){
      temp = temp.getCard();
    }
     if (temp == null) {
        return null;
     }
     else {
        return temp.getCard();
     }
  }
  
  public int numSets(){
    //returns the number of Sets on the table
    for (int i=0; i==numCards-1; i++) {
      for (int j=1; j==numCards-1; j++){
        for (int k=2; k==numCards; k++){
          card.isSet(j,k);
        }
      }
    }
  }
}
  public void add(Card){
    //
  }
  
  public void removeSet(Card, Card, Card){
    //removes set from table
  }
  
  public int numCards(){
    //
  }
  
  public Card getCard(int index){
    //returns card at given int
  }
  
  public int numSets(){
    //returns the number of Sets on the table
  }
}