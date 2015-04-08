public class Card {
  private int quantity;
  private int color;
  private int shade;
  private int shape;
 
  
  public Card(int number, int colorObject, int shadetype, int shapeKind ){
    quantity = changeValue(number);
    color = changeValue(colorObject);
    shade = changeValue(shadetype);
    shape = changeValue(shapeKind);
  }
  
  private int changeValue( int changeinValue) {
      if (changeinValue < 1 || changeinValue > 3)
        return (((changeinValue % 3) + 3) % 3) + 1;
      else 
        return changeinValue;
  }
    
    
  public int getQuantity(){
   
    return quantity;
   }
   
  public int getColor(){
   
     return color;
   }
   
  public int getShade(){
   
     return shade;
   }
   
  public int getShape(){
   
     return shape;
   }

  public boolean isSet (Card cardM,Card cardMM){
     if (((((color + cardM.getColor() + cardMM.getColor()) % 3) == 0)) &&
     (((quantity + cardM.getQuantity() + cardMM.getQuantity()) % 3) == 0) &&
     (((shade + cardM.getShade() + cardMM.getShade()) % 3) == 0) &&
     (((shape + cardM.getShape() + cardMM.getShape()) % 3) == 0))
     {
      return true;
     }
     else {
       return false;
     }
  }
public String toString() {
    String str = "";
    str += quantity;
    if(color == 1) {
      str += "R";
    }
    if(color == 2) {
      str += "G";
    }
    if(color == 3) {
      str += "P";
    }
    if(shade == 1) {
      str += "O";
    }
    if(shade == 2) {
      str += "T";
    }
    if(shade == 3) {
      str += "S";
    }
    if(shape == 1) {
      str += "O";
    }
    if(shape == 2) {
      str += "D";
    }
    if(shape == 3) {
      str += "S";
    }
    return str;
  }
 
private int fixValue(int valueToFix) {
   if (valueToFix < 1 || valueToFix > 3)
      return (((valueToFix % 3) + 3) % 3) + 1;
    else
      return valueToFix;
 }
}




       

    

   
  
