public class Game
{
 private Deck d;
 private Table t;
 
 public Game()
 {
  d = new Deck();
  t = new Table();
  
  for (int i = 0; i < 12; i++)
   t.add(d.getNext()); 
 }
 
 public Game(String str)
 {
   d = new Deck(str);
   t = new Table();
   
   while (d.hasNext() == true)
   {
     t.add(d.getNext()); 
     
     if (t.numCards() > 11)
       return;
   } 
 }
 
 public int numSets()
 {
   return t.numSets();
 }
 
 public int numCards()
 {
   return t.numCards();
 }
 
 public void playRound()
 {
   if (t.numSets() == 0 && d.hasNext() == true)
   {
     for (int i = 0; i < 3; i++)
     {
       if (d.hasNext() == false)
         return;
       
       t.add(d.getNext());
     }
     
     return;
   }
   
   else if (d.hasNext() == true && t.numSets() != 0)
   {
     for (int j = 0; j < t.numCards() - 2; j++)
     {
       for (int k = j + 1; k < t.numCards() - 1; k++)
       {
         for (int l = k + 1; l < t.numCards(); l++)
         {
           if (t.getCard(j).isSet(t.getCard(k), t.getCard(l)) == true)
           {
             t.removeSet(t.getCard(j), t.getCard(k), t.getCard(l));
             
             while (t.numCards() < 12)
             {
               if (d.hasNext() == false)
                 return;
               
               t.add(d.getNext());
             }
             
             return;
           }
         }
       }
     }
   }
   
   else if (t.numSets() != 0 && d.hasNext() == false)
   {
       for (int j = 0; j < t.numCards() - 2; j++)
       {
         for (int k = j + 1; k < t.numCards() - 1; k++)
         {
           for (int l = k + 1; l < t.numCards(); l++)
           {
             if (t.getCard(j).isSet(t.getCard(k), t.getCard(l)))
             {
               t.removeSet(t.getCard(j), t.getCard(k), t.getCard(l));
               return;
             }
           }
         }
       }
     }
   
   return;
 }
 
 public boolean isGameOver()
 {
   if (d.hasNext() == false && t.numSets() == 0)
     return true;
   
   return false;
 }
}