import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Goal {
	
	private int xLoc;
	private int yLoc;
	private int height = 49;
	private int len = 49;
	private String img = "src/img/goal.png";
	private boolean isActive = true;
	
	public Goal(int x, int y)
	{
		this.xLoc = x;
		this.yLoc = y;
		this.height = height;
		this.len = len;
	}

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
	public void setActive(boolean active){
		isActive = active;
	}
	public void changeImage(String img1){
		this.img = img1;
	}
	public boolean returnActive(){return isActive;}
	

	public int[] getRect()
	{
		int[] rect = {getXLoc(), getYLoc(), getHeight(), getLen()};
		return rect;
	}
	
	//Paints
	public void draw(Graphics g, Panel c)
	{
		ImageIcon i = new ImageIcon(img);
		i.paintIcon(c, g, getXLoc(), getYLoc());
		
	}
}
