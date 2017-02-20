import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/*Mepaiyeda, Deborah
 * 500713214
 * This class creates an edge, a subclass of GraphElement. 
 */
	public class Edge extends GraphElement
	{
		 //instance variables
		 private double x2;
		 private double y2;
		 private Line2D.Double line;
	
		
		 //Edge constructor
		 //@param x x-coordinate of the mouse point
		 //@param y y-coordinate of the mouse point
		 public Edge(double x, double y)
		 {
			 //the super constructor
			 super(x,y);
			 x2 = x;
			 y2 = y;
		 }
		 
		 //Override
		 //@param x x-coordinate of the mouse point
		 //@param y y-coordinate of the mouse point
		 //@return whether or not the mouse point is contained inside of or close to the graph element
		 public boolean isClicked (double x, double y)
		 {
			 //if the point segment distance is less than 20
		     if (line.ptSegDist(x,y) < 20)
		     {
		         return true;
		     }
		     	return false;
		 }
		 
		 //Override
		 //@param g2 2D graph variable
		 //draws the edge graph element
		 public void draw (Graphics2D g2)
		 {
			 line = new Line2D.Double (getXPos(),getYPos(),x2,y2);
			 g2.setColor(color);
			 g2.draw(line);
		 }
		 
		 //Override
		 //@param xLoc the x location to move to
		 //@param yLoc the y location to move to
		 //moves the line from its initial x,y point to the second x,y point
		 public void moveTo (double xLoc, double yLoc)
		 {
			 x2 = xLoc;
			 y2 = yLoc;
		  
		 }
		 //Override
		 //@return returns whether a label applies to the Edge graph element
		 public boolean applyLabel()
		 {
		  return false;
		 }
	}
		

