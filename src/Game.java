public class Game{
 private Table t;
 private Deck d;
 
 public Game (){
   d = new Deck();
   t = new Table();
   for(int i =0; i< 12; i++){
     t.add(d.getNext());
   }
   
 }
 
 public Game(String filename){
   d = new Deck(filename);
   t = new Table();
   for(int i = 0; i< 12 && d.hasNext(); i++){
     t.add(d.getNext());
     
   }
   
   
 }
 
 public int numSets(){
   return t.numSets();
 }
 
 public int numCards(){
   return t.numCards();
   
 }
 
 
 public void playRound(){
   if(isGameOver()){
    return; 
   } 
   if(numSets() != 0){
     boolean setRemoved = false;
     int length = numCards();
     for(int i= 0; i < length; i++){
       if(setRemoved){
         break; 
       }
       Card icard = t.getCard(i);
       for(int j = i + 1; j < length; j++){
         if(setRemoved){
           break; 
         }
         Card jcard = t.getCard(j);
         for(int k = j + 1; k < length; k++){
           if(setRemoved){
             break; 
           }
           Card kcard = t.getCard(k);
           if(icard.isSet(jcard, kcard)){
             t.removeSet(icard, jcard, kcard);
             setRemoved = true;
           }
         }
       }
     }
   }

   for(int i = 0; i < 3 && d.hasNext(); i++){
     t.add(d.getNext()); 
   }
   
    
 }
 
 public boolean isGameOver(){
   if(!d.hasNext() && t.numSets() == 0){ 
     return true;
   } else {
     return false;
   }
 }
 
}