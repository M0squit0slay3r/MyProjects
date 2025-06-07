
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong
{
	// frame size
	int frameX = 1200;
	int frameY = 800;
	
	/*// start position of ball
	int ballPositionX = 100;
	int ballPositionY = 100;*/
	
	int ballPositionX;
	int ballPositionY;
	
	// move ball in every loop by...
	int ballXstep;
	int ballYstep;
	
	
	// ball size
	int ballSizeX = 50;
	int ballSizeY = 50;
	
	// left panel/paddle position
	int leftPanelPositionX = 50;
	int leftPanelPositionY = frameY / 2;
	
	// left panel/paddle dimensions
	int leftPanelWidth = 10;
	int leftPanelHeight = 100;
	int leftPanelStep = 20;
	
	// right panel/paddle position
	int rightPanelPositionX = frameX - 60;
	int rightPanelPositionY = frameY / 2;
		
	// right panel/paddle dimensions
	int rightPanelWidth = 10;
	int rightPanelHeight = 100;
	int rightPanelStep = 20;

	Random random = new Random();
	
	public static void main(String[] args)
	{
		Pong gui = new Pong();
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		
		KeyboardListener keyboardListener = new KeyboardListener();
		frame.addKeyListener(keyboardListener);
		
		PongPanel animationPanel = new PongPanel();
		
		//frame settings
		frame.getContentPane().add(animationPanel);
		frame.setSize(frameX, frameY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		newBall();
		
		// loop for animation
		while(true)
		{
			// move the ball position
			ballPositionX = ballPositionX + ballXstep;
			ballPositionY = ballPositionY + ballYstep;
			
			if (ballPositionX < 0 || ballPositionX > frameX - ballSizeX) 
			{
				newBall();
	        }

			animationPanel.repaint();
			
			try
			{
				Thread.sleep(5);
			}  catch(Exception ex) {}
		}
		
	}
	
	public void newBall() 
	{
		ballPositionX = random.nextInt(frameX);
		ballPositionY = random.nextInt(frameY);
	    ballXstep = random.nextBoolean() ? 1 : -1;
	    ballYstep = random.nextBoolean() ? 1 : -1;
	
	}
	
	
	
	class PongPanel extends JPanel // inner class for Panel
	{
		public void paintComponent(Graphics g)
		{
			// delete the panel
			g.setColor(Color.white);
			g.fillRect(0,0, this.getWidth(), this.getHeight());
			
			// draw Ball
			g.setColor(Color.blue);
			g.fillOval(ballPositionX,ballPositionY,ballSizeX,ballSizeY);
			
			// check if ball hits the bottom of window/frame
			if(ballPositionY > (this.getHeight()- ballSizeY))
			{
				ballYstep = -ballYstep;
			}
			
			/*// check if ball hits the right wall
			if(ballPositionX > (this.getWidth()- ballSizeX))
			{
				ballXstep = -ballXstep;
			}*/
			
			// check if ball hits the top of window/frame
			if(ballPositionY < 0)
			{
				ballYstep = -ballYstep;
			}
			
			/*// check if ball hits the left wall
			if(ballPositionX < 0)
			{
				ballXstep = -ballXstep;
			}*/
			
			// draw the left paddle
			g.setColor(Color.orange);
			g.fillRect(leftPanelPositionX, leftPanelPositionY, leftPanelWidth, leftPanelHeight);
			
			// check if ball hits left paddle
			if((ballPositionX < leftPanelPositionX + leftPanelWidth)
				&& (ballPositionY + ballSizeY > leftPanelPositionY)
				&& (ballPositionY < leftPanelPositionY + leftPanelHeight)) 
			{
				ballXstep = -ballXstep;
			}
			
			// draw the right paddle
			g.setColor(Color.pink);
			g.fillRect(rightPanelPositionX, rightPanelPositionY, rightPanelWidth, rightPanelHeight);
						
			// check if ball hits right paddle
			if((ballPositionX + ballSizeX > rightPanelPositionX)
				&& (ballPositionY + ballSizeY > rightPanelPositionY)
				&& (ballPositionY < rightPanelPositionY + rightPanelHeight)) 
			{
				ballXstep = -ballXstep;
			}
			
		}
	} // end of inner class Panel
	
	// inner class for KeyboardListener
	class KeyboardListener implements KeyListener
	{
		public void keyPressed(KeyEvent e)  // empty code
		{
			// code for moving left paddle
			if (e.getKeyCode() == KeyEvent.VK_W)
			{
				leftPanelPositionY = leftPanelPositionY - leftPanelStep;
			}
			if (e.getKeyCode() == KeyEvent.VK_E)
			{
				leftPanelPositionY = leftPanelPositionY + leftPanelStep;
			}
			
			
			// code for moving right paddle
			if (e.getKeyCode() == KeyEvent.VK_O)
			{
				rightPanelPositionY = rightPanelPositionY - rightPanelStep;
			}
			if (e.getKeyCode() == KeyEvent.VK_P)
			{
				rightPanelPositionY = rightPanelPositionY + rightPanelStep;
			}
		}
		
		public void keyReleased(KeyEvent e) {} // empty code
		{}
		
		public void keyTyped(KeyEvent e) {} // empty code
		{}

	
	}// end of class KeyboardListener
	
	
}



