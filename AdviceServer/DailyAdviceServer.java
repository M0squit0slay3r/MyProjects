
import java.io.*;
import java.net.*;

public class DailyAdviceServer 
{

    private final String[] adviceList = 
    	{ 
        "Take smaller bites", 
        "Go for the tight jeans. No they do NOT make you look fat.", 
        "One word: inappropriate", 
        "Just for today, be honest. Tell your boss what you really think", 
        "You might want to rethink that haircut.",
        
        "Step away from the screen and take a walk.",
        "Don't be afraid to say no, but choose your battles.",
        "Treat yourself to dessert, you deserve it.",
        "Laugh at your mistakes, everyone else does.",
        "Call your mom, she misses you."
        };

    public void go() 
    {
        try 
        {
            ServerSocket serverSock = new ServerSocket(8080);

            while (true) 
            {
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                
                for (int i = 0; i < 3; i++) {
                    String advice = getAdvice();
                    writer.println(advice);
                    System.out.println("Sent advice: " + advice);
                }
                writer.close();
                sock.close();

            }
        } 
        
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    private String getAdvice() 
    {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) 
    {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
