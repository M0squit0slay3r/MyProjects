
import java.io.*;
import java.net.*;
import java.util.*;

public class SehrEinfacherChatServer2 {
	
	ArrayList<PrintWriter> clientAusgabeStroeme;
	
	
	public static void main (String[] args) {
		new SehrEinfacherChatServer2().los();
	}
	
	public class ClientHandler implements Runnable {
		
		BufferedReader reader;
		
		Socket sock;
		
		
		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream(), "UTF-8");
				reader = new BufferedReader(isReader);
				
			} catch(Exception ex) {ex.printStackTrace();}
		} // Konstruktor schliessen
		
		public void run() {
			String nachricht;
			
			try {
				
				while ((nachricht = reader.readLine()) != null) {
					
					System.out.println("gelesen: " + nachricht);
					esAllenWeitersagen(nachricht,"");//clientSocket.getInetAddress()
					
				} // Ende der while-Schleife
			} catch(Exception ex) {ex.printStackTrace();}
		} // run schliessen
	} // innere Klasse schliessen
	
	
	public void los() {
		clientAusgabeStroeme = new ArrayList<PrintWriter>();
		
		try {
			ServerSocket serverSock = new ServerSocket(50100);
			System.out.println("Server started on port: "+serverSock.getInetAddress()+":"+serverSock.getLocalPort());
			
			while(true) {
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));         
				clientAusgabeStroeme.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				
				
				System.out.println("habe eine Verbindung mit "+clientSocket.getInetAddress());
			}
			// wenn wir hier angelangt sind, haben wir eine Verbindung
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void esAllenWeitersagen(String nachricht, String absender) {
		Iterator it = clientAusgabeStroeme.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(nachricht);
				writer.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} // Ende der while-Schleife

//		Statt einen Iterator und eine while-Schleife zu benutzen,
//		koennten Sie in Java 5 auch wie folgt vorgehen (da wir aus der 
//		ArrayList clientAusgabeStroeme hier eine parametrisierte 
//		ArrayList<PrintWriter> clientAusgabeStroeme gemacht haben):
//		
//		for(PrintWriter writer:clientAusgabeStroeme) {
//			try {
//				writer.println(nachricht);
//				writer.flush();
//			} catch(Exception ex) {
//				ex.printStackTrace();
//			}		
//		} // Ende der for-Schleife
//				
		
	} // esAllenWeitersagen schliessen
	
	
}
