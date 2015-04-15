
public class Table {
  
  private TableNode head;
  
  Table() {
    head = null;
  }
  
  public void add(Card card) {
    TableNode newTableNode = new TableNode(card);
    if (head == null) {
      head = newTableNode;
    }
    else {
      newTableNode.setNext(head);
      head = newTableNode;
    }
  }
  
  private boolean cardInList(Card card) {
    TableNode tableNode = head;
    boolean foundCard = false;
    while (tableNode != null && !foundCard) {
      if (tableNode.getCard().equals(card))
        foundCard = true;
      else {
        tableNode = tableNode.getNext();
      }
    }
      return foundCard;
  }
  
  private void removeCard(Card card) {
    TableNode curr = head;
    //deleting from the beginning of the list
    if (card.equals(curr.getCard())) {
      curr = curr.getNext();
    }
    
    //deleting from the end of the list
    else if (!card.equals(curr.getCard())) {
      for (int i = 0; i <= numCards()-1; i++)
        curr.getNext();
      curr.setNext(null);
    }
  }
             
  public void removeSet(Card c1, Card c2, Card c3) {
    boolean isSet = c1.isSet(c2, c3);
    boolean c1InList = cardInList(c1);
    boolean c2InList = cardInList(c2);
    boolean c3InList = cardInList(c3);
    
    if (isSet && c1InList && c2InList && c3InList) {    
      removeCard(c1);
      removeCard(c2);
      removeCard(c3);
      
    //else {
        //return;
      //}
    }
  }
  
  public int numCards() {
    int numCards = 0;
    TableNode tableNode = head;
    if (head == null)
      return 0;
    
    while (tableNode != null) {
      tableNode = tableNode.getNext();
      numCards++;
    }
    return numCards;
  }
  
  public Card getCard(int stopIndex) {
    TableNode tableNode = head;
    if (tableNode == null)
      return null;
    
    else if (stopIndex == 0) {
      return tableNode.getCard();
    }
        
    for (int currIndex = 0; currIndex < stopIndex; currIndex++) {
      tableNode = tableNode.getNext();
    }
    return tableNode.getCard();   
  }

  
  public int numSets() {
    int numSets = 0;
    int numCards = numCards();
    
    for (int i = 0; i < numCards-2; i++) {
      for (int j = i + 1; j < numCards-1; j++) {
        for (int k = j + 1; k < numCards; k++) {          
          Card c1 = getCard(i);
          Card c2 = getCard(j);
          Card c3 = getCard(k);
          
          if (c1.isSet(c2, c3))
            numSets++;
          
        }
      }
    }
    return numSets;
  }
  
}
         