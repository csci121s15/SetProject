public class Card {
  private int Q;
  private int C;
  private int S;
  private int Sh;
  private String str;
  
  public Card(int Quantity, int Color, int Shading, int Shape) {
    Q = Fixer(Quantity);
    C = Fixer(Color);
    S = Fixer(Shading);
    Sh = Fixer(Shape);
  } 
  
    private int Fixer(int value) {
      if (value < 1 || value > 3) {
        return ((((value % 3) + 3) % 3) + 1);
      }
      else {
        return value;
      }
    }
  
  
  public int getQuantity() { 
    return Q;
  }
  
  public int getColor() {
    return C;
  }
  
  public int getShading() {
    return S;
  }
  
  public int getShape() {
    return Sh;
  }
  
  public boolean isSet(Card card2, Card card3) {
    int Qsum;
    int Csum;
    int Ssum;
    int Shsum;
    
    Qsum = Q + card2.getQuantity() + card3.getQuantity();
    if ((Qsum % 3) == 0) {
      return true;
    }
    
    Csum = C + card2.getColor() + card3.getColor();
    if ((Csum % 3) == 0) {
      return true;
    }
    
    Ssum = S + card2.getShading() + card3.getShading();
    if ((Ssum % 3) == 0) {
      return true;
    }
    
    Shsum = Sh + card2.getShape() + card3.getShape();
    if ((Shsum % 3) == 0) {
      return true;
    }
    
    else {
      return false;
    }
    
    
   
  }
  
  public String toString() {
    String str = "";
    
    if (Q == 1) {
      str += 1;
    }
    else if (Q == 2) {
      str += 2;
    }
    else if (Q == 3) {
      str += 3;
    }
    
    if (C == 1) {
      str += 'R';
    }
    else if (C == 2) {
      str += 'G';
    }
    else if (C == 3) {
      str += 'P';
    }
    
    if (S == 1) {
      str += 'O';
    }
    else if (S == 2) {
      str +='T';
    }
    else if (S == 3) {
      str += 'S';
    }
    
    if (Sh == 1) {
      str += 'O'; 
    }
    else if (Sh == 2) {
      str += 'D';
    }
    else if (Sh == 3) {
      str += 'S';
    }
    
    return str;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return Q == that.getQuantity() &&
      C == that.getColor() &&
      S == that.getShading() &&
      Sh == that.getShape();
  }
}
 