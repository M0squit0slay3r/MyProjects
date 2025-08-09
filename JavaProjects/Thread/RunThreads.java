
public class RunThreads implements Runnable
{
	public static void main (String[] args) 
	{
		RunThreads runner = new RunThreads();
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner);
		Thread gamma = new Thread(runner);

		alpha.setName("Alpha thread");
		beta.setName("Beta thread");
		gamma.setName("Gamma thread");

		alpha.start();
		beta.start();
		gamma.start();
	}
	
	public void run() 
	{
		for(int i=0; i<25; i++) 
		{
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is running");
		}
	}
}
