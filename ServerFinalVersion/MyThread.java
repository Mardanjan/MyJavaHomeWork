package demo.ServerFinalVersion;
import java.net.*;

import java.io.*;
public class MyThread extends Thread {
	private Socket socket;
	
	MyThread(Socket s){
		this.socket=s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	BufferedReader br = null;
	BufferedReader reader ;
		try {
			
			//br是请求的输入流     就是客户端给请求体输出的
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//receive http request
		String r;  //request header
		int l = 0;  //content lenght
		 PrintWriter pw = null;
		try {
			pw = new PrintWriter(socket.getOutputStream());   //获得请求的输出流，这个输出流会把数据带回客户端
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = null;
		try {
		   boolean is_request = false;
			while((r=br.readLine())!=null  && !r.isEmpty()) {
				if(is_request == false) {
					 request = r ;
					 is_request=true;
				}
				
				if(is_request==true) {
					System.out.println("请求内容:"+request);
					
				}
				//get请求处理
				if(request.equals("GET / HTTP/1.1")) {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
		            pw.println("<h1>it is a get reques!</h1>");
		            pw.flush();
		            pw.close();
				}
				if(request.equals("GET /tupian HTTP/1.1")) {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
					File file = new File("baihuzi.html");	
					reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) != null) {
						//System.out.println(line);
						pw.println(line);
					}
					
		            pw.flush();
		            pw.close();
		            pw.flush();
		            pw.close();
				}
				if(request.equals("GET /index HTTP/1.1")) {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
					pw.println("<h1>this is index page </h1>");
					
		            pw.flush();
		            pw.close();
		            pw.flush();
		            pw.close();
				}
				
				//post请求处理
				if(request.equals("POST / HTTP/1.1")) {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
		            pw.println("<h1>it is a post reques!</h1>");
		            pw.flush();
		            pw.close();
				}
				//head请求处理
				if(request.equals("HEAD / HTTP/1.1")) {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
		            pw.println("<h1>it is a head reques!</h1>");
		            pw.flush();
		            pw.close();
				}
				else if(request.equals("GET /baihuzi.jpg HTTP/1.1")) {
					File file = new File("白胡子.jpg");	
					 reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) != null) {
						pw.println(line);
					}
					
		            pw.flush();
		            pw.close();
				}
				//其它请求，一律显示正在开发中
				else {
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-type:text/html\r\n\r\n");
		            pw.println("<h1>404! not find ! This function is under development\r\n" + 
		            		"\r\n" + 
		            		"</h1>");
		            pw.flush();
		            pw.close();
				}

			}} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	}


