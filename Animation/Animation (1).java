import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Animation implements ActionListener
{
	JFrame frame;
	
	public static void main(String[]args)
	{
		Animation gui = new Animation(); // makes an object
		gui.go();
	}
	
	public void go()
	{
		// generate the widgets
		frame = new JFrame(); // generate window
		MyDrawPanel myDrawPanel = new MyDrawPanel(); 
		JButton button = new JButton("Change Colors");
		button.addActionListener(this);
		
		// put the widgets on frame
		frame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		
		frame.setSize(800,800); // in pixels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing window closes also Java program
		frame.setVisible(true); // now window is shown 
	} // end of go
	
	public void actionPerformed(ActionEvent event)
	{
		frame.repaint(); // repaint calls paintComponent
	}
} // end of class Animation

class MyDrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		// code generating graphics
		int red = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		Color startColor = new Color(red, green,blue);
		
		red = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		green = (int)(Math.random()*255);
		Color endColor = new Color(red, green,blue);
		
		GradientPaint gradient = new GradientPaint(70,70,startColor,500,500,endColor);
		
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 400, 400);
		
		
	}
}





