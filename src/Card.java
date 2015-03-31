public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape; 
  private int value;
  
  public Card(int theQuantity, int theColor, int theShading, int theShape) {
    quantity = theQuantity;
    quantity = ((((theQuantity % 3) + 3) % 3));
    
    color = theColor;
    color = ((((theColor % 3) + 3) % 3));
    
    shading = theShading;
    shading = ((((theShading % 3) + 3) % 3));
    
    shape = theShape;
    shape = ((((theShape % 3) + 3) % 3));
    
  }
  //Got the valueToFix from class//
  private int the(int valueToFix) {
    if (valueToFix < 1 || valueToFix > 3)
      return (((valueToFix % 3) + 3) % 3) + 1;
    else
      return valueToFix;
  }
  
  //getValue() goes with valueToFix above//
  public int getValue() {
    return value;
  }
 
  
  
  public int getQuantity()  {
    return quantity;
  }
  
  public int getColor() {
    return color;
  }
  
  public int getShading() {
    return shading;
  }
  
  public int getShape() {
    return shape;
  }
  
  public boolean isSet(Card card1, Card card2) {
    boolean isSet = true;
    return (quantity + card1.getQuantity() + card2.getQuantity()) % 3 == 0 &&
      (color + card1.getColor() + card2.getColor()) % 3 == 0 &&
      (shading + card1.getShading() + card2.getShading()) % 3 == 0 &&
      (shape + card1.getShape() + card2.getShape()) % 3 == 0;
   
    
  }
  
  public String toString() {
    String string = "" + quantity;
    String colorString = "";
    String shadingString = "";
    String shapeString = "";
    
    
    if (color == 1)
      colorString = "R";
    if (color == 2) 
      colorString = "G";
    if (color == 3)
      colorString = "P";
    
    if (shading == 1)
      shadingString = "O";
    if (shading == 2)
      shadingString = "T";
    if (shading == 3)
      shadingString = "S";
    
    if (shape == 1)
      shapeString = "O";
    if (shape == 2) 
      shapeString = "D";
    if (shape == 3)
      shapeString = "S";
    
    return string = quantity + colorString + shadingString + shapeString;
   
  }


  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
