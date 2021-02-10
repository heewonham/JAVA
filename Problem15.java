import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Item{
	private String word;
	private int count;
	
	public Item(String word) {
		this.word = word;
		this.count = 1;
	}
	public String getWord() {return word;}
	public int getCount() {return count;}
	public void inputCount() {count++;}
	public String toString() {return word +" "+count; }
	public boolean equals(Object otherObj){
		if(this == otherObj) return true;
		if(otherObj == null) return false;
		if(getClass() != otherObj.getClass()) return false;
		Item other = (Item)otherObj;
		return (this.word.equals(other.getWord()));
	}
}

public class Problem15 {

	public static class MyFileReader{
		public static boolean readDataFromFile(String f, ArrayList<Item> list) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(f));
			}catch (FileNotFoundException e) {
				return false;
			}
			while(true) {
				try {
					String line = br.readLine();
					if(line == null) break;
					String word[] = line.split(" ");
					for(String a : word) Add(a,list);
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		public static void Add(String a, ArrayList<Item> list) {
			for(Item it : list) {
				if(it.getWord().equals(a.toLowerCase())) {
					it.inputCount();
					return;
				}
			}
			list.add(new Item(a.toLowerCase()));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if(rv == false) {
			System.out.println("Input file not found.");
			return;
		}
		for(Item it : list) System.out.println(it);
	}
}