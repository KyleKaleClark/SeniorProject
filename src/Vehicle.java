import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Vehicle {
	private int xLoc;
	private int yLoc;;
	private int height;
	private int len;
	private String img;
	private int dir;
	
	public Vehicle (int x, int y, int height, int len, String img, int dir)
	{
		this.xLoc = x;
		this.yLoc = y;
		this.height = height;
		this.len = len;
		this.img = img;		
		this.dir = dir;

	}
	//LOCATION
	public int getXLoc()
	{
		return xLoc;
	}
	public int getYLoc()
	{
		return yLoc;
	}
	public int getHeight()
	{
		return height;
	}
	public int getLen()
	{
		return len;
	}
	
	public void setXLoc(int newLocX)
	{
		xLoc = newLocX;
	}
	public void setYLoc(int newLocY)
	{
		yLoc = newLocY;
	}
	public void moveX()
	{
		xLoc += 1 * dir;
		int newX = (int) ((Math.random() * 100) - 200);
		
		if (xLoc >= 1100){ xLoc = newX; }
		if (xLoc < -400){ xLoc = 1000; }
		//System.out.println(xLoc);
	}
	public void moveY()
	{
		yLoc += 1 * dir;
		if (yLoc >= 450){ yLoc = 450; }
		if (yLoc < 0){ yLoc = 0; }
		//System.out.println(yLoc);
	}
	public int[] getRect()
	{
		int[] rect = {getXLoc(), getYLoc(), getLen(), getHeight()};
		return rect;
	}
	
	//Paints
	public void draw(Graphics g, Panel c) {
		// TODO Auto-generated method stub
		ImageIcon i = new ImageIcon(this.img);
		i.paintIcon(c, g, getXLoc(), getYLoc());
	}
}
