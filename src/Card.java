public class Card {
  public int quantity;
  public int color;
  public int shading;
  public int shape;

  public Card (int cardQuantity, int cardColor, int cardShading, int cardShape){
    quantity = formValue(cardQuantity);
    color = formValue(cardColor);;
    shading = formValue(cardShading);;
    shape = formValue(cardShape);;
  }
  
  private int formValue(int val) {
    if (val < 4 && val > 0) {
      return val;
    }
    else if (val >= 0) {
      return val % 3 + 1;
    }
    else {
      return (((val % 3) + 3) % 3) +1;
    }
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
    if ((((quantity + cardA.getQuantity() + cardB.getQuantity())%3)==0) && 
        (((color + cardA.getColor() + cardB.getColor())%3)==0) && 
        (((shading + cardA.getShading() + cardB.getShading())%3)==0) && 
        (((shape + cardA.getShape() + cardB.getShape())%3)==0)) {
      return true;
    }
    else {
    return false;
    }
  }
  
  public boolean isRightForSet(int val1, int val2, int val3) {
    if ((val1 + val2 + val3) % 3 == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public String toString() {
    String str = "";
    String quant = "";
    String col = "";
    String shade = "";
    String sha = "";
    
    if (quantity == 1) {
      str += "1";
    }
    else if (quantity == 2) {
      str += "2";
    }
    else {
      str += "3";
    }
    
    if (color == 1) {
      str += "R";
    }
    else if (color == 2){
      str += "G";
    }
    else {
      str += "P";
    }
    
    if (shading == 1) {
      str += "O";
    }
    else if (shading == 2) {
      str += "T";
    }
    else {
      str += "S";
    }
    
    if (shape == 1) {
      str += "O";
    }
    else if (shape == 2) {
      str += "D";
    }
    else {
      str += "S";
    }
    
    return str = quant+ col + shade + sha;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}

