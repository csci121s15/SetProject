public class Card {
  public int quantity;
  public int color;
  public int shading;
  public int shape;
  
  public Card (int cardQuantity, int cardColor, int cardShading, int cardShape){
    quantity = ((((cardQuantity % 3)+3)%3)+1);
    color = ((((cardColor % 3)+3)%3)+1);
    shading = ((((cardShading % 3)+3)%3)+1);
    shape = ((((cardShape % 3)+3)%3)+1);
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
  
  public boolean isSet (Card cardA, Card cardB) {
    if ((((quantity + cardA.getQuantity() + cardA.getQuantity())%3)==0) && 
        (((color + cardA.getColor() + cardA.getColor())%3)==0) && 
        (((shading + cardA.getShading() + cardA.getShading())%3)==0) && 
        (((shape + cardA.getShape() + cardA.getShape())%3)==0))
      return true;
  else 
    return false;
  }
  
  public String toString() {
    String str = "";
    String col = "";
    String shade = "";
    String sha = "";
    
    if (color == 1)
      col = "R";
    else if (color == 2)
      col = "G";
    else 
      col = "P";
    
    if (shading == 1)
      shade = "O";
    else if (color == 2)
      shade = "T";
    else 
      shade = "S";
    
    if (shape == 1)
      sha = "O";
    else if (color == 2)
      sha = "D";
    else 
      sha = "S";
    
    return str = quantity + col + shade + sha;
  
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
