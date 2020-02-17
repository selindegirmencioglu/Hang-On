package javaProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Game extends JPanel{



  private JFrame frame;
  private JPanel panel;
  private JLabel label1,label2;
  private ImageIcon image,image1;
  ImageIcon [] array= new ImageIcon[9];
  ImageIcon [] roadArray= new ImageIcon[9];
  boolean rightFlag=false;
  boolean leftFlag=false;
  boolean upFlag=false;
  boolean downFlag=false;
  int i=4;
  int speed=400;
  int changex=-400;
  public void changex(int x)
  {

	  label2.setBounds(x,0, 2000, 800); 

	
	 
  }
  

  public void createGUI3(){
	  
	  array[0]=image=new ImageIcon(getClass().getResource("sol4.png"));
	  array[1]=image=new ImageIcon(getClass().getResource("sol3.png"));
	  array[2]=image=new ImageIcon(getClass().getResource("sol2.png"));
	  array[3]=image=new ImageIcon(getClass().getResource("sol1.png"));
	  array[4]=image=new ImageIcon(getClass().getResource("düz.png"));
	  array[5]=image=new ImageIcon(getClass().getResource("sað1.png"));
	  array[6]=image=new ImageIcon(getClass().getResource("sað2.png"));
	  array[7]=image=new ImageIcon(getClass().getResource("sað3.png"));
	  array[8]=image=new ImageIcon(getClass().getResource("sað4.png"));

	  roadArray[0]=image1=new ImageIcon(getClass().getResource("duzyol.png"));
	  roadArray[1]=image1=new ImageIcon(getClass().getResource("duzyol3.png"));
	  
	  
	  frame = new JFrame("HANG-ON");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel = new JPanel();
	  
	  image=new ImageIcon(getClass().getResource("düz.png"));

	  label1 = new JLabel(image);  
	  label1.setBounds(150, 360, 900, 600); 
	  

	  label2= new JLabel(image1);
	  label2.setBounds(-400,0, 2000, 800); 
	  
	  
	  panel.setLayout(null);  
	  frame.add(label1);
	  frame.add(label2);
	  frame.add(panel);
	  frame.setBounds(400,120,1200,800);
	  frame.setVisible(true);
	  frame.setResizable(false);


	  
	  
	  
	  Thread rightThread =new Thread(){ 
   		  public void run(){
	   			while(true){
	   				if(rightFlag) {
				    	label1.setIcon(array[i]);
				    	frame.repaint();
					    	if(i==8) {
			   					i=7;
			   				}
					    i++;	
		   			}
	   				
	   				else if (rightFlag==false && i>4) {
	   					i--;
	   					label1.setIcon(array[i]);
				    	frame.repaint();
					    	
		   			}
	   			  try {
	   				Thread.sleep(90);
	   			  } 
	   			  catch (InterruptedException e) {
	   				// TODO Auto-generated catch block
	   				e.printStackTrace();
	   					
	   			  }
	   			 }
   			 }
   		  
   	  };
   	  rightThread.start();


   	  
   	  
   	 Thread leftThread =new Thread(){ 
  		  public void run(){
	   			while(true){
	   				if(leftFlag) {
				    	label1.setIcon(array[i]);
				    	frame.repaint();
					    	if(i==0) {
			   					i=1;
			   				}
					    i--;	
		   			}
	   				
	   				else if (leftFlag==false && i<4) {
	   					i++;
	   					label1.setIcon(array[i]);
				    	frame.repaint();
					   	
		   			}
	   			  try {
	   				Thread.sleep(90);
	   			  } 
	   			  catch (InterruptedException e) {
	   				// TODO Auto-generated catch block
	   				e.printStackTrace();
	   					
	   			  }
	   			 }
  			  }
  		  
  	  };
  	  leftThread.start();
	  
	  
	  

  	  
  	  
  	  
  	 Thread roadThread =new Thread(){ 
 		  public void run(){
 			  int z=1;
	   			while(true) {
	   				
	   				if(upFlag) {
				    	
				    	label2.setIcon(roadArray[z]);
				    	frame.repaint();
				    	
				    	if(z==1) {
				    		z=0;
				    	}
				    	else
				    		z=1;
	   				}
	   				
	   			  try {
	   				Thread.sleep(speed);
	   			  } 
	   			  catch (InterruptedException e) {
	   				// TODO Auto-generated catch block
	   				e.printStackTrace();
	   					
	   			  }
	   			 }
 			  }
 		  
 	  };
 	 roadThread.start();
	  
  	  
  	  
  	  
  	  
  	  
  	  
  	  
  	  

	
	  
	  
	KeyListener keyListener= new KeyListener() {
	
		
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent k) {
			// TODO Auto-generated method stub
			int key = k.getKeyCode();
			if (key == KeyEvent.VK_RIGHT) {
				rightFlag=false;
				
			}

			if (key == KeyEvent.VK_LEFT) {
				leftFlag=false;
				
			}
			
			
		}
		
		@Override
		public void keyPressed(KeyEvent k) {
			 int key = k.getKeyCode();

			    if (key == KeyEvent.VK_LEFT) {
			       leftFlag=true;
			       if(changex<-10) {
				       changex(changex);
				       changex=changex+20;
			       }

			    }

			    if (key == KeyEvent.VK_RIGHT) {
			    	rightFlag=true;
			    	if(changex>-820) {
				    	changex(changex);
				    	changex=changex-20;
			    	}
			    }

			    if (key == KeyEvent.VK_UP) {
			    	upFlag=true;
			    	if(speed>50) {
			    		speed=speed-30;
			    	}
			    	else
			    		speed=50;
			        
			    }

			    if (key == KeyEvent.VK_DOWN) {
			    	downFlag=true;
			    	if (speed<400)
			    		speed=speed+50;
			    	else
			    		speed=400;
			    }

			
		}
	};  
	  
	frame.addKeyListener(keyListener); 
 
  
  
  
    

 
  }
  
  
  
}