package com.chatroom.version2.gui;

import java.net.*;
import java.util.Date;

import javax.swing.*;  //JFrame 组件包


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Frame {
	static 	JFrame f = new JFrame("基于UDP的留言板");
	JTextArea text_out = new JTextArea(60,60);
	public String time = new Date().toString();
	public int sum  = 0;

	private String  data ;
	Gui(){
		//布局
	
	}
	Gui(String data){
		this.data=data;
		
	}
	public void runGui() {
		Container conPane = f.getContentPane();
		conPane.setLayout(new FlowLayout());
		f.add(text_out);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口时停止
		f.setSize(800, 800);
		f.setLocation(500, 200);
		f.setVisible(true);
	}
	public void op(String temp) {
		text_out.setText(temp);
		
	
	}


	


}

