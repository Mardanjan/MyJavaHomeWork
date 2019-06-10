package com.chatroom.version2.gui;


import java.net.*;

import javax.swing.*;  //JFrame 组件包
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UDPClient extends Frame implements ActionListener{
	static 	JFrame f = new JFrame("基于UDP的留言客户端");

	JTextArea text_out = new JTextArea(20,20);
	JButton fasong = new JButton("发送留言");
	UDPClient(){
		//布局
		Container conPane = f.getContentPane();
		conPane.setLayout(new FlowLayout());
		
		
	
		f.add(text_out);

		fasong.addActionListener(this);
		f.add(fasong);
		f.add("West", text_out); 

		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口时停止
		f.setSize(400, 400);
		
		f.setLocation(500, 200);
		
		f.setVisible(true);
	}
	

	
	
	//事件处理方方法
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource(); //获取激发时间的对象
		String cmd = e.getActionCommand(); //获取自定义的字符串命令行
	
	
		if(fasong == e.getSource() ) {
			System.out.println(text_out.getText());
			try(DatagramSocket socket = new DatagramSocket(0)){
				socket.setSoTimeout(10000);   //响应超时时间设定  
				int PORT = 8888; //daytime 服务器的端口
				String HOSTNAME ="localhost"; //服务器的地址，localhost为当前主机的地址
				byte[] d= text_out.getText().getBytes("US-ASCII");
				InetAddress host = InetAddress.getByName(HOSTNAME); //根据服务器域名获取地址  
				DatagramPacket request = new DatagramPacket(d,d.length,host,PORT); //根据请求的参数创建响应报文
				try {
					socket.send(request);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  //发出请求
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UDPClient ob = new UDPClient();
		


	}

}
