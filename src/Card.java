public class Card {
  // Create the rest of this class yourself
  
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int cardQuantity, int cardColor, int cardShading, int cardShape)
  {
    quantity = cardQuantity;
    color = cardColor;
    shading = cardShading;
    shape = cardShape;
  }
  
  public int getQuantity()
  {
    return quantity;
  }
  
  public int getColor()
  {
    return color;
  }
  
  public int getShading()
  {
    return shading;
  }
  
  public int getShape()
  {
    return shape;
  }
  
  
  
  public boolean equals(Object obj) 
  {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
