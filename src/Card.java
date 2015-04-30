public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape; 
  private int value;
  
  private String quantString;
  private String colorString;
  private String shadingString;
  private String shapeString;
  
  public Card(int theQuantity, int theColor, int theShading, int theShape) {
    if (theQuantity < 1 || theQuantity > 3) {
      quantity = (((theQuantity % 3) + 3) % 3) + 1;
    }
    else {
      quantity = theQuantity;
    }
    
    if (theColor < 1 || theColor > 3) {
      color = (((theColor % 3) + 3) % 3) + 1; 
    }
    else {
      color = theColor;
    }
    
    if (theShading < 1 || theShading > 3) {
      shading = (((theShading % 3) + 3) % 3) + 1;
    }
    else {
      shading = theShading;
    }
    
    if (theShape < 1 || theShape > 3) {
      shape = (((theShape % 3) + 3) % 3) + 1;
    }
    else {
      shape = theShape;
    }
      
   
    
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
    String string = "";
    String quantString = "";
    String colorString = "";
    String shadingString = "";
    String shapeString = "";
    
    if (quantity == 1)
      quantString = "1";
    if (quantity == 2)
      quantString = "2";
    if (quantity == 3)
      quantString = "3";
    
    
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
    
    return string = quantString + colorString + shadingString + shapeString;
   
  }


  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
