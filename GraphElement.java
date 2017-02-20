import java.awt.Color;
import java.awt.Graphics2D;
//Mepaiyeda, Deborah
//500713214
// General element of a graph (nodes and edges)

abstract public class GraphElement
{
  private double xPos;
  private double yPos;
  protected String label;
  protected Color color;
  boolean selected;
     
  //constructor of the superclass Graph Element
  public GraphElement()
  {
     xPos = 0;
     yPos = 0;
     label = "";
     color = Color.BLACK;
  }
    //second constructor
  public GraphElement(double x, double y)
  {
     xPos = x;
     yPos = y;
     label = "";
     color = Color.BLACK;
  }
    //gets the x position of the mouse
  public final double getXPos()
  {
     return xPos;
  }
    //gets the y position of the mouse
  public final double getYPos()
  {
     return yPos;
  }
  // sets the color for the selection of the graph element
  public void setColor(Color color)
  {
   this.color = color;
  }
// for moving a graph element from one location to another
  public void moveTo (double xLoc, double yLoc)
  {
     xPos = xLoc;
     yPos = yLoc;
  }
    
  //returns a string representation
  public String toString()
  {
     String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n";
     return str;
  }
    //methods to implement and override in the subclasses
  abstract void  draw(Graphics2D g2);
  abstract boolean isClicked(double x, double y);
  abstract boolean applyLabel();
  
  //gets the label
     public String getLabel()
     {
       return label;
     }
    //sets the label
     public void setLabel(String label)
     {
       this.label = label;
     }
     
     
}
