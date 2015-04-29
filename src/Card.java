public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  // Create the rest of this class yourself
  
  public Card (int isQuant, int isCol, int isShad, int isShap) {
    quantity = fixValue(isQuant);
    color = fixValue(isCol);
    shading = fixValue(isShad);
    shape = fixValue(isShap);
    
  }
  
  private int fixValue(int valueToFix) {
    if (valueToFix < 1 || valueToFix > 3) 
      return (((valueToFix % 3) + 3) % 3) + 1;
    else
      return valueToFix;
  }
    
  
  public int getQuantity() {
    
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
  
  public boolean isSet(Card c1, Card c2) {
    if ((((quantity + c1.getQuantity() + c2.getQuantity()) % 3) == 0) &&
      (((color + c1.getColor() + c2.getColor()) % 3) == 0) &&
      (((shading + c1.getShading() + c2.getShading()) % 3) == 0) &&
        (((shape + c1.getShape() + c2.getShape()) % 3) == 0)) {
      return true;
    }
    else {
      return false;
    }

    
  }
  
  public String toString() {
    String str = "";
    str += quantity;
    if (color == 1) {
      str += "R";
    }
    
    if (color == 2) {
      str += "G";
    }
    
    if (color == 3) {
      str += "P";
    }
    
    if (shading == 1) {
      str += "O";
    }
    
    if (shading == 2) {
      str += "T";
    }
    
    if (shading == 3) {
      str += "S";
    }
    
    if (shape == 1) {
      str += "O";
    }
    
    if (shape == 2) {
      str += "D";
    }
    
    if (shape == 3) {
      str += "S";
    }
    return str;

  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
