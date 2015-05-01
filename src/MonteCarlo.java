public class MonteCarlo {
  public static void main (String[] args) {
    float setSum = 0;
    float gameSum = 0;
    
    for (int i = 0; i < 10000; i++ ) {
      Game g = new Game();
      setSum += g.numSets();
      while (!g.isGameOver()) {
        g.playRound();
      }
      gameSum += g.numCards();
    }
    System.out.println(setSum/10000);
    System.out.println(gameSum/10000);
  }
}
