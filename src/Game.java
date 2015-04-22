public class Game{
  private Table t;
  private Deck d;
  
  public Game(){
    Deck d = new Deck();
    Table t = new Table();
  }
  
  public Game(String name){
    
  }
  
  public int numSets(){
    return 0;
  }
  
  public int numCards(){
    return 0;
  }
  
  public void playRound(){
    
  }
  
  public boolean isGameOver(){
    return true;
  }
}