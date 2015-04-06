public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int a, int b, int c, int d) {
    quantity = fixValue(a);
    color = fixValue(b);
    shading = fixValue(c);
    shape = fixValue(d);
  }
  
  // fixes values outside the range
  // by Professor Sommers
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

  
  public boolean isSet(Card card2, Card card3) {
    return (quantity + card2.getQuantity() + card3.getQuantity()) % 3 == 0 && 
      (color + card2.getColor() + card3.getColor()) % 3 == 0 && 
      (shading + card2.getShading() + card3.getShading()) % 3 == 0 && 
      (shape + card2.getShape() + card3.getShape()) % 3 == 0;
  
  }
  
  public String toString() {
    String[][] array = {{"R", "G", "P"}, {"O", "T", "S"}, {"O", "D", "S"}};
    
    return quantity + array[0][color - 1] + array[1][shading - 1] + array[2][shape - 1];
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
