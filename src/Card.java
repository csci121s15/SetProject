public class Card {
  
    private int quantity; 
    private int color; 
    private int shading; 
    private int shape;
    private String zing = "";
    
    public Card( int Quantity, int Color, int Shading, int Shape) {
      quantity = repairValue(Quantity);
      color = repairValue(Color); 
      shading = repairValue(Shading); 
      shape = repairValue(Shape); 
    }
    private int repairValue( int valueToRepair) {
      if (valueToRepair < 1 || valueToRepair > 3)
        return (((valueToRepair % 3) + 3) % 3) + 1;
      else 
        return valueToRepair;
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
    public int getShape () {
      return shape;
    }
    public boolean isSet( Card card2, Card card3) {
    if(((quantity + card2.getQuantity() + card3.getQuantity()) % 3 == 0) &&
      ((color + card2.getColor() + card3.getColor()) % 3 == 0) && 
      ((shading + card2.getShading() + card3.getShading()) % 3 == 0) && 
      (( shape + card2.getShape() + card3.getShape()) % 3 == 0))
    {
      return true;
    }
    
    else
    {
      return false;
    }
    }
    public String toString() { 
      
    if (quantity == 1) {
      zing += 1; 
    }
    else if (quantity == 2) {
      zing += 2;
    }
    else if (quantity == 3) {
      zing += 3;
    }
    if (color == 1) {
      zing += "R";
    }
    else if (color == 2) {
      zing += "G";
    }
    else if (color == 3) {
      zing += "P";
    }
    if (shading == 1) {
      zing += "O";
    }
    else if (shading == 2) {
      zing += "T";
    }
    else if (shading == 3) {
      zing += "S";
    }
    if (shape == 1) {
      zing += "O";
    }
    else if (shape == 2) { 
      zing += "D";
    }
    else if (shape == 3) {
      zing += "S";
    }
    return zing;
    }
    public boolean equals(Object obj) {
      Card that = (Card)obj; 
      return quantity == that.getQuantity() &&
        color == that.getColor() &&
        shading == that.getShading() &&
        shape == that.getShape();
    }
}
   
    
    