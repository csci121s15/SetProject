import junit.framework.TestCase;

public class CardTest extends TestCase
{
  Card a = new Card(1,1,1,1);
  Card b = new Card(2,2,3,3);
  Card c = new Card(1,2,3,1);
  Card d = new Card(-4,-5,6,7);
  
  public void testGetQuantity()
  {
    assertEquals(1,a.getQuantity());
    assertEquals(2,b.getQuantity());
    assertEquals(1,c.getQuantity());
    assertEquals(3,d.getQuantity());
  }
  public void testGetColor()
  {
    assertEquals(1,a.getColor());
    assertEquals(2,b.getColor());
    assertEquals(2,c.getColor());
    assertEquals(2,d.getColor());
  }
  public void testGetShading()
  {
    assertEquals(1,a.getShading());
    assertEquals(3,b.getShading());
    assertEquals(3,c.getShading());
    assertEquals(1,d.getShading());
  }
  public void testGetShape()
  {
    assertEquals(1,a.getShape());
    assertEquals(3,b.getShape());
    assertEquals(1,c.getShape());
    assertEquals(2,d.getShape());
  }
  public void testEquals()
  {
    a = b;
    assertEquals(true,a.equals(b));
    assertEquals(false,c.equals(d));
  }
  public void testIsString()
  {
    a = new Card(1,1,1,1);
    b = new Card(2,2,2,2);
    c = new Card(3,3,3,3);

    assertEquals("1ROO",a.toString());
    assertEquals("2GTD",b.toString());
    assertEquals("3PSS",c.toString());
  }
  public void testIsSet()
  {
    a = new Card(1,1,1,1);
    b = new Card(2,2,2,2);
    c = new Card(3,3,3,3);
    d = new Card(1,2,3,1);
    
    assertEquals(true,a.isSet(b,c));
    assertEquals(false,a.isSet(c,d));
  }
}
