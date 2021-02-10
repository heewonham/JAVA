import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

class BookInfo implements Comparable<BookInfo>{
	private int rank;
	private String title;
	private String author;
	private String price;
	
	public int getRank() {return this.rank;}
	
	public BookInfo(int r, String t, String a, String p){
		this.rank = r;
		this.title = t;
		this.author = a;
		this.price = p;
	}
	public int compareTo(BookInfo b) {
		if(this.rank > b.getRank()) return -1;
		if(this.rank < b.getRank()) return 1;
		return 0;
	}
	public String toString() {
		return "#" + this.rank + " " + this.title + ": " + this.author + ", " + this.price;
	}
}
class BookReader{
	private static ArrayList<BookInfo> book = new ArrayList<BookInfo>();
	private static ArrayList<String> lines = new ArrayList<String>();
	public static ArrayList<BookInfo> readBooks(String f){
		URL url = null;
		BufferedReader input = null;
		String addr = f;
		String line = "";
		
		int rank = 1;
		String author = "";
		String title = "";
		int status = 0;
		
		try {
			url = new URL(addr);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while((line=input.readLine()) != null) {
				if(line.trim().length() > 0) lines.add(line);
				if(status == 0) {
					if(line.contains("<div class=\"col-lg-9 product-info-listView\">")) status = 1;
				} else if(status == 1) {
					if(line.contains("<div class=\"product-shelf-title pr-m\"")) status = 2;
				}else if (status == 2) {
					if(line.contains("href")) {
						int begin = line.indexOf("\">") + "\">".length();
						int end = line.indexOf("</a>");
						title += line.substring(begin,end);
						status = 3;
					}	
				} else if(status == 3) {
					if(line.contains("<div class=\"product-shelf-author contributors\">") && line.contains("href")) {
						String[] temp = line.split("<");
						for(int i = 0;i < temp.length; i++) {
							if(temp[i].contains("href")){
								int begin = temp[i].indexOf(">")+1;
								author += temp[i].substring(begin);
								break;
							}
						}
					status = 4;
					}
				} else if (status == 4) {
					if(line.contains("<span class=\"current\">")) status = 5;	
				} else if (status == 5) {
					if(line.contains("href")) {
						int begin = line.indexOf("\">")+ "\">".length();
						int end = line.indexOf("</a>");
						book.add(new BookInfo(rank,title,author,line.substring(begin,end)));
						status = 0;
						author = title = "";							
						rank++;
					}
				}
			}
			input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
}
public class Problem19 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooks("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for(int i=0; i<books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}