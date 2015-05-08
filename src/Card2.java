public class Card
{
  public int quantity = 0;
  public int color = 0;
  public int shading = 0;
  public int shape = 0;
  
  public Card(int quan, int col, int shade, int shap)
  {
    if(quan < 1 || quan > 3)
    {
      if(quan <0)
        quantity = (((quan%3) +3) %3)+1;
      else
        quantity = (quan % 3)+1;
    }
    else
      quantity = quan;
    
    if(col < 1 || col > 3)
    {
      if(col <0)
        color = (((col % 3) + 3) % 3)+1;
      else
        color = (col % 3)+1;
    }
    else
      color = col;
    
    if(shade < 1 || shade > 3)
    {
      if(shade <0)
        shading = (((shade % 3) + 3) % 3)+1;
      else
        shading = (shade % 3)+1;
    }
    else
      shading = shade;
    
    if(shap < 1 || shap > 3)
    {
      if(shap <0)
        shape = (((shap % 3) + 3) % 3)+1;
      else
        shape = (shap % 3)+1;
    }
    else
      shape = shap;
  }
  public int getQuantity()
  {
    return quantity;
  }
  public int getColor()
  {
    return color;
  }
  public int getShading()
  {
    return shading;
  }
  public int getShape()
  {
    return shape;
  }
  public boolean equals(Object obj)
  {
    Card that = (Card)obj;
    
    return (quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape() );
  }
  public boolean isSet(Card card2, Card card3)
  {
    boolean quanCheck = false;
    boolean colCheck = false;
    boolean shadeCheck = false;
    boolean shapeCheck = false;
    
    if(((quantity + card2.getQuantity() + card3.getQuantity() )%3) == 0)
      quanCheck = true;
    if(((color + card2.getColor() + card3.getColor() )%3) == 0)
      colCheck = true;
    if(((shading + card2.getShading() + card3.getShading() )%3) == 0)
      shadeCheck = true;
    if(((shape + card2.getShape() + card3.getShape() )%3) == 0)
      shapeCheck = true;
    
    return (quanCheck == true && colCheck == true && shadeCheck == true && shapeCheck == true);
  }
  
  public String toString()
  {
    //Quantity
    String info = "" + quantity;
    
    //Color
    if(color == 1)
      info += "R";
    else if(color == 2)
      info += "G";
    else if(color == 3)
      info += "P";
    
    //Shading
    if(shading == 1)
      info += "O";
    else if(shading == 2)
      info += "T";
    else if(shading == 3)
      info += "S";
    
    //Shape
    if(shape == 1)
      info += "O";
    else if(shape == 2)
      info += "D";
    else if(shape == 3)
      info += "S";
    
    return info;
  }
}
