package com.daytime;

/**
 * 简单的daytime客户端
 * 与daytime服务器搭配使用
 */
import java.io.*;
import java.net.*;
public class DaytimeUDPClient {
 
	private final static int PORT = 8888; //daytime 服务器的端口
	private static final String HOSTNAME ="localhost"; //服务器的地址，localhost为当前主机的地址
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(DatagramSocket socket = new DatagramSocket(0)){
			socket.setSoTimeout(10000);   //响应超时时间设定  
			InetAddress host = InetAddress.getByName(HOSTNAME); //根据服务器域名获取地址  
			
			DatagramPacket request = new DatagramPacket(new byte[1] ,1,host ,PORT); //准备请求
			DatagramPacket response = new DatagramPacket(new byte[1024] ,1024);   //准备接受的响应
			socket.send(request);  //发出请求
			socket.receive(response);   //接受服务器响应的包
			String result = new String(response.getData(),0,response.getLength(),"US-ASCII"); //获取包的数据
			System.out.println(result);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
