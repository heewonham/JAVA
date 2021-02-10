package cse3040_22;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ex04 {

	public static void main(String[] args) {
		String url = "https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8";
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
		Elements a = authors.select("[href]");
		Elements p = prices.select("[href]");
		
		for(int i =0; i < t.size(); i++) {
			System.out.println(i+1+"À§: "+ t.eq(i).text()+
					" " + a.eq(i).text()+" "+p.eq(i).text());
		}
	}
}