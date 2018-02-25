import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.NetworkChannel;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class OptionListFrame extends JFrame implements ActionListener{	
	private JButton btnnewgame;
	private JButton btnoptions;
	private JButton btnhighscore;
	private JButton btnhelp;
	private JButton btnabout;
	private JButton btnexit;

	private JPanel mypanel = new MainBackground("startingbackground.jpg");
	
	public OptionListFrame() throws IOException {
		super("CSE 212 Arkanoid Game");
		add(mypanel);
		mypanel.setLayout(null);
		
		btnnewgame = new JButton("New Game");
		btnnewgame.setForeground(Color.white);
		btnnewgame.setBounds(350,90,200,40);
		btnnewgame.setContentAreaFilled(false);
		btnnewgame.addActionListener(this);
		btnnewgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							try {
								newgame mynewgame = new newgame();
								Sound mysound=new Sound();
								mysound.play(1);
							} catch (Exception e) {
								// TODO: handle exception
							}
						
						}
					}).start();
					

			}
		});
		mypanel.add(btnnewgame);
	
		btnoptions = new JButton("Options");
		btnoptions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnoptions.setForeground(Color.white);
//		btnoptions.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Frame optionFrame=new JFrame();
//				String[] difficultylevel = { "Novice,", "Intermediate", "Advanced"};
//				JComboBox<String> difficultList = new JComboBox<>(difficultylevel);
//				difficultList.setSelectedIndex(2);
//				optionFrame.add(difficultList);
//				difficultList.addActionListener(this);
//				difficultList.setBounds(140,95,120,30);
//				optionFrame.setVisible(true);
//				optionFrame.setSize(400,350);
//			}
//		});
		
		btnoptions.setBounds(350,150,200,40);
		btnoptions.setContentAreaFilled(false);
		mypanel.add(btnoptions);
		
		btnhighscore = new JButton("High Scores");
		btnhighscore.setForeground(Color.white);
		btnhighscore.setContentAreaFilled(false);
		btnhighscore.addActionListener(this);
		btnhighscore.setBounds(350,210,200,40);
		mypanel.add(btnhighscore);
		
		
		btnhelp = new JButton("Help");
		btnhelp.setContentAreaFilled(false);
		btnhelp.setForeground(Color.WHITE);
		btnhelp.setBounds(350,270,200,40);
		btnhelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				Frame helpFrame=new JFrame();
				setLayout(new FlowLayout());
				helpFrame.setVisible(true);
				helpFrame.setSize(400, 200);
				//((JFrame) helpFrame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
				JLabel helpJlabel = new JLabel();
				String message= ("<html><h1> How To Play Arkanoid: </h1> "
						+ "The objective of Arkanoid or Brick Breaker is "
						+ "to break all the bricks on the screen using the ball."
						+ " Players use the mouse to control the board that keeps the ball from falling down. "
						+ "The game ends when the player's ball falls down. "
						+ "Hitting certain bricks can affect the game in different ways,"
						+ " like releasing an extra ball, or changing the size of the board."
						+ " The introduction to the game contains game instructions and"
						+ " a link with useful playing tips. </html>");
				
				//helpJlabel.setIcon(icon);
				helpJlabel.setText(message);
				helpFrame.add(helpJlabel);	
			}
		});
		mypanel.add(btnhelp);
		
		btnabout = new JButton("About");
		btnabout.setBounds(350,330,200,40);
		btnabout.setForeground(Color.white);
		btnabout.setContentAreaFilled(false);
		btnabout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application Developer is: Ayşenur Yılmaz","STUDENT INFORMATION",JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Student in Yeditepe University","STUDENT INFORMATION",JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null,"Student Number: 20140702057","STUDENT INFORMATION",JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "aysenuryilmaz12@gmail.com","STUDENT INFORMATION",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mypanel.add(btnabout);
		
		btnexit = new JButton("Exit");
		btnexit.setForeground(Color.white);
		btnexit.setBounds(350,390,200,40);
		btnexit.setContentAreaFilled(false);
		btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OptionListFrame.this.setVisible(false);
			}
		});
		mypanel.add(btnexit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	public String getResource(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
