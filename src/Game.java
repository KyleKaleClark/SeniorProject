import javax.swing.JFrame;

public class Game {
	
	
	public static void main(String[] args)
	{
		Panel t = new Panel();
		JFrame jf = new JFrame();
		jf.setTitle("Game");
		jf.setSize(725, 750);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.addKeyListener(t);
		jf.setLocation((1920/2)-(725/2),(1080/2)-(750/2));
		jf.setResizable(false);
		

	}
}
