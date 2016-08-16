import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frogger {
	private int xLoc = 350;
	private int yLoc = 600;
	private int lives;
	private String img = "src/img/imgU.png";
	private int score = 0;
	
	private static Frogger instance = new Frogger(3);
	
	private Frogger(int lives)
	{
		this.lives = lives;
	}
	public static Frogger getInstance(){return instance;}
	
	public int getScore(){return score;}
	public void addScore(int addition){ score += addition;}
	//LOCATION GET/SET
	public int getXLoc()
	{
		return xLoc;
	}
	public int getYLoc()
	{
		return yLoc;
	}
	
	public void setXLoc(int newLocX)
	{
		xLoc = newLocX;
	}
	public void setYLoc(int newLocY)
	{
		yLoc = newLocY;
	}
	
	
	//LIVING STATUS
	public int getLives()
	{
		return lives;
	}
	public void setLives(int newLives)
	{
		lives = newLives;
	}

	
	
	//MOVEMENT
	public void moveX(int dir)
	{
		xLoc += 50 * dir;
		if (xLoc >= 700){ xLoc = 650; }
		if (xLoc < 0){ xLoc = 0; }
		System.out.println("x" + xLoc);
		if(dir > 0){this.img = "src/img/imgR.png";}
		if(dir < 0){this.img = "src/img/imgL.png";}
		System.out.println(img);
		
		
	}
	public void moveY(int dir)
	{
		
		yLoc += 50 * dir;
		if (dir < 0)
			score += 10;
		if (dir > 0 && getYLoc() != 650)
			score -= 10;
		
		if (yLoc >= 650){ yLoc = 600; }
		if (yLoc < 0){ yLoc = 0; }
		System.out.println(yLoc);
		if(dir > 0){this.img = "src/img/imgD.png";}
		if(dir < 0){this.img = "src/img/imgU.png";}
		
	}
	
	public void paintFrogger(Graphics g, Panel c)
	{
		ImageIcon i = new ImageIcon(img);
		i.paintIcon(c, g, getXLoc(), getYLoc());
	}
	public void killFrogger(){
		setLives(getLives() - 1);
		setXLoc(400);
		setYLoc(600);
	}
	

	
	
	
	
}
