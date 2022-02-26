

import java.io.*;
import java.net.Socket;

import javafx.scene.shape.Rectangle;

public class ClientThread extends Thread{
	private String ip;
	private Rect r;
	public ClientThread(String ip,Rect r) {
		this.ip = ip;
		this.r = r;
	}
	
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void handleReadAndWrite() throws Exception{
		Socket s = new Socket(ip,8888);
		
		OutputStream outputStream = s.getOutputStream();
		ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
		
		objOutputStream.writeObject(this.r);
		outputStream.close();
		objOutputStream.close();
		s.close();
		
	}
}
