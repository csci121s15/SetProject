public class Game {
  private Deck d;
  private Table t;
  
  public Game (){
    d = new Deck();
    t = new Table();
    
    for(int i = 0; i<12; i++)
      t.add(d.getNext());
  }
  
  public Game(String str){
    d = new Deck(str);
    t = new Table();
    for (int i = 0; i < 12 && d.hasNext(); i++) 
      t.add(d.getNext());
  }
  
  public int numSets() {
    return t.numSets();
  }
  
  public int numCards(){
    return t.numCards();
  }
  
  public void playRound(){
    if (t.numSets() == 0 && d.hasNext() == true) {
      for (int i = 0; i < 3; i++) {
        if(d.hasNext() == true) {
          t.add(d.getNext());
        }
      }
      return;
    }
    if (d.hasNext() == true && t.numSets() != 0) {
      for (int mar1 = 0; mar1 < t.numCards() - 2; mar1++){
        for (int mar2 = mar1 + 1; mar2 < t.numCards() - 1; mar2++){
          for (int mar3 = mar2 + 1; mar3 < t.numCards(); mar3++){
            
            if (t.getCard(mar1).isSet(t.getCard(mar2), t.getCard(mar3))){
              t.removeSet(t.getCard(mar1), t.getCard(mar2), t.getCard(mar3));
              
              while (t.numCards() < 12)
              {
                if (d.hasNext() == false)
                  return;
                
                t.add(d.getNext());
              }
              return;
            }
          }
        }
      }
    }
    
    if (t.numSets() != 0 && d.hasNext() == false){
      for (int mar1 = 0; mar1 < t.numCards() - 2; mar1++){
        for (int mar2 = mar1 + 1; mar2 < t.numCards() - 1; mar2++){
          for (int mar3 = mar2 + 1; mar3 < t.numCards(); mar3++){
            
            if (t.getCard(mar1).isSet(t.getCard(mar2), t.getCard(mar3))){
              t.removeSet(t.getCard(mar1), t.getCard(mar2), t.getCard(mar3));
              return;
            }
          }
        }
      }
      return;
    }
  }
  
  
  
  
  public boolean isGameOver()
  {
    if (d.hasNext() == false && t.numSets() == 0)
      return true;
    
    return false;
  }
}




