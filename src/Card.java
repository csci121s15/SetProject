public class Card{
  
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  private String quan;
  private String col;
  private String shad;
  private String shap;
  
  public Card(int cardQuantity, int cardColor, int cardShading, int cardShape) {
    if (cardQuantity < 1 || cardQuantity > 3) {
      quantity = (((cardQuantity % 3) + 3) % 3) + 1;
    }
    else {
      quantity = cardQuantity;
    }
    if (cardColor < 1 || cardColor > 3) {
      color = (((cardColor % 3) + 3) % 3) + 1;
    }
    else {
      color = cardColor;
    }
    if (cardShading < 1 || cardShading > 3) {
      shading = (((cardShading % 3) + 3) % 3)  + 1;
    }
    else {
      shading = cardShading;
    }
    if (cardShape < 1 || cardShape > 3) {
      shape = (((cardShape % 3) + 3) % 3)  + 1;
    }
    else {
      shape = cardShape;
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
  
  public boolean isSet(Card two, Card three) {
    
    int totalQuantity = getQuantity() + two.getQuantity() + three.getQuantity();
    int totalColor = getColor() + two.getColor() + three.getColor();
    int totalShading = getShading() + two.getShading() + three.getShading();
    int totalShape = getShape() + two.getShape() + three.getShape();
    
    if (totalQuantity % 3 == 0 && totalColor % 3 == 0 && totalShading % 3 == 0 && totalShape % 3 == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public String toString() {
    
    if (quantity == 1) {
      quan = ("1");
    }
    else if (quantity == 2) {
      quan = ("2");
    }
    else {// (quantity == 3) {
      quan = ("3");
    }
    if (color == 1) {
      col = ("R"); //red
    }
    else if (color == 2) {
      col = ("G"); //green
    }
    else{ //(color == 3) {
      col = ("P"); //purple
    }
     if (shading == 1) {
      shad = ("O"); //empty
    }
    else if (shading == 2) {
      shad = ("T"); //striped/shaded
    }
    else{// (shading == 3) {
      shad = ("S"); //solid/filled
    }
    if (shape == 1) {
      shap = ("O"); //oval
    }
    else if (shape == 2) {
      shap = ("D"); //diamond
    }
    else{// (shading == 3) {
      shap = ("S"); //squiggle
    }
    String sequence = quan + col + shad + shap;
    return sequence;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
  
}
