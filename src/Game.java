public class Game{
  private Table t;
  private Deck d;
  
  public Game(){
    //begins with randomly generated deck of 12 cards
    Deck d = new Deck();
  }
  
  public Game(String filename){
    //loads specific deck
  }
  
  public int numSets(){
    //returns number of sets on the table
    return 0;
  }
  
  public int numCards(){
    //returns number of cards on table which is 12 
    //or less if deck has lest than 12 cards
    return 0;
  }
  
  public void playRound(){
    //used to advance game from one round to the next
    //
    //a round deals with removing one set 
    //and adding additional cards
    //
    //when no sets on table but still cards in deck:
    //   this means just add 3 cards
    //most of the time:
    //   cards in deck and 12 on table containing 1+ sets
    //     in this situation we move from one round
    //     to the next by removing one set and adding 3 cards
    //     to the table from the deck
    //if a round starts with 12+ cards on table:
    //   (due to no sets)
    //   and theres is at least one set,
    //   then after removing a set we do not add cards
    //if there is at least one set but no cards left:
    //   we move to next round by just removing set
    //if no cards in deck or sets on table:
    //   game over
    //
    //sometimes when you use custom decks:
    //   there may be only 1-2 cards remaining
    //   when you have to add cards to table
    //      in this case cards are added like normal
    //      and the table remains short a few cards
    //
  }
  
  public boolean isGameOver(){
    //returns true only if there are no sets on table
    // and no cards in deck
    return true;
  }
  
//end }
}