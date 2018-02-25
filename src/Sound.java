import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sound{
	public static void play(int a) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(a==1) {
					try {
						File file = new File("/home/aysenur/eclipseworkspace/ProjectArkanoid/src/snowmusic.mp3");
						FileInputStream fls= new FileInputStream(file);
						BufferedInputStream bis = new BufferedInputStream(fls);
						
						try {
							Player player= new Player(bis);
							player.play();
						} catch (JavaLayerException ex) {
						}
					} catch (Exception e) {
						}
				}
				if(a==2) {
					try {
					File file1 = new File("/home/aysenur/eclipseworkspace/ProjectArkanoid/src/aa.mp3");
					FileInputStream fls1=new FileInputStream(file1);;
					BufferedInputStream bis1 = new BufferedInputStream(fls1);
					try {
						Player player= new Player(bis1);
						player.play();
					} catch (JavaLayerException ex) {
					}
					}catch(Exception e) {	
					}
				}
			}
		}).start();
	}
}
