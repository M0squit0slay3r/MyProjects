
import java.io.*;
import java.net.*;

public class DailyAdviceClient 
{

    public void go() 
    {
        try 
        {
            Socket s = new Socket("127.0.0.1", 8080);

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
           
            for (int i = 0; i < 3; i++) {
                String advice = reader.readLine();
                if (advice != null) {
                    System.out.println("Advice " + (i + 1) + ": " + advice);
                } else {
                    System.out.println("No more advice available.");
                    break;
                }
            }

            reader.close();
            s.close();
           
        } 
        
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
