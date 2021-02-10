import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Server {
	
	private int port;
	private String sr = "books.txt";
	private TreeMap<String, String> books = new TreeMap<String,String>();
	
	Server(String port){
		this.port = Integer.parseInt(port);
		try { // 파일 새로 만들기
			FileWriter fw = new FileWriter(sr,true);
		}catch (IOException e) {}

		BufferedReader br = null;	
		try { // text->map lower 저장
			br = new BufferedReader(new FileReader(sr));
		}catch (FileNotFoundException e) {}
		
		try {
			while(true){
				String line = br.readLine();
				if(line == null) break;
				String[] temp = line.split("\t");
				books.put(temp[0].toLowerCase(), temp[1].toLowerCase());
			}
			br.close();
		}catch(IOException e) {	e.printStackTrace();}
	}
	
	private void writeFile(String txt) {
		try {
			FileWriter fw = new FileWriter(sr);
			fw.write(txt);
			fw.close();
		}catch(IOException e) { }
	}
	
	private void readFile(String request, String t, String a, String id, DataOutputStream out) {		
		int chk;
		int count;
		BufferedReader br = null;	
		try {
			br = new BufferedReader(new FileReader(sr));
		}catch (FileNotFoundException e) {}
		
		if(request.equals("add")) {
			int order;
			if(books.containsKey(t.toLowerCase()))
				chk = 1;
			else{
				chk = 0;
				books.put(t.toLowerCase(), a); }			
			try {
				if(chk == 0) {
					String text = "";
					// 순서 찾기
					Set<Map.Entry<String,String>> set = books.entrySet();
					Iterator<Map.Entry<String,String>> it = set.iterator();
					order = 0;
					while(it.hasNext()) {
						if((it.next().getKey()).equals(t.toLowerCase())) break;
						else order++;
					}
					count = 0;
					while(true) {
						if(count == order)
							text += t+"\t"+a+"\t-\r\n";
						String line = br.readLine();
						if(line == null) break;
						text += line+"\r\n";
						count++;
					} 
				writeFile(text);
				out.writeUTF("A new book added to the list.\n");
				} else {
					out.writeUTF("The book already exists in the list.\n");
				}
			} catch(IOException e) { e.printStackTrace();}
		}else if(request.equals("borrow")) {
			chk = 0;
			String text = "";
			String title = "";
			try {
				while(true){
					String line = br.readLine();
					if(line == null) break;
					String[] temp = line.split("\t");
					if((temp[0].toLowerCase()).equals(t.toLowerCase())&&
							temp[2].equals("-")) {
						chk = 1;  title = temp[0];
						text += temp[0]+'\t'+temp[1]+'\t'+id+"\n";
					} else
						text += line+"\r\n";
				}
				if(chk == 1) {
					writeFile(text);
					out.writeUTF("You borrowed a book. - "+title+"\n");
				}else {
					out.writeUTF("The book is not available.\n");
				}
			} catch(IOException e) { e.printStackTrace();}
		}else if(request.equals("return")) {
			chk = 0;
			String text = "";
			String title = "";
			try {
				while(true){
					String line = br.readLine();
					if(line == null) break;
					String[] temp = line.split("\t");
					if((temp[0].toLowerCase()).equals(t.toLowerCase())&&
							temp[2].equals(id)) {
						chk = 1; title = temp[0];
						text += temp[0]+'\t'+temp[1]+'\t'+"-\n";
					} else
						text += line+"\r\n";
				}
				if(chk == 1) {
					writeFile(text);
					out.writeUTF("You returned a book. - "+title+"\n");
				}else {
					out.writeUTF("You did not borrow the book.\n");
				}
			} catch(IOException e) { e.printStackTrace();}
		} else if(request.equals("info")) {
			String inf = "";
			count = 0;
			try {
				while(true){
					String line = br.readLine();
					if(line == null) break;
					String[] temp = line.split("\t");
					if(temp[2].equals(id)) {
						count ++;
						inf += (count+". "+temp[0]+", "+temp[1]+"\n");
					}
				}
				out.writeUTF("You are currently borrowing "+count+" books:\n");
				if(count != 0) out.writeUTF(inf);
			} catch(IOException e) { e.printStackTrace();}
		} else if(request.equals("search")) {
			String srh = "";
			count = 0;
			try {
				while(true){
					String line = br.readLine();
					if(line == null) break;
					String[] temp = line.split("\t");
					if((temp[0].toLowerCase()).contains(a.toLowerCase())||
							(temp[1].toLowerCase()).contains(a.toLowerCase())) {
						count ++;
						srh += count+". "+temp[0]+", "+temp[1]+"\n";
					}
				}
				out.writeUTF("Your search matched "+count+" results.\n");
				if(count != 0)	out.writeUTF(srh);
			} catch(IOException e) { e.printStackTrace();}
		}
		try {
			br.close();
		}catch(IOException e) {	e.printStackTrace();}
	}		
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				socket = serverSocket.accept();
				ServerReceiver thread1 = new ServerReceiver(socket);
				thread1.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Please give the port number as an argument.");
			System.exit(0);
		}
		new Server(args[0]).start();
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
			String id = "";
			String request = "";
			String title = "";
			String author = "";
			try {
				if(in != null) {
					id = in.readUTF();
				}
				while(in != null) {
					title = "";
					author = "";
					request = in.readUTF();
					if(request.equals("error")) {}		
					else if(request.equals("add")) {
						title = in.readUTF();
						author = in.readUTF();
						readFile(request,title,author,id,out);
					} else if(request.equals("borrow")){
						title = in.readUTF();
						readFile(request,title,author,id,out);
					}else if(request.equals("return")){
						title = in.readUTF();
						readFile(request,title,author,id,out);
					}else if(request.equals("info")){
						readFile(request,title,author,id,out);
					}else if(request.equals("search")){
						String search = in.readUTF();
						readFile(request,title,search,id,out);
					}else {
						out.writeUTF("[available commands]\nadd: add a new book to the list of books.\n"
								+ "borrow: borrow a book from the library.\nreturn: return a book to the library.\n"
								+ "info: show list of books I am currently borrowing.\nsearch: search for books.\n");
					}
					out.writeUTF(id+">> ");
				}
			}catch(IOException e) { 	
			}finally { // exception이 실행하건 아니건 마지막으로 수행
				System.out.println("["+socket.getInetAddress()+":"+
				socket.getPort() + "] has disconnected.");
			}
		}
	}
}