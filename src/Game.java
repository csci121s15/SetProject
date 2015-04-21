public class Game{
  private Table t;
  private Deck d;
  
  public Game(){
    //begins with randomly generated deck of 12 cards
    Deck d = new Deck();
    for (int i = 0; i<12; i++){
      d.getNext();
    }
  }
  
  public Game(String filename){
    //loads specific deck
    try {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null) {
        // Blank lines might contain white space, so trim it off
        line = line.trim();
        
        // ignore blank lines
        if(line.length() == 0)
          continue;
        
        // ignore comments
        if(line.startsWith("#"))
          continue;
            
        // a valid line contains 4 integers
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        int quantity = Integer.parseInt(tokenizer.nextToken());
        int color = Integer.parseInt(tokenizer.nextToken());
        int shading = Integer.parseInt(tokenizer.nextToken());
        int shape = Integer.parseInt(tokenizer.nextToken());
        
        cards.add(new Card(quantity, color, shading, shape));
        nextCardIndex = 0;
      }
    }
    catch(Exception e) {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
  
  public int numSets(){
    //returns number of sets on the table
    return t.numSets();
  }
  
  public int numCards(){
    //returns number of cards on table which is 12 
    //or less if deck has lest than 12 cards
    return t.numCards();
  }
  
  public void playRound(){
    //used to advance game from one round to the next
    //
    //a round deals with removing one set 
    //and adding additional cards
    //
    //1.)when no sets on table but still cards in deck:
    //   this means just add 3 cards
    //2.)most of the time:
    //   cards in deck and 12 on table containing 1+ sets
    //     in this situation we move from one round
    //     to the next by removing one set and adding 3 cards
    //     to the table from the deck
    //3.)if a round starts with 12+ cards on table:
    //   (due to no sets)
    //   and theres is at least one set,
    //   then after removing a set we do not add cards
    //4.)if there is at least one set but no cards left:
    //   we move to next round by just removing set
    //5.)if no cards in deck or sets on table:
    //   game over
    //
    //6.)sometimes when you use custom decks:
    //   there may be only 1-2 cards remaining
    //   when you have to add cards to table
    //      in this case cards are added like normal
    //      and the table remains short a few cards

    

    //1.)
    if (t.numSets() == 0 && d.hasNext() == true){
      for (int i = 0; i < 3; i++){
        t.add(d.getNext());
      }
    }
    
    //2.)
    else if (t.numSets() > 0 && d.hasNext() == true){ 
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              for (int p = 0; p < 3; p++){
                t.add(d.getNext());
              break;
              }
            }
          }
        }
      }
    }
    
    //3.)
    else if (t.numCards() > 12 && t.numSets() > 0){
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              break;
            }
          }
        }
      }
    }
    
    //4.)
    else if (t.numSets() > 0 && d.hasNext() == false){
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              break;
            }
          }
        }
      }
    }
    
    //5.)
    else if (d.hasNext() == false && t.numSets() == 0){
      isGameOver();
    }
    
    //6.) may be a part of one of the previous
  }
  
  public boolean isGameOver(){
    //returns true only if there are no sets on table
    // and no cards in deck
    
    if (d.hasNext() == false && t.numSets() == 0){
      return true;
    }
    else {
      return false;
    }
  }
  

  
  
//end }
  //notes:
  //abstraction --- rely on methods of other classes
  //// getCard from table and then isSet from card
}