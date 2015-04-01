import java.util.ArrayList;

public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int q, int c, int shd, int shp) {
    if (q < 1 || q > 3) {
    quantity = (((q % 3) + 3) % 3) + 1;
    }
    else {
      quantity = q;
    }
    if (c < 1 || c > 3) {
    color = (((c % 3) + 3) % 3) + 1;
    }
    else {
      color = c;
    }
    if (shd < 1 || shd > 3) {
    shading = (((shd % 3) + 3) % 3) + 1;
    }
    else {
      shading = shd;
    }
    if (shp < 1 || shp > 3) {
    shape = (((shp % 3) + 3) % 3) + 1;
    }
    else {
      shape = shp;
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
  
  public boolean isSet(Card c1, Card c2) {
    int sum = quantity + color + shading + shape;
    int card1 = c1.getQuantity() + c1.getColor() + c1.getShading() + c1.getShape();
    int card2 = c2.getQuantity() + c2.getColor() + c2.getShading() + c2.getShape();
    if ((card1 + card2 + sum) % 3 == 0) {
      return true;
    }
    else {
    return false;
    }
  }
  
  public String toString() {
    String string = "";
    ArrayList<String> quant = new ArrayList<String>();
    quant.add("");
    quant.add("1");
    quant.add("2");
    quant.add("3");
    
    ArrayList<String> col = new ArrayList<String>();
    col.add("");
    col.add("R");
    col.add("G");
    col.add("P");
    
    ArrayList<String> shad = new ArrayList<String>();
    shad.add("");
    shad.add("O");
    shad.add("T");
    shad.add("S");
    
    ArrayList<String> shap = new ArrayList<String>();
    shap.add("");
    shap.add("O");
    shap.add("D");
    shap.add("S");
    
    string += quant.get(getQuantity());
    string += col.get(getColor());
    string += shad.get(getShading());
    string += shap.get(getShape());
     
    return string;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
