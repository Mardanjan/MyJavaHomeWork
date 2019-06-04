package client.FinalVersion;
import java.net.*;

import java.io.*;
public class MyThread extends Thread {
	
	private String type;
	private String address ;
	private int port;
	private String qingqiu ;
	
	MyThread(String type , String address , int port , String qingqiu){
		this.type = type; 
		this.address = address;
		this.port = port;
		this.qingqiu = qingqiu;
	}
	
	@Override
	public void run() {
			
			Socket socket= new Socket();
			InetSocketAddress address1 = new InetSocketAddress(address,port);
			PrintWriter fileWriter;
			try {
				socket.connect(address1, 1000); 
				String request= type+" /"+ qingqiu + " HTTP/1.1\r\nHost:"+address+"\r\n\r\n";   //发送的请求
					
				PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);    //请求写入到输出流
				writer.println(request);
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream(),"utf-8"));
				if(qingqiu.equals("")) {
					 fileWriter = new PrintWriter(new FileOutputStream("index.html"),true);	
				}else {
					 fileWriter = new PrintWriter(new FileOutputStream(qingqiu+".html"),true);
				}
				
				String line;
				boolean isEmptyLine=false;
			
				while( (line= reader.readLine()) != null ) {
					System.out.println(line);
					if(isEmptyLine) {
						fileWriter.println(line);
					}
					if("".equals(line)) {
						isEmptyLine=true;
					}
				}
				fileWriter.close();
				reader.close();
				writer.close(); 
				writer.flush();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	


