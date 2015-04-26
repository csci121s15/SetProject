public class Game{
  private Table t;
  private Deck d;
  
  public Game(){
    d = new Deck(); 
    t = new Table();
    for (int i = 0; i < 12; i++){
      t.add(d.getNext());
    }
  }
  
  public Game(String filename){
    t = new Table();
    d = new Deck(filename);
    
    while (d.hasNext() == true){
      t.add(d.getNext());
      
      if (t.numCards() > 11){
      return;
      }
    }
  }
  
  public int numSets(){
    return t.numSets();
  }
  
  public int numCards(){
    return t.numCards();
  }
  
  public void playRound(){
    if (d.hasNext() == true && t.numSets() == 0){
      for (int i = 0; i < 3; i++){
        if (d.hasNext() == false)
          t.add(d.getNext());
        }
        return;
    }
  
   else if (d.hasNext() == true && t.numSets() != 0){
    for (int x = 0; x < t.numCards() - 2; x++){
      for (int y = x + 1; y < t.numCards() - 1; y++){
        for (int z = y + 1; z < t.numCards(); z++){
          if (t.getCard(x).isSet(t.getCard(y), t.getCard(z))){
            t.removeSet(t.getCard(x), t.getCard(y), t.getCard(z));
            return;
            }
           }
          }
         }
    return;
        }
       }    
  
  public boolean isGameOver(){
    if (d.hasNext() == false && t.numSets() == 0){
      return true;
    }
    else{
      return false;
    }
  }
}