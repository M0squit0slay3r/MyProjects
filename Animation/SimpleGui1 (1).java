import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1 implements ActionListener
{
	JButton button; // instance variable
	
	public static void main(String[]args)
	{
		SimpleGui1 gui = new SimpleGui1(); // makes an object
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame(); // generate window
		button = new JButton("click me!!!"); // generate button
		
		button.addActionListener(this);
		
		frame.getContentPane().add(button); // add button to window
		frame.setSize(800,800); // in pixels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing window closes also Java program
		frame.setVisible(true); // now window is shown 
	}
	
	public void actionPerformed(ActionEvent event)
	{
		button.setText("I've been clicked");
	}
}
