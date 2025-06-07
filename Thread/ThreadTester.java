
public class ThreadTester 
{
	public static void main (String[] args)
	{
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		myThread.start();
		try 
		{
			Thread.sleep(2);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("back in main");
	}
}

class MyRunnable implements Runnable 
{
	public void run() 
	{
		go();
	}
	
	public void go() 
	{
		/* try 
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		} */
		doMore();
	}
	
	public void doMore()
	{
		System.out.println("Top of the stack");
	}
}
