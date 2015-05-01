public class SetSim{
  public static void main (String[] args) {
    double setCount = 0;
    double cardCount = 0;
    int SimGames = 1000;

    //Average sets loop. Took good notes in class!

    for (int i = 0; i <= SimGames; i++){
      
      Game G = new Game();
      setCount += G.numSets();
      
      while (G.isGameOver()){
        G.playRound();
      }
    }
    
    System.out.println("Average # of sets :"+ setCount / SimGames);
    
    //Average cards loops. Had to run separate games. Thanks for discussing it in class!
    
    for (int i = 0; i <= SimGames; i++){
      
      Game G = new Game();
      
      while (G.isGameOver()==true){
        G.playRound();
      }
      cardCount += G.numCards();
      i+= 1;
    }   
    
    System.out.println("Average # of cards:" + cardCount / SimGames);
  }
}