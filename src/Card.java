public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int theQuantity, int theColor, int theShading, int theShape){
    quantity = formatValue(theQuantity);
    color = formatValue(theColor);
    shading = formatValue(theShading);
    shape = formatValue(theShape);
  }
  
  private int formatValue(int val){
    if(val < 4 && val > 0){
      return val;
    } else if (val >= 0){ 
      return val % 3 + 1;  
    } else {
      return (((val % 3) + 3) % 3) + 1;
    } 
    
  }
  public int getQuantity(){
    return quantity;
  }
  
  public int getColor(){
    return color;
  } 
  
  public int getShading(){ 
    return shading;
  } 
  
  public int getShape(){ 
    return shape;
  }
  
  public boolean isSet(Card second, Card third){
   boolean qtyIsRight = isRightForSet(quantity, second.getQuantity(), third.getQuantity());
   boolean colorIsRight = isRightForSet(color, second.getColor(), third.getColor());
   boolean shadingIsRight = isRightForSet(shading, second.getShading(), third.getShading());
   boolean shapeIsRight = isRightForSet(shape, second.getShape(), third.getShape());
   
   if(qtyIsRight && colorIsRight && shadingIsRight && shapeIsRight){
     return true;
   } else {
     return false;
   }
    
  }
  public boolean isRightForSet(int val1, int val2, int val3){ 
    if((val1 + val2 + val3) % 3 == 0){
      return true;
    } else {
      return false;
    }
  }
  
  public String toString(){
    String str = "";
    if(quantity == 1){
      str += "1";
    } else if(quantity == 2){
      str += "2";
    } else if(quantity == 3){
      str += "3";
    } 
    
  
    if(color == 1){
      str += "R";
    } else if(color == 2){
      str += "G";
    } else if(color == 3){
      str += "P";
    }     
   
    if(shading == 1){
      str += "O";
    } else if(shading == 2){
      str += "T";
    } else if(shading == 3){
      str += "S";
    }
    
    if(shape == 1){
      str += "O";
    } else if (shape == 2){
      str += "D";
    } else if (shape == 3){
      str += "S";
    }  
    return str;
 }
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
  
  
}

