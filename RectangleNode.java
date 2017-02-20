import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
//Mepaiyeda, Deborah
//500713214
public class RectangleNode extends GraphElement{
    
	//constants
    private final int width = 100;
    private final int  height = 100;
    //instance variable
    private Rectangle2D.Double box;
    
    /*
     * RectangleNode constructor
     * @param x x-coordinate of the mouse point
     * @param y y-coordinate of the mouse point
     */
    public RectangleNode(double x, double y)
    {
    	//the super constructor
        super (x,y);
    }
    /*override
     *  @param x x-coordinate of the mouse point
	    @param y y-coordinate of the mouse point 
     * @return true or false depending on whether the x,y position is inside or 
     * close to the shape or not
     */
    public boolean isClicked(double x, double y)
    {
        return box.contains(x,y);
    }
    
    /*override
     *@param g2 2D graph variable
     * draws the rectangle graph element
     */
    public void draw (Graphics2D g2)
    {
        box = new Rectangle2D.Double ((int)this.getXPos(),(int)this.getYPos(), width, height);
        g2.setColor(color);
        g2.drawString(label,(int)getXPos()+ 30,(int)getYPos()+45);
        g2.draw(box);
    }
    
    /*
     * @return returns whether the label applies to the rectangle graph element
     */
    public boolean applyLabel()
    {
        
        return true;
        
    }
    
}
