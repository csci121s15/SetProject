public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  Card(int quantity, int color, int shading, int shape) {
    this.quantity = quantity;
    this.color = color;
    this.shading = shading;
    this.shape = shape;
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
  
  public boolean isSet(Card card2, Card card3) {
    boolean set = true;
    int qMod = (quantity + card2.getQuantity() + card3.getQuantity()) % 3;
    int cMod = (color + card2.getColor() + card3.getColor()) % 3;
    int tMod = (shading + card2.getShading() + card3.getShading()) % 3;
    int sMod = (shape + card2.getShape() + card3.getShape()) % 3;
    
    if (qMod+cMod+tMod+sMod != 0)
      return false;
    return set;
  }
  
  public String toString() {
    String string = "";
    String c = "";
    String t = "";
    String s = "";
    
    if (color == 1)
      c = "R";
    else if (color == 2)
      c = "G";
    else
      c = "P";
    
    if (shading == 1)
      t= "O";
    else if (shading == 2)
      t = "T";
    else
      t = "S";
    
    if (shape == 1)
      s = "O";
    else if (shape == 2)
      s = "D";
    else
      s = "S";
    
    return string = quantity + c + t + s;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
