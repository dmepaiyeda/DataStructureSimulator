import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Color;
import javax.swing.SwingUtilities;

//Mepaiyeda, Deborah
//500713214
	public class GraphComponent extends JComponent
		{
		    //array list shapes to hold the shapes for the graph element
		    private ArrayList <GraphElement> shapes  = new ArrayList <GraphElement>();
		    //instance variables
		    private double x,y;
		    Point2D.Double p1;
		    Point2D.Double p2;
		    String labelname = " ";
		    
		   //flags that occur when a graph element button is clicked
		    private boolean recFlag = false;
		    private boolean ellipseFlag = false;
		    private boolean edgeFlag = false;
		    private int selection ; //variable for whether the graph element was selected or not
		    private GraphElement shapesCreated;
		    
		    /*
		     * @param click if the graph element button is clicked
		     * if the graph element button is clicked the flag for that element will be set to click
		     * 
		     */
		    public void rectisClicked (boolean click)
		    {
		        recFlag = click;
		    }
		    
		    public void ellipseisClicked (boolean click)
		    {
		        ellipseFlag = click;
		    }
		    
		    public void edgeisClicked (boolean click)
		    {
		        edgeFlag = click;
		    }
		    /*
		     * if the label button is clicked, the user has selected the shape
		     * a label is then set for that shape
		     */
		    public void labelisClicked ()
		    {
		       if (selection == 1)
		       {
		           shapesCreated.setLabel(labelname);
		           repaint();
		       }
		    }
		    /*
		     * @param name name for the label
		     */
		    public void label (String name)
		    {
		        labelname = name;
		    }
		    
		    //GraphComponent constructor
		    public GraphComponent ()
		    {
		    	//listens for mouse movements
		        class MotionListener implements MouseMotionListener
		        {
		          public void mouseMoved (MouseEvent e)    {}
		       
		          public void mouseDragged(MouseEvent e)
		          {
		        	  /*if there is a graph element, the graph element was clicked and selected, 
		        	   * move the element to the x,y coordinate and repaint (refresh) it
		        	   */
		        	  
		        	  if (shapesCreated != null && selection == 1 || edgeFlag == true)
		        	  {
		        		  shapesCreated.moveTo(e.getX(),e.getY());
		        		  repaint();
		        	  }
	
		         }
		      }
		        //listens for mouse actions
		        class MyListener implements MouseListener
		        {
		            public void mousePressed (MouseEvent event)
		            {
		            	//get the x and y positions of the mouse
		                x = event.getX();
		                y = event.getY();
		                
		                /*
		                 * if the button for whichever graph element is clicked, create that 
		                 * graph element and add it to the array list
		                 * For example, it it is the the rectangle button is clicked, the recFlag will come 
		                 * up and a new rectangle will be added to the array list
		                 */
		                if (recFlag)
		                {
		                    shapesCreated = new RectangleNode (x,y);
		                    shapes.add(shapesCreated);
		                    repaint();
		                    
		                }
		                else if (ellipseFlag)
		                {
		                    shapesCreated = new EllipseNode (x,y);
		                    shapes.add(shapesCreated);
		                    repaint();
		                    
		                }
		                else if (edgeFlag)
		                {
		                    
		                    shapesCreated = new Edge (x,y);
		                    shapes.add(shapesCreated);
		                    repaint();
		                    
		                }
		                /*
		                 * otherwise, loop through the array 
		                 * if that graph element is clicked, set the color to red
		                 * else if it is not clicked, set the color back to its default (black)
		                 */
		                else 
		                {
		                    for (int i = 0; i <shapes.size();i++)
		                    {
		                        if (shapes.get(i).isClicked(x, y))
		                        {
		                            selection = 1;
		                            shapesCreated = shapes.get(i);
		                            shapesCreated.setColor(Color.RED);
		                            break;
		                        }
		                        else
		                        {
		                            selection = -1;
		                            shapes.get(i).setColor(Color.BLACK);
		                        }
		                    }
		                }
		                //if the mouse is right clicked and selected, remove the graph element from the array
		                if (SwingUtilities.isRightMouseButton(event))
		                {
		                    if (selection ==1)
		                    {
		                        shapes.remove(shapesCreated);
		                        repaint();
		                    }
		                    
		                }
		                //refresh
		                repaint();
		            }
		            /*
		             * if the mouse is released, the clicking is false 
		             * the flags are initialized back to false
		             */
		            public void mouseReleased(MouseEvent event)
		            {
		                recFlag=false;
		                edgeFlag=false;
		                ellipseFlag=false;
		            }
		            public void mouseClicked(MouseEvent event){}
		            public void mouseEntered(MouseEvent event){}
		            public void mouseExited(MouseEvent event){}
		            
		        }
		        
		        //the creation of my listeners
		        MouseListener myListener = new MyListener();
		        addMouseListener(myListener);
		        MouseMotionListener motionListener = new MotionListener();
		        addMouseMotionListener (motionListener);
		    }

		    //draws graph elements in the array list
		    public void paintComponent(Graphics g)
		    {
		        Graphics2D g2 = (Graphics2D) g;
		        for (int a = 0; a < shapes.size();a++)
		        {
		            shapes.get(a).draw(g2);
		        }
		    }
		}
		
	



