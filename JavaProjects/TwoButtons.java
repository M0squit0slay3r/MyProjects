package Buttons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons
{
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args)
	{
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Circle");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
	
	class LabelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			label.setText("Ouch!");
		}
	}
	
	class ColorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			frame.repaint();
		}
	}
}

class MyDrawPanel extends JPanel
{
	public void paintComponent(Graphics g) {
        // Casting it so we can access G2D methods
        Graphics2D g2d = (Graphics2D) g;
        // Starting point, color, gradient point, color.

        Color startColor = MyDrawPanel.makeRandomColor();
        Color endColor = MyDrawPanel.makeRandomColor();
        GradientPaint gradient = new GradientPaint(60,60,startColor,150,150,endColor);
        // Set virtual paint brush to a gradient instead of solid color.

        g2d.setPaint(gradient);
        // Fill oval with whatever is loaded on to the paintbrush

        g2d.fillOval(90,90,100,100);
    }

    public static Color makeRandomColor() {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        return new Color(red, green, blue);
    }
}