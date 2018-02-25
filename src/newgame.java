import java.io.IOException;
import javax.swing.JFrame;

public class newgame extends JFrame{
	
	private JFrame level1frame;
	private BackGroundPanel paddlepanel;	
	Thread mythread=null;
	
	public newgame() throws IOException{
		level1frame =new JFrame("CSE212 Arkanoid Game");
		paddlepanel = new BackGroundPanel("star1.jpeg");
		paddlepanel.setLayout(null);
		level1frame.add(paddlepanel);
		level1frame.setSize(750, 550);
		level1frame.setVisible(true);
		
		mythread=new Thread(paddlepanel);
		mythread.start();
		
		level1frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
