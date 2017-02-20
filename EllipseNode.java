import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
//Mepaiyeda, Deborah
//500713214
	public class EllipseNode extends GraphElement
	{
	    //instance variables
	    private double width = 100;
	    private double height = 80;
	    private Ellipse2D.Double oval;
	     
	    /*EllipseNode constructor 
	     @param x x-coordinate of the mouse point
	    @param y y-coordinate of the mouse point */
	    public EllipseNode (double x, double y)
		    {
	    		//the super constructor
		        super (x,y);
		        label = " ";
		    }
		    
	    /*override
	     *  @param x x-coordinate of the mouse point
	         @param y y-coordinate of the mouse point 
	     *@return true or false depending on whether the x,y position is 
	     *inside or close to the shape or not 
	     */
		    public boolean isClicked (double x, double y)
		    {
		        return oval.contains (x,y);
		        
		    }
		    /*override
		     *@param g2 2D graph variable
		     * draws the ellipse graph element
		     */
		    public void draw (Graphics2D g2)
		    {
		        oval = new Ellipse2D.Double ((int)this.getXPos(),(int)this.getYPos(), width, height);
		        g2.setColor(color);
		        g2.drawString(label,(int)getXPos()+ 30,(int)getYPos()+45);
		        g2.draw(oval);
		    }
		    
		    /*
		     * @return returns whether the label applies to the ellipse graph element
		     */
		    public boolean applyLabel()
		    {
		        return true;
		    }

	}
