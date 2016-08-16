import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener, KeyListener {
	Timer tm = new Timer(5, this);
	int x = 0, y = 0, velX = 0, velY = 0;
	Frogger froggy = Frogger.getInstance();
	
	ImageIcon roadBottom = new ImageIcon("src/img/pavement-start.png");
	ImageIcon roadTop = new ImageIcon("src/img/pavement-end.png");
	ImageIcon grass = new ImageIcon("src/img/grass.png");
	
	
	String audioFilePath = "src/sound/frogger.mp3";
	 


	
      
    
	GameLogic gameLog = new GameLogic();
	Vehicle[] truckList = gameLog.getTruckList();
	Log[] logList = gameLog.getLogList();
	Goal[] goalList = gameLog.getGoalList();
	public Panel()
	{
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.drawRect(200, 200, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(0, 50, 1000, 300);
		g.setColor(Color.black);
		g.fillRect(0, 650, 800, 50);
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
		g.drawString("Fred Lives: " + froggy.getLives(), 25,680);
		g.drawString("Fred Points  " + froggy.getScore() , 300, 680);
		
		roadBottom.paintIcon(this, g, 0, 600);
		roadTop.paintIcon(this, g, 0, 350);
		grass.paintIcon(this, g, 0, 0);
		g.setColor(Color.BLACK);
		g.fillRect(0, 400, 1000, 200);
		
		
		
		for (int i = 0; i < truckList.length; i++)
		{
			truckList[i].draw(g, this);
			truckList[i].moveX();
		}
		for (int i = 0; i < goalList.length; i++){
			goalList[i].draw(g, this);
		}
		for (int i = 0; i < logList.length; i++){
			logList[i].draw(g, this);
			logList[i].moveX();
		}
		if (froggy.getLives() > 0)
		{
			froggy.paintFrogger(g, this);
			gameLog.checkIntersections();
		}
		else {
			g.drawString("Game OVER", 300, 300);
		}
		gameLog.checkWin();
		Music mu = new Music();
		mu.runThread();
		

		 
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x = x + velX;
		y = y + velY;
		repaint();
	}
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		if (froggy.getLives() > 0)
		{
			if (c == KeyEvent.VK_LEFT){
				froggy.moveX(-1);
			}
			if (c == KeyEvent.VK_RIGHT){
				froggy.moveX(1);
			}
			if (c == KeyEvent.VK_UP){
				froggy.moveY(-1);
			}
			if (c == KeyEvent.VK_DOWN){
				froggy.moveY(1);
			}
			if (c == KeyEvent.VK_D)
			{
				froggy.setLives(froggy.getLives() - 1);
			}
		}
		if (froggy.getLives() == 0 && c == KeyEvent.VK_SPACE){
			froggy.setLives(3);
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
		velY = 0;
		velX = 0;
	}
	
	

}
