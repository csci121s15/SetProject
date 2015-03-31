public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int q, int c, int shd, int shp) {
    quantity = q;
    color = c;
    shading = shd;
    shape = shp;
    
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
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
    return false;
  }
  
  public String toString() {
    return "";
  }
  
}
