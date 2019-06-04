package client.FinalVersion;

import java.io.*;
import java.net.*;



public class Client {

	/**
	 *  输入流里写请求内容
	 *  服务器给请求的输出流写进响应内容
	 *  客户端输出相应的内容
	 * @param args
	 */
	
	/**
	 * 参数：请求类型，请求内容
	 */
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			//t.sentRequest("GET", "localhost", 8888, "tupian");
			for(int i=0 ;i<5000 ;i++) {
				MyThread t = new MyThread("GET", "localhost", 8888, "tupian");
				t.start();
		
			}
		
}
}