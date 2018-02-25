import java.io.IOException;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException{

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Sound mSound = new Sound();
					mSound.play(1);
					OptionListFrame frame=new OptionListFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(false);
					frame.setSize(900,600);
					frame.setVisible(true);	
				} catch (Exception e) {
				}			
			}
		}).start();
				
	}
}


