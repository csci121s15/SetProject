public class Card{
  private int quantity;
  private int color;
  private int shading;
  private int shape; 
  
  public Card(int cardQuantity, int cardColor, int cardShading, int cardShape){
    quantity = ((((cardQuantity % 3)+3)%3)+1);
    color = ((((cardColor % 3)+3)%3)+1);
    shading = ((((cardShading % 3)+3)%3)+1);
    shape = ((((cardShape % 3)+3)%3)+1);
  }

  public int getQuantity(){
    return quantity;
  }
  
  public int getColor(){
    return color;
  }
  
  public int getShading(){
    return shading;
  }
   
  public int getShape(){
    return shape;
  }
  
  public boolean isSet(Card cardB, Card cardC){
    return 
     (((quantity + cardB.getQuantity() + cardC.getQuantity()) % 3) == 0) &&
    
     (((color + cardB.getColor() + cardC.getColor()) % 3) == 0) &&

     (((shading + cardB.getShading() + cardC.getShading()) % 3) == 0) &&
  
     (((shape + cardB.getShape() + cardC.getShape()) % 3) == 0);
  }
      
  public String toString(){
    String[] Scolor = new String[3];
      Scolor[0] = "R";
      Scolor[1] = "G";
      Scolor[2] = "P";
      
    String[] Sshading = new String[3];
      Sshading[0] = "O";
      Sshading[1] = "T";
      Sshading[2] = "S";
    
    String[] Sshape = new String[3];
      Sshape[0] = "O";
      Sshape[1] = "D";
      Sshape[2] = "S";
    
    return quantity + Scolor[color-1] + Sshading[shading-1] + Sshape[shape-1]; 
  }
  
  public boolean equals(Object obj){
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
 } 
// d