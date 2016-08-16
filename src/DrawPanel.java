import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout; 

	public class DrawPanel extends JPanel
	{
		private int x = 10;
	    public DrawPanel()                       // set up graphics window
	    {
	        super();
	        setBackground(Color.WHITE);
	    }

	    public void paintComponent(Graphics g)  // draw graphics in the panel
	    {
	        int width = getWidth();             // width of window in pixels
	        int height = getHeight();           // height of window in pixels

	        super.paintComponent(g);            // call superclass to make panel display correctly


	        // Drawing code goes here
	        g.drawString("muck duck", x, 12);
	        revalidate();
	        repaint();
	    }
	    public void setX(int newX)
	    {
	    	x = newX;
	    }
	    public int getX()
	    {
	    	return x; 
	    }

	}

