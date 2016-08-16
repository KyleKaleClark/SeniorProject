import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import java.applet.*;
import java.net.*;

public class Music implements Runnable, LineListener {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			AudioClip clip = Applet.newAudioClip(
			new URL("src/sound/frogger.wav"));
			clip.play();
			} catch (MalformedURLException murle) {
			System.out.println(murle);

			}
		
	}
	public static void runThread(){
		(new Thread(new Music())).start();
	}
	@Override
	public void update(LineEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


