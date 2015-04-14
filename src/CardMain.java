import java.util.ArrayList;

public class CardMain{
  public static void main(String[] args){
//    Deck d = new Deck("81cards.txt");
//    for (int i=0; i<81; i++) {  
//      System.out.print(i + " ");
//    System.out.print(d.getSize() + " ");
//      System.out.print(d.hasNext() + " ");
//      System.out.println(d.getNext());
//    }
    
    Table t = new Table();
    Card c = new Card(1,1,1,1);
    Card c2 = new Card(2,2,2,2);
    Card c3 = new Card(3,3,3,3);
    t.add(c);
    t.add(c2);
    t.add(c3);
    System.out.println(t.getCard(0));






//   System.out.println("Hello");
//   Card c = new Card(20,7,0,8);
//   Card d = new Card(20,7,0,8);
//   Card e = new Card(20,7,0,8);
//     
//   System.out.println(c.getQuantity());
//   System.out.println(c.getColor());
//   System.out.println(c.getShading());
//   System.out.println(c.getShape());
//   System.out.println(c.toString());
//   String a = "heyy";
//   System.out.println(a + c);
//   System.out.println(c.isSet(d, e));
//   System.out.println("yeah!");

//   for (int i = -1; i<=2147483647; i++) {
//     int j = i;
//     j = (((j % 3)+3)%3)+1;
//     if (j < 1 || j > 3) {
//       System.out.println(i + " fuck");
//   }
//     if(i==500000000){
//       System.out.println("booty thumper");
//     }
//     if(i==1000000000){
//       System.out.println("jungle boogie");
//     }
//     if(i==2000000000){
//       System.out.println("jungle booger");
//     }
//     if(i==2007000000){
//       System.out.println("almost!");
//     }
//     if(i==2100000000){
//       System.out.println("ALMOST!");
//     }
//     if(i==2147483646){
//       System.out.println("THER WE ARE GOOD SHOW");
//     }
//   }
//   System.out.println("DONE");
  }
}