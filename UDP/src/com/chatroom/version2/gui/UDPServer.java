package com.chatroom.version2.gui;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;




/**
 * 大概思路：
 * 1·这是要多线程：UDP服务器收到信息调给线程去处理
 * 2·线程解析数据刷新图形界面的内容
 * @author 买尔旦江
 *
 */
public class UDPServer {
	private final static int PORT = 8888;
    public static String sum="";
    public static int count_message = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gui g = new Gui();
		g.runGui();
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			while(true) {
				DatagramPacket request = new DatagramPacket(new byte[1024] , 1024);
				try {
					
					socket.receive(request);  //监听并接受一个DatagramSocket
				
					String message = new String(request.getData(),0,request.getLength(),"US-ASCII");
				
					String time = new Date().toString();
				
					count_message ++;
					
					sum+="序号:"+ count_message +"____留言时间____：" +time + "____内容____："+ message +"\r\n";
							
					
					g.op(sum);
					System.out.println(sum);
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
