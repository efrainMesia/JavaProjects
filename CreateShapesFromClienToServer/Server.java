package A2021_m78_question2;

import java.io.IOException;
import java.net.*;

public class Server extends Thread{
	private ServerController cont;
	public Server(ServerController cont) {
		this.cont = cont;
	}
	
	public void run() {
		ServerSocket sc = null;
		Socket s= null;
		try {
			System.out.println("In Server...");
			sc = new ServerSocket(8888);
			System.out.println("Listening on port 8888");
			while(true) {
				s = sc.accept();
				new ServerThread(s,this.cont).start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			s.close();
		}catch (IOException e) {}
	}
}
