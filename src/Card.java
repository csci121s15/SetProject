public class Card {

  private int quantity;
  private int color;
  private int shading;
  private int shape; 

  public Card(int Quantity, int Color, int Shading, int Shape){

    quantity = ((((Quantity % 3)+3)%3)+1);
    color = ((((Color % 3)+3)%3)+1);
    shading = ((((Shading % 3)+3)%3)+1);
    shape = ((((Shape % 3)+3)%3)+1);
  }

  public int getQuantity() {

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

  public boolean isSet(Card A, Card B) {

    return 

     (((quantity + A.getQuantity() + B.getQuantity()) % 3) == 0) &&
     (((color + A.getColor() + B.getColor()) % 3) == 0) &&
     (((shading + A.getShading() + B.getShading()) % 3) == 0) &&
     (((shape + A.getShape() + B.getShape()) % 3) == 0);
  }
 
  public String toString() {
    String str = "";
    str += quantity;
    if(color == 1) {
      str += "R";
    }
    if(color == 2) {
      str += "G";
    }
    if(color == 3) {
      str += "P";
    }
    if(shading == 1) {
      str += "O";
    }
    if(shading == 2) {
      str += "T";
    }
    if(shading == 3) {
      str += "S";
    }
    if(shape == 1) {
      str += "O";
    }
    if(shape == 2) {
      str += "D";
    }
    if(shape == 3) {
      str += "S";
    }
    return str;
  }

  public boolean equals(Object obj){

    Card that = (Card)obj;
      
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }

 } 
