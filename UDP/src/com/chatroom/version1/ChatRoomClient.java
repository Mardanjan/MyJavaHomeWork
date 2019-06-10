package com.chatroom.version1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatRoomClient {
	private final static int PORT = 8888; //daytime 服务器的端口
	private static final String HOSTNAME ="localhost"; //服务器的地址，localhost为当前主机的地址
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
        System.out.println("请输入你要发送的信息：");// 提示用户输入
        String line = scanner.nextLine();// 获取用户输入的一行文本
        try(DatagramSocket socket = new DatagramSocket(0)){
			socket.setSoTimeout(10000);   //响应超时时间设定  
			
			byte[] d= line.getBytes("US-ASCII");
			InetAddress host = InetAddress.getByName(HOSTNAME); //根据服务器域名获取地址  
			
			
			DatagramPacket request = new DatagramPacket(d,d.length,host,PORT); //根据请求的参数创建响应报文
		

			socket.send(request);  //发出请求
			scanner.close();
			//socket.receive(response);   //接受服务器响应的包
			//String result = new String(response.getData(),0,response.getLength(),"US-ASCII"); //获取包的数据
			//System.out.println(result);
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
