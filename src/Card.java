public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  // Create the rest of this class yourself
  
  public Card (int isQuant, int isCol, int isShad, int isShap) {
    quantity = ((((isQuant % 3) + 3) % 3));
    color = ((((isCol % 3) + 3) % 3));
    shading = ((((isShad % 3) + 3) % 3));
    shape = ((((isShap % 3) + 3) % 3));
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
  
  public boolean isSet(Card cardX, Card cardY) {
    if ((((quantity + cardX.getQuantity() + cardY.getQuantity()) % 3) == 0) &&
      (((color + cardX.getColor() + cardY.getColor()) % 3) == 0) &&
      (((shading + cardX.getShading() + cardY.getShading()) % 3) == 0) &&
        (((shape + cardX.getShape() + cardY.getShape()) % 3) == 0)) {
      return true;
    }
    else {
      return false;
    }

    
  }
  
  public String toString() {
    String str = "";
    str += quantity;
    if (color == 0) {
      str += "R";
    }
    
    if (color == 1) {
      str += "G";
    }
    
    if (color == 2) {
      str += "P";
    }
    
    if (shading == 0) {
      str += "O";
    }
    
    if (shading == 1) {
      str += "T";
    }
    
    if (shading == 2) {
      str += "S";
    }
    
    if (shape == 0) {
      str += "O";
    }
    
    if (shape == 1) {
      str += "D";
    }
    
    if (shape == 2) {
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
