import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static class ClientReceiver extends Thread{
		Socket socket;
		private DataInputStream in;
		ClientReceiver(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			}catch(IOException e) { }
		}
		public void run() {
			while(in != null) {
				try {
					System.out.print(in.readUTF());
				} catch(Exception e) { }
	} } }
	
	static class ClientSender extends Thread{
		Socket socket;
		private Scanner scan = new Scanner(System.in);
		private DataOutputStream out;
		private DataInputStream in;
		private String id;
		
		ClientSender(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			}catch(IOException e) {	}
		}
		public void run() {
			String title = "";
			String author = "";
			try {
				if(out != null) {
					System.out.print("Enter userID>> ");
					String id = "";
					while(true){
						id = scan.nextLine();
						if(id.split(" ").length > 1) {
							System.out.print("UserID must be a single word with lowercase alphabets and numbers.\n");
						}
						else {
							int i;
							int chk = 0;
							for(i = 0; i < id.length(); i++) {
								if(!(id.charAt(i) > 47 && id.charAt(i)< 58) &&
										!(id.charAt(i) > 96 && id.charAt(i) < 123))
								{ chk = 1; break; }
							}
							if(chk == 0) {
								System.out.print("Hello "+ id+"!\n"+id+">> ");
								out.writeUTF(id);
								break;
							}else
								System.out.print("UserID must be a single word with lowercase alphabets and numbers.\n");
						}
						System.out.print("Enter userID>> ");
					}
				}
				while(out != null) { // request
					String request = scan.nextLine();
					if(request.equals("add")) {
						System.out.print("add-title> ");
						title = scan.nextLine();
						if(title.length() != 0) {
							System.out.print("add-author> ");
							author = scan.nextLine();
							if(author.length() != 0) {
								out.writeUTF(request);
								out.writeUTF(title);
								out.writeUTF(author);
							}else 
								out.writeUTF("error");
						}else
							out.writeUTF("error");
					} else if(request.equals("borrow")){
						System.out.print("borrow-title> ");
						title = scan.nextLine();
						if(title.length() != 0) {
							out.writeUTF(request);
							out.writeUTF(title);
						}else 
							out.writeUTF("error");
					} else if(request.equals("return")){
						System.out.print("return-title> ");
						title = scan.nextLine();
						if(title.length() != 0) {
							out.writeUTF(request);
							out.writeUTF(title);
						}else 
							out.writeUTF("error");
					} else if(request.equals("info")){
						out.writeUTF(request);
					}else if(request.equals("search")){
						while(true) {
							System.out.print("Search-string> ");
							String search = scan.nextLine();
							if(search.length() > 2) {
								out.writeUTF(request);
								out.writeUTF(search);
								break;
							}else if(search.length() == 0) {
								out.writeUTF("error");
								break;
							}else System.out.print("Search string must be longer than 2 characters.\n");
						}
					}
					else
						out.writeUTF(request);
				}
			}catch(Exception e) {}
			scan.close();
		}
	}
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Please give the IP address and port number as arguments.");
			System.exit(0);
		}
		try {
			String serverIp = args[0];
			int serverPort = Integer.parseInt(args[1]);
			Socket socket = new Socket(serverIp,serverPort); 
			Thread receiver = new Thread(new ClientReceiver(socket));
			Thread sender = new Thread(new ClientSender(socket));
			receiver.start();
			sender.start();
		}catch (Exception e) {
			System.out.print("Connection establishment failed.");
		}
	}
}
