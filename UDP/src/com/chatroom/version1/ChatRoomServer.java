package com.chatroom.version1;

/**
 * 基于UDP的聊天室服务器
 * 与搭配的客户端一起使用
 * ------------------
 * 服务器端大概思路：
 * 1·接受客户端发来的数据，解析数据包获取IP+内容+接受时间时间（服务器端自己获取）
 * 2·这样显示在客户端
 * IP：XXX的用户：-----聊天内容-----  发送时间：xxx
 * 客户端先不管
 */

import java.net.*;
import java.util.*;
import java.io.*;
public class ChatRoomServer {
	private final static int PORT = 8888;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date data = new Date();
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			while(true) {
				DatagramPacket request = new DatagramPacket(new byte[1024] , 1024);
				try {
					
					socket.receive(request);  //监听并接受一个DatagramSocket
					
					String daytime = data.toString();  //准备给客户端发送的信息  
					//byte[] d= daytime.getBytes("US-ASCII");
					
					//String result = new String(response.getData(),0,response.getLength(),"US-ASCII"); //获取包的数据
					String message = new String(request.getData(),0,request.getLength(),"US-ASCII");
					String IP = request.getAddress().getHostAddress().toString();
					//socket.send(response);//响应请求------给客户端发送准备的数据（当前时间）
					System.out.println("IP:"+IP+"的用户说:"+message);
					System.out.println("收到消息的时间为："+daytime);
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
