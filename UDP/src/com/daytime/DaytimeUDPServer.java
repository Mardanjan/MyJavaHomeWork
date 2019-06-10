package com.daytime;

/**
 * 简单的daytime服务器
 * 与daytime客户端
 */

import java.net.*;
import java.util.*;
import java.io.*;

public class DaytimeUDPServer {

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
					byte[] d= daytime.getBytes("US-ASCII");
					
					DatagramPacket response = new DatagramPacket(d,d.length,request.getAddress(),request.getPort()); //根据请求的参数创建响应报文
					socket.send(response);//响应请求------给客户端发送准备的数据（当前时间）
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
