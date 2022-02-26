

 import java.io.*;
import java.net.*;

import javafx.scene.shape.Rectangle;

public class ServerThread extends Thread{
	
	private Socket s;
	private ServerController cont;
	public ServerThread(Socket socket,ServerController cont) {
		this.s = socket;
		this.cont = cont;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleReadAndWrite() throws Exception{
		InputStream inputStream = s.getInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		System.out.println("got here");
		this.cont.drawRect((Rect)objectInputStream.readObject());
		objectInputStream.close();
		inputStream.close();
		s.close();
		
	}
	
}
