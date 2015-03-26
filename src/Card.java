public class Card {
  // Create the rest of this class yourself
  
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  private char[] letters = new char[] {'R', 'G', 'P', 'O', 'T', 'S', 'O', 'D', 'S'};
  
  public Card(int cardQuantity, int cardColor, int cardShading, int cardShape)
  {
    quantity = (cardQuantity % 3 + 3) % 3;
    if (quantity == 0)
      quantity += 3;
   
    color = (cardColor % 3 + 3) % 3;
    if (color == 0)
      color += 3;
    
    shading = (cardShading % 3 + 3) % 3;
    if (shading == 0)
      shading += 3;
    
    shape = (cardShape % 3 + 3) % 3;
    if (shape == 0)
      shape += 3;
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
  
  public String toString()
  {
   return String.valueOf(quantity) + letters[color - 1] + letters[shading + 2] + letters[shape + 5];
  }
  
  public boolean isSet(Card card2, Card card3)
  {
    return (quantity + card2.getQuantity() + card3.getQuantity()) % 3 == 0 &&
      (color + card2.getColor() + card3.getColor()) % 3 == 0 &&
      (shading + card2.getShading() + card3.getShading()) % 3 == 0 &&
      (shape + card2.getShape() + card3.getShape()) % 3 == 0;
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
