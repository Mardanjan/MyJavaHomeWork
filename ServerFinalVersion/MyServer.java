//这是服务器主类，将收到的请求传给线程去处理

package demo.ServerFinalVersion;
import java.io.*;
import java.net.*;

public class MyServer {

	public static void main(String[] args) {
		int i=0;
		ServerSocket server_socket;
		try {
			server_socket = new ServerSocket(8888);
			while(true){
				Socket socket = server_socket.accept();
				i++;
				MyThread t = new MyThread(socket);
				t.start();
				System.out.println(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
