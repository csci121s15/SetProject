public class MonteCarlo{
  
  public static void main (String [] args){
    question1();
    question2(); 
    
  }
  public static void question1(){
    int numTrials = 1000;
    int[] results = new int[numTrials];
    for(int i = 0; i < numTrials; i++){
      Game x = new Game();
      results[i] = x.numSets();
    }
    double sum = 0;
    for(int i = 0; i < numTrials; i++){
      sum += results[i];
    }
    double average = sum/numTrials;
    System.out.println("Question 1");
    System.out.println("The number of trials was: " + numTrials);
    System.out.println("The average number of sets in 12 cards was: " + average); 
  }
  
  public static void question2(){
    int numTrials = 1000;
    int[] results = new int[numTrials];
    for(int i =0; i < numTrials; i++){
      Game x = new Game();
      while(!x.isGameOver()){
       x.playRound(); 
      }
      results[i] = x.numCards();     
    }
    double sum = 0;
    for(int i = 0; i < numTrials; i++){
      sum += results[i];
    }
    double average = sum/numTrials;
    System.out.println("Question 2");
    System.out.println("The number of trials was: " + numTrials);
    System.out.println("The average number of cards left at the end: " + average); 
  }
  
}