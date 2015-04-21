public class CardMain{
  public static void main(String[] args){

    Game g = new Game();
    System.out.println(g.numCards());
    System.out.println(g.numSets());
    g.playRound();
    System.out.println(g.numSets());
  }
}



