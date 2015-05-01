public class Card {
  
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  
  public Card(int quant, int clr, int shd, int shp) {
    quantity = fixValue(quant);
    color = fixValue(clr);
    shading = fixValue(shd);
    shape = fixValue(shp);
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
  
  public boolean isSet(Card B, Card C) {
    
    if((B.getQuantity() + C.getQuantity() + quantity) % 3 == 0 && 
       (B.getColor() + C.getColor() +color) % 3 == 0 &&
       (B.getShading() + C.getShading() + shading) % 3 == 0 &&
       (B.getShape() + C.getShape() + shape) % 3 == 0) {
      
      return true;
    }
    
    else {
      
      return false;
    }
    
  }
  
  //Tried to do my own toString method but I couldn't figure it out. 
  //So I did this code even though it's longer than I wanted it too.
  
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
  //From class. Thanks to me!
  private int fixValue(int valueToFix) {
    
    if(valueToFix < 1 || valueToFix > 3) {
      
      return(((valueToFix % 3) + 3) % 3) + 1;
    }
    
    else {
      
      return valueToFix;
    }
  }
  
  public boolean equals(Object obj) {
    
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}