package cse3040_25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MultiChatServer {
	
	HashMap<String, DataOutputStream> clients;
	MultiChatServer(){
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("server has started.");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("a new connection from ["+socket.getInetAddress() + ":"
						+ socket.getPort());
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			}catch(IOException e) { }
		}
	}

	public static void main(String[] args) {
		new MultiChatServer().start();
	}
	
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			}catch(IOException e) {}
		}
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#"+name+" has joined.");
				clients.put(name, out);
				System.out.println("current number of users: "+ clients.size());
				while(in!=null) {
					sendToAll(in.readUTF());
				}
			}catch(IOException e) {
				
			}finally { // exception이 실행하건 아니건 마지막으로 수행
				sendToAll("#"+name+" has left.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+
				socket.getPort() + "] has disconnected.");
				System.out.println("current number of users: "+ clients.size());
			}
		}
	}
}
