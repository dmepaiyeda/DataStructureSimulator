import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Mepaiyeda, Deborah
500713214
 This program makes a frame and adds a panel to it.
 The panel will show a graph draw and move it around
 under the influence of a mouse
 */
public class GraphViewer 
{
  
    public static void main (String [] args)
    {
        JFrame frame = new JFrame ("Deborah's Graph Drawing Program");
        //constant variables
        final int FRAME_WIDTH = 999;
        final int FRAME_HEIGHT = 890;
        
        
        frame.setSize (FRAME_WIDTH,FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creation of a new graph component
        GraphComponent compo = new GraphComponent();
        //addition of the frame to the graph component
        frame.add(compo);
        frame.setLayout(new BorderLayout());
        frame.add(compo,BorderLayout.CENTER);
        
        //panel creation
        JPanel panel = new JPanel();
        // creation of each graph element , label and text box buttons
        JButton  recButton =  new JButton ("Rectangle Node");
        JButton ellButton = new JButton ("Ellipse Node");
        JButton edgButton = new JButton ("Edge");
        JButton labelButton = new JButton ("Label");
        JTextField tbox= new JTextField (9);
        
        //addition of the buttons to the panel 
        panel.add(recButton);
        panel.add(ellButton);
        panel.add(edgButton);
        panel.add(labelButton);
        panel.add(tbox);
        
        
        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
        
        //listeners for each graph element, for the actions the user does
        class MyRNodeListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
            	//the rectangle button is clicked
                compo.rectisClicked (true);
                
            }
            
        }
        //creation of my rectangle node listener
        ActionListener MyRNodeLabeler= new MyRNodeListener();
        recButton.addActionListener (MyRNodeLabeler);
        
        
        
        class MyEllipseNodeListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
            	//the ellipse button is clicked
                compo.ellipseisClicked (true);
                
            }
            
        }
        //creation of my ellipse node listener 
        ActionListener MyEllipseNodeLabeler= new MyEllipseNodeListener();
        ellButton.addActionListener(MyEllipseNodeLabeler);
        
        
        class MyEdgeNodeListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
            	//the edge button is clicked
                compo.edgeisClicked (true);
                
            }
        }
        
        //creation of my edge node listener
        ActionListener MyEdgeNodeLabeler= new MyEdgeNodeListener();
        edgButton.addActionListener (MyEdgeNodeLabeler);
        
        
        class MyLabelListener implements ActionListener
        {
            public void actionPerformed  (ActionEvent event )
            {
            	//the text box gets the text that the user types in
                compo.label(tbox.getText());
                compo.labelisClicked ();
                
            }
        }
        //creation of my label listener
        ActionListener MyLabelListener = new MyLabelListener();
        labelButton.addActionListener(MyLabelListener);
    }
}






