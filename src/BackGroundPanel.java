import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class BackGroundPanel extends JPanel implements Runnable,KeyListener{
	int width=750;
	int height;
	// Ball Size
	float radius = 8; 
	float diameter = radius * 2; 
	// Center of Call
	float X = radius + 300;
	float Y = radius + 300;
	// Direction yön ve topun yer değştirme hızı
	float dx = 5;
	float dy = 4;  
	  //paddle için
	int paddle_x=300;

	int score=0;
	int lives=3;
	
	boolean playball=false;
	boolean playball1;
	protected Image backgroundImage;
	private ImageIcon myBackgroundIcon;
	private int paddle_size=100; 
	  
	//constructor
	public BackGroundPanel(String fileName) throws IOException {
		myBackgroundIcon=new ImageIcon(getClass().getResource(fileName));
		
		backgroundImage =myBackgroundIcon.getImage(); 
		
		addKeyListener(this);
		//görünmesi için
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}	
	
	boolean level1=false;
	boolean level2=false;
	
	public void run() {
//    	Sound mysound= new Sound();
//    	mysound.play();

		create_bricks_level1();
		//create_bricks_level2();
		while (true) {
		
       	//topun çevresini dikdörtgen olarak algılasın diye
			//top ve paddle çarpışması
			Rectangle ball = new Rectangle((int)X, (int)Y, (int)diameter, (int)diameter);
			Rectangle paddle = new Rectangle(paddle_x, 540, paddle_size, 10);
			if(ball.intersects(paddle)) {
        		dy=-dy;
        	}
			
			if(playball==true && playball1==false) {
				width = getWidth();
				height = getHeight();
		          
				X = X + dx ;
				Y = Y + dy;
		 
				if(X<0) {
					dx=-dx;
				}
				if(Y<0) {
					dy=-dy;
				}
				else if (X + radius > 750) {
					dx = -dx;
		            X = width - radius;
				}
				else if (Y + radius > height) {
					dy = -dy;
		            Y = height - radius;
		            lives=lives-1;
				}
				

			//	bricks_and_ball_collision2();
			}
			bricks_and_ball_collision();
			repaint();
			try {
	            Thread.sleep(25);
			} catch (InterruptedException ex) {	
			}
        }
    } 
	
	//brick bonus beyaza çarptığında paddle büyür
	public void bricks_and_ball_collision() {
		Rectangle ball = new Rectangle((int)X, (int)Y, (int)diameter, (int)diameter);
		for (int i = 0; i < mybrick.length; i++) {
			if (mybrick[i] != null) {
				if (mybrick[i].intersects(ball)) {
					mybrick[i] = null;
					dy=-dy;
					numberofbricks++;
					score+=15;
					//sound();
				}
			}
		}
	}
	
	public void bricks_and_ball_collision2() {
		Rectangle ball = new Rectangle((int)X, (int)Y, (int)diameter, (int)diameter);
		for (int i = 0; i < mybrick2.length; i++) {
			if (mybrick2[i] != null) {
				if (mybrick2[i].intersects(ball)) {
					mybrick2[i] = null;
					dy=-dy;
					numberofbricks2++;
					score+=15;
					//sound();
				}
			}
		}
	}
	
	//level2 çizimi
	Rectangle[] mybrick2 = new Rectangle[36];
	private int numberofbricks2;
	int brick2x = 100;
	int brick2y = 70;
	public void create_bricks_level2() {
		//create bricks
		for (int i = 0; i < mybrick2.length; i++) {
			mybrick2[i] = new Rectangle(brick2x, brick2y, 40, 20);
			if (i == 1) {
				brick2x = 100;
				brick2y = 92;
			}
			if(i==3) {
				brick2x=145;
				brick2y=114;
			}
			if(i==5) {
				brick2x=190;
				brick2y=136;
			}
			if(i==7) {
				brick2x=235;
				brick2y=158;
			}
			if(i==9) {
				brick2x=280;
				brick2y=136;
			}
			if(i==11) {
				brick2x=325;
				brick2y=114;
			}
			if(i==13) {
				brick2x=370;
				brick2y=92;
			}
			if(i==15) {
				brick2x=415;
				brick2y=70;
			}
			if(i==17) {
				brick2x=235;
				brick2y=158;
			}
			if(i==19) {
				brick2x=190;
				brick2y=180;
			}
			if(i==21) {
				brick2x=145;
				brick2y=202;
			}
			if(i==23) {
				brick2x=100;
				brick2y=224;
			}
			if(i==25) {
				brick2x=55;
				brick2y=246;
			}
			if(i==27) {
				brick2x=280;
				brick2y=180;
			}
			if(i==29) {
				brick2x=325;
				brick2y=202;
			}
			if(i==31) {
				brick2x=370;
				brick2y=224;
			}
			if(i==33) {
				brick2x=415;
				brick2y=248;
			}
			brick2x +=45;
		}
	}
	
	
	//level1 çizimi
	Rectangle[] mybrick = new Rectangle[44];
	private int numberofbricks;
	int brickx = 200;
	int bricky = 70;
	public void create_bricks_level1() {
		//create bricks
		for (int i = 0; i < mybrick.length; i++) {
			mybrick[i] = new Rectangle(brickx, bricky, 40, 20);
			if (i == 7) {
				brickx = 200;
				bricky = 92;
			}
			if (i == 13) {
				brickx = 242;
				bricky = 114;
			}
			if(i == 17){
				brickx = 284;
				bricky = 136;
			}
			if(i == 19){
				brickx=20;
				bricky=130;
			}
			if(i == 21){
				brickx=20;
				bricky=152;
			}
			if(i == 23){
				brickx=550;
				bricky=130;
			}
			if(i == 25){
				brickx=550;
				bricky=152;
			}
			if(i==27){
				brickx=0;
				bricky=230;
			}
			brickx += 42;
		}
	}
	
	
	boolean choosinglevel=true;
	boolean choosinglevel1=false;
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, null);
        //ball
        g.setColor(Color.CYAN);
        g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
        //paddle
        g.setColor(Color.RED);
        g.fillRect(paddle_x, 540, paddle_size, 10);
        //score
        g.setColor(Color.LIGHT_GRAY);;
        g.setFont(new Font("serif",Font.BOLD,17));
        g.drawString("Score:" + score, 0,20);
        //can
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("serif",Font.BOLD,17));
        g.drawString("Lives: " + lives, 0, 40);
    
        
        if(numberofbricks==44) {
        	dx=0;
        	dy=0;
        	g.setColor(Color.WHITE);
        	g.setFont(new Font("serif", Font.ITALIC, 30));
        	g.drawString("YOU WON, YOUR SCORE: "+ score, 190, 300);
        	choosinglevel=false;
        	
        }
        //level1 çizimi
        if(choosinglevel==true) {
            //brickleri çizmek için
            for(int i =0; i<mybrick.length;i++) {
            	if(mybrick[i]!=null) {
            		g.setColor(Color.YELLOW);
            		g.fill3DRect(mybrick[i].x, mybrick[i].y, mybrick[i].width, mybrick[i].height, true);
            	}
            }
        }
        
        if(choosinglevel1==false) {
            for(int i=0; i<mybrick2.length;i++) {
            	if(mybrick2[i]!=null) {
            		g.setColor(Color.GREEN);
            		g.fill3DRect(mybrick2[i].x, mybrick2[i].y, mybrick2[i].width, mybrick2[i].height, true);
            	}
            }
        }
        if(numberofbricks2==36) {
        	dx=0;
        	dy=0;
        	g.setColor(Color.WHITE);
        	g.setFont(new Font("serif", Font.ITALIC, 30));
        	g.drawString("YOU WON, YOUR SCORE: "+ score, 190, 300);
        }
        //can ve blok sayısı bittiğinde
        if(lives==-1) {
			dx=0;
			dy=0;
		  	g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("GAME OVER, your score: "+score,190,300);
		}
        
        //oyunu durduğumda ekrana çıkan yazı yukarı ok tuşuna bas
        if(playball1==true) {
        	g.setColor(Color.WHITE);
        	g.setFont(new Font("serif", Font.ROMAN_BASELINE, 15));
        	g.drawString("YOU PAUSED THE GAME PRESS SPACE TO CONTINUE ", 190, 300);
        }
    	
        g.dispose();
    }
  
	@Override
	public void keyPressed(KeyEvent event) {
		String whichKey=KeyEvent.getKeyText(event.getKeyCode());	
		if(whichKey.compareTo("Left")==0){
			changeLayoutLeft();
		}
		else if(whichKey.compareTo("Right")==0){	
			changeLayoutRight();
		}
		else if (whichKey.compareTo("Space")==0) {
			playball=true;
			playball1=false;
		}
		if(whichKey.compareTo("Up")==0) {
			playball1=true;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_2) {
			create_bricks_level1();
			bricks_and_ball_collision();
		}
		if((event.getKeyCode()==KeyEvent.VK_Q) && (event.getKeyCode()==KeyEvent.CTRL_MASK)!=true) {
			System.exit(0);
		}
	}
	
	public void changeLayoutLeft(){
		if(paddle_x>=9) {
			paddle_x-=50;	
		}
	}
	public void changeLayoutRight(){
		if(paddle_x<=642) {
			paddle_x+=50;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}
