// rename to ImageArray.java and code the "*****" places
/*
use is “java ImageArray photofile.jpg blue param”
- param1 is filename of picture
- param2 is command (i.e. blue, or brightness)
- param3 is int or float (i.e. 1, 2, or 1.5, 2.3...)
→ add code for green & red
→ add code for contrast (pixelvalue = pixelvalue * param3Float)
*/
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageArray
{
	BufferedImage image;
	int red;
	int green;
	int blue;
	int cred;
	int cgreen;
	int cblue;

	public static void main(String[] args)
	{
		ImageArray imageArray = new ImageArray();
		imageArray.go(args);
	}
	
	public void go(String[] args)
	{ // use: filename command int/float
		String imageName = "C:\\Users\\sahin\\OneDrive\\Dokumenty\\JavaProjects\\ImageArray\\photo.jpg";
		File imagePath = new File(imageName);
		
		String command = args[0];
		
		String param3String = args[1];
		int param3 = (int) Float.parseFloat(param3String);
		float param3Float = Float.parseFloat(param3String);
		
		System.out.println("With the image in file: " + imageName);
		System.out.println("Command executed: " + command + "!");
		System.out.println("Value: " + param3);
		System.out.println("Value as Float: " + param3Float);
		
		try
    	{
			image = ImageIO.read(imagePath);
		}
		catch (IOException e)
    	{
      		e.printStackTrace();
    	}
		
		int[][] array = new int[image.getWidth()][image.getHeight()];
		for(int i = 0 ; i < image.getWidth(); i ++)
		{
			for(int j = 0 ; j < image.getHeight(); j++)
			{
				//The TYPE_INT_ARGB represents Color as an int (4 bytes) 
				//with alpha channel in bits 24-31, 
				//red channels in 16-23, green in 8-15 and blue in 0-7.
				array[i][j]=image.getRGB(i,j);
			}
		}
		
		// image array processing: here we work! Point operation mean: only the value of a point is used together with a scaling
		for(int i = 0 ; i < image.getWidth(); i ++)
		{
			for(int j = 0 ; j < image.getHeight(); j++)
			{
				// doing nothing = keep original
			
				// filtering alpha + red + green + blue: 11111111 + 00000000 + 00000000 + 11111111 = blue
				if (command.equals("blue"))
				{
					array[i][j] = array[i][j] & 0b11111111000000000000000011111111;
				}
				
				// filtering alpha + red + green + blue: 11111111 + 00000000 + 11111111 + 00000000 = green
				if (command.equals("green"))
				{
					array[i][j] = array[i][j] & 0b11111111000000001111111100000000;
				}
				
				// filtering alpha + red + green + blue: 11111111 + 11111111 + 00000000 + 00000000 = red
				if (command.equals("red"))
				{
					array[i][j] = array[i][j] & 0b11111111111111110000000000000000;
				}
				
				// increase contrast multiply
				if (command.equals("contrast"))
				{
					// get the single values for red, green, blue
					red 	= (array[i][j] & 0b00000000111111110000000000000000) >> 16;
					green 	= (array[i][j] & 0b00000000000000001111111100000000) >> 8;
					blue	= (array[i][j] & 0b00000000000000000000000011111111);
					
					// do the operation
					red = (int)(red * param3Float);
					green = (int)(green * param3Float);
					blue = (int)(blue * param3Float);
					
					if (red > 255) red = 255;
					if (green > 255) green = 255;
					if (blue > 255) blue = 255;
					
					// combine red & green & blue into single Integer and restore in array
					array[i][j] = (red << 16) + (green << 8) + blue;
				}
				
				// increase or decrease brightness
				if (command.equals("brightness"))
				{
					// get the single values for red, green, blue
					red 	= (array[i][j] & 0b00000000111111110000000000000000) >> 16;
					green 	= (array[i][j] & 0b00000000000000001111111100000000) >> 8;
					blue	= (array[i][j] & 0b00000000000000000000000011111111);
					
					// do the operation
					if (param3 > 0) // increase
					{
						if ((red + param3) > 255) red = 255; else red = red + param3;
						if ((green + param3) > 255) green = 255; else green = green + param3;
						if ((blue + param3) > 255) blue = 255; else blue = blue + param3;
					}
					else // decrease, param3 is negative i.e. -80
					{
						if ((red + param3) < 0) red = 0; else red = red + param3;
						if ((green + param3) < 0) green = 0; else green = green + param3;
						if ((blue + param3) < 0) blue = 0; else blue = blue + param3;
					}
					
					// combine red & green & blue into single Integer and restore in array
					array[i][j] = (red << 16) + (green << 8) + blue;
				}
			}
		}
		
		// image array stored back in image
		for(int i = 0 ; i < image.getWidth(); i ++)
		{
			for(int j = 0 ; j < image.getHeight(); j++)
			{
				image.setRGB(i, j, array[i][j]);
			}
		}
		
		// output on screen
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(imageLabel);
		frame.pack();
		frame.setVisible(true);
	}
}
