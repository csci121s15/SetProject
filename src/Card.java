public class Card {
  
  private int[] c = new int[4];
  private int quantity;
  private int color;
  private int shading; 
  private int shape;
  
  public Card(int cardQuan, int cardColor, int cardShading, int cardShape) {
    
    quantity = cardQuan;
    color = cardColor;
    shading = cardShading;
    shape = cardShape;
    
    c[0] = quantity;
    c[1] = color;
    c[2] = shading;
    c[3] = shape;
    
    for (int i = 0; i < 4; i++) {
      if (c[i] >= 1 && c[i] <= 3) {
        c[i] = c[i];
      }
      else {
        if (c[i] < 0) {
          c[i] = (((c[i] % 3) + 3) % 3) + 1;
        }
        else {
          c[i] = c[i] % 3 + 1;
        }
      }
    }
    
    quantity = c[0];
    color = c[1];
    shading = c[2];
    shape = c[3];
  
  }
  public boolean equals(Object obj) {
    
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
  public boolean isSet(Card c2, Card c3) {
    
    int quanSum = quantity + c2.getQuantity() + c3.getQuantity();
    int colorSum = color + c2.getColor() + c3.getColor();
    int shadingSum = shading + c2.getShading() + c3.getShading();
    int shapeSum = shape + c2.getShape() + c3.getShape();
    
    if ((quanSum % 3 == 0) && (colorSum % 3 != 0) && (shadingSum % 3 != 0) && (shapeSum % 3 != 0)) {
      return true;
    }
    else if ((quanSum % 3 != 0) && (colorSum % 3 == 0) && (shadingSum % 3 != 0) && (shapeSum % 3 != 0)) {
      return true;
    }
    else if ((quanSum % 3 != 0) && (colorSum % 3 != 0) && (shadingSum % 3 == 0) && (shapeSum % 3 != 0)) {
      return true;
    }
    else if ((quanSum % 3 != 0) && (colorSum % 3 != 0) && (shadingSum % 3 != 0) && (shapeSum % 3 == 0)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public String toString() {
    String strQuantity = "";
    String strColor = "";
    String strShad = "";
    String strShape = "";
  
    if (quantity == 1) {
      strQuantity += "1";
    }
    else if (quantity == 2) {
      strQuantity += "2";
    }
    else if (quantity == 3) {
      strQuantity += "3";
    }
    if (color == 1) {
      strColor += "R";
    }
    else if (color == 2) {
      strColor += "G";
    }
    else if(color == 3) {
      strColor += "P";
    }
    if (shading == 1) {
      strShad += "O";
    }
    else if (shading == 2) {
      strShad += "T";
    }
    else if (shading == 3) {
      strShad += "S";
    }
    if (shape == 1) {
     strShape += "O";
    }
    else if (shape == 2) {
      strShape += "D";
    }
    else if (shape == 3) {
      strShape += "S";
    }
    return strQuantity + strColor + strShad + strShape;
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
}
