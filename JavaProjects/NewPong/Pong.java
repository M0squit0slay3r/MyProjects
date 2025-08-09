import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class Pong
{
    // Frame size
    int frameX = 1200;
    int frameY = 800;

    // Ball position
    int ballPositionX;
    int ballPositionY;

    // Ball movement
    int ballXstep;
    int ballYstep;

    // Ball speed
    int baseSpeed = 1;
    int paddleHitSpeedIncrease = 1; // Increase in speed after hitting a paddle

    // Ball size
    int ballSizeX = 50;
    int ballSizeY = 50;

    // Left paddle position
    int leftPanelPositionX = 50;
    int leftPanelPositionY = frameY / 2;

    // Left paddle dimensions
    int leftPanelWidth = 10;
    int leftPanelHeight = 100;
    int leftPanelStep = 30;

    // Right paddle position
    int rightPanelPositionX = frameX - 60;
    int rightPanelPositionY = frameY / 2;

    // Right paddle dimensions
    int rightPanelWidth = 10;
    int rightPanelHeight = 100;
    int rightPanelStep = 30;

    // Scores
    int leftPlayerScore = 0;
    int rightPlayerScore = 0;

    // Random generator
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

        // Frame settings
        frame.getContentPane().add(animationPanel);
        frame.setSize(frameX, frameY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        newBall();

        // Loop for animation
        while(true)
        {
            // Move the ball position
            ballPositionX = ballPositionX + ballXstep;
            ballPositionY = ballPositionY + ballYstep;

            // Check if ball hits walls
            if (ballPositionX < 0 || ballPositionX > frameX - ballSizeX)
            {
                if (ballPositionX < 0) {
                    rightPlayerScore++;
                } else {
                    leftPlayerScore++;
                }
                if (leftPlayerScore >= 5 || rightPlayerScore >= 5) {
                    JOptionPane.showMessageDialog(frame, "Game Over! " + (leftPlayerScore >= 5 ? "Left Player" : "Right Player") + " wins!");
                    System.exit(0);
                }
                newBall();
            }

            // Increase ball speed significantly after hitting a paddle
            if ((ballPositionX < leftPanelPositionX + leftPanelWidth)
                    && (ballPositionY + ballSizeY > leftPanelPositionY)
                    && (ballPositionY < leftPanelPositionY + leftPanelHeight))
            {
                ballXstep = Math.abs(ballXstep) + paddleHitSpeedIncrease;
            }

            if ((ballPositionX + ballSizeX > rightPanelPositionX)
                    && (ballPositionY + ballSizeY > rightPanelPositionY)
                    && (ballPositionY < rightPanelPositionY + rightPanelHeight))
            {
                ballXstep = -Math.abs(ballXstep) - paddleHitSpeedIncrease;
            }

            animationPanel.repaint();

            try
            {
                Thread.sleep(5);
            } catch(Exception ex) {}
        }

    }

    public void newBall()
    {
        ballPositionX = random.nextInt(frameX - ballSizeX);
        ballPositionY = random.nextInt(frameY - ballSizeY);
        ballXstep = (random.nextBoolean() ? 1 : -1) * baseSpeed;
        ballYstep = (random.nextBoolean() ? 1 : -1) * baseSpeed;
    }

    class PongPanel extends JPanel // Inner class for Panel
    {
        public void paintComponent(Graphics g)
        {
            // Clear the panel
            g.setColor(Color.white);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            // Draw the ball
            g.setColor(Color.blue);
            g.fillOval(ballPositionX,ballPositionY,ballSizeX,ballSizeY);

            // Check if ball hits the bottom of window/frame
            if(ballPositionY > (this.getHeight() - ballSizeY))
            {
                ballYstep = -ballYstep;
            }

            // Check if ball hits the top of window/frame
            if(ballPositionY < 0)
            {
                ballYstep = -ballYstep;
            }

            // Draw the left paddle
            g.setColor(Color.orange);
            g.fillRect(leftPanelPositionX, leftPanelPositionY, leftPanelWidth, leftPanelHeight);

            // Draw the right paddle
            g.setColor(Color.pink);
            g.fillRect(rightPanelPositionX, rightPanelPositionY, rightPanelWidth, rightPanelHeight);

            // Draw scores
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Left Player: " + leftPlayerScore, 50, 50);
            g.drawString("Right Player: " + rightPlayerScore, frameX - 300, 50);
        }
    } // End of inner class Panel

    // Inner class for KeyboardListener
    class KeyboardListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            // Code for moving left paddle
            if (e.getKeyCode() == KeyEvent.VK_W)
            {
                leftPanelPositionY = leftPanelPositionY - leftPanelStep;
            }
            if (e.getKeyCode() == KeyEvent.VK_S)
            {
                leftPanelPositionY = leftPanelPositionY + leftPanelStep;
            }

            // Code for moving right paddle
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                rightPanelPositionY = rightPanelPositionY - rightPanelStep;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                rightPanelPositionY = rightPanelPositionY + rightPanelStep;
            }
        }

        public void keyReleased(KeyEvent e) {} // Empty code
        public void keyTyped(KeyEvent e) {} // Empty code
    } // End of class KeyboardListener
}