public class Card {

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
    String [] Colour = {"R","G","P"};
    String [] Filling = {"O","T","S"};
    String [] Form = {"O","D","S"};
    
    // Figured out a way to do it with Arrays!
    // I still want to meet on Thursday though!
    return quantity + Colour[color-1] + Filling[shading-1] + Form[shape-1];
  }

  public boolean equals(Object obj){

    Card that = (Card)obj;
      
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }

 } 
