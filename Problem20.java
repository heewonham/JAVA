import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
	public static ArrayList<BookInfo> readBooksJsoup(String f){
		String url = f;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		Elements bestsellers = doc.select("div[class=col-lg-9 product-info-listView]");
		Elements titles = bestsellers.select("div[class=product-shelf-title pr-m]");
		Elements authors = bestsellers.select("div[class=product-shelf-author contributors]");
		Elements prices = bestsellers.select("span[class=current]");
		Elements t = titles.select("[href]");
		Elements a = new Elements();
		for(int i =0; i< authors.size(); i++) {
			Elements tmp = authors.eq(i).select("[href]");
			a.addAll(tmp.eq(0));
		}
		Elements p = prices.select("[href]");
		for(int i =0; i < a.size(); i++) {
			book.add(new BookInfo(i+1, t.eq(i).text(),a.eq(i).text(),p.eq(i).text()));
		}
		return book;
	}
}
public class Problem20 {
	public static void main(String[] args) {
	
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		
		for(int i=0; i<books.size(); i++) {
			BookInfo book = books.get(i);System.out.println(book);
		}
	}
}