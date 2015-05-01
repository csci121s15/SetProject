public class MonteCarloSim {
  public static void main(String[] args) {
    double countSet = 0;
    double countCard = 0;
    int simulation = 10000;
    
    for (int i = 0; i < simulation; i++) {
      Game g = new Game();
      countSet += g.numSets();
      
      while (g.isGameOver() == false) {
        g.playRound();
      }
      countCard += g.numCards();
    }
    System.out.println("The average number of sets is:" + countSet/simulation);
    System.out.println("The average number of cards is:" + countCard/simulation);
  }
}
    
    