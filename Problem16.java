import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Element implements Comparable<Element>{
	private String fruit;
	private double price;
	
	public Element(String fruit, double price) {
		this.fruit = fruit;
		this.price = price;
	}
	public String getName() {return this.fruit;}
	public double getPrice() {return this.price;}
	
	public int compareTo(Element e) {
		if(this.price < e.getPrice()) return -1;
		if(this.price > e.getPrice()) return 1;
		return this.fruit.compareTo(e.getName());
	}
	
	public String toString() {return this.fruit + " " + this.price;}
}
class ElementReader{
	public static ArrayList<Element> readElements(String f) {
		ArrayList<Element> l = new ArrayList<Element>();
		BufferedReader br = null;
		//StringBuffer input = new StringBuffer();
		String line = "";
		String oldtext = "";
		
		try {
			br = new BufferedReader(new FileReader(f));
		}catch (FileNotFoundException e) {
			return null;
		}
		try {
			while((line = br.readLine()) != null) {
				oldtext += line+"\r\n";
			}
			br.close();
			String newtext = oldtext.replaceAll("apple", "lemon");
			FileWriter writer = new FileWriter(f);
			writer.write(newtext);
			writer.close();
		} catch(IOException e) { }
		/*while(true) {
			try {
				br.
				String line = br.readLine();
				if(line == null) break;
				String[] a = line.split(" ");
				if(a[0] == "apple")
					{br..readLine().replaceAll("apple", "aaaa");
					br.}
				//l.add(new Element(a[0],Double.parseDouble(a[1])));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		return l;
	}
}
public class Problem16 {

	public static void main(String[] args) {
		ArrayList<Element> list = ElementReader.readElements("input.txt");
		if(list == null) {
			System.out.println("Input file not found.");
			return;
		}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while(it.hasNext()) System.out.println(it.next());
	}
}