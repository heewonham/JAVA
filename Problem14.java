import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Fruit{
	private String name;
	private double cost;
	public Fruit(String n, double c) {
		this.name = n;
		this.cost = c;
	}
	String getName() { return name;}
	double getCost() { return cost;}
}
class FruitBox<T extends Fruit> {
	private ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); System.out.println(item.getName() + " " + item.getCost()); }
	int getNumItems() { return list.size(); }
	String getMaxItem() {
		double max = 0;
		int index = 0;
		for(int i = 0; i < list.size(); i++) {
			if(max < list.get(i).getCost()){
				max = list.get(i).getCost();
				index = i;
			}
		}
		return list.get(index).getName();
	}
	double getMaxPrice() {
		double max = 0;
		int index = 0;
		for(int i = 0; i < list.size(); i++) {
			if(max < list.get(i).getCost()){
				max = list.get(i).getCost();
				index = i;
			}
		}
		return list.get(index).getCost();
	}
	String getMinItem() {
		double min = (getNumItems()>0)?list.get(0).getCost():0;
		int index = 0;
		for(int i = 1; i < list.size(); i++) {
			if(min > list.get(i).getCost()){
				min = list.get(i).getCost();
				index = i;
			}
		}
		return list.get(index).getName();
	}
	double getMinPrice() {
		double min = (getNumItems()>0)?list.get(0).getCost():0;
		int index = 0;
		for(int i = 1; i < list.size(); i++) {
			if(min > list.get(i).getCost()){
				min = list.get(i).getCost();
				index = i;
			}
		}
		return list.get(index).getCost();
	}
	double getAvgPrice() {
		double s = 0;
		for(int i = 0; i < list.size(); i++) {
			s += list.get(i).getCost();
		}
		return (s/getNumItems());
	}
}

public class Problem14 {

	public static class ItemReader{
		public static boolean fileToBox(String f, FruitBox<Fruit> box) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(f));
			}catch (FileNotFoundException e) {
				System.out.println("Input file not found");
				return false;
			}
			while(true) {
				try {
					String line = br.readLine();
					if(line == null) break;
					String word[] = line.split(" ",2);
					double e = Double.parseDouble(word[1]);
					box.add(new Fruit(word[0], e));
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
	}
	public static void main(String[] args) {	
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if(rv == false) return;
		box.add(new Fruit("orange", 9.99));
		System.out.println("----------------");
		System.out.println(" Summary");
		System.out.println("----------------");
		System.out.println("number of items: " + box.getNumItems());
		System.out.println("most expensive item: " + box.getMaxItem() + " (" + 
		box.getMaxPrice() + ")");
		System.out.println("cheapest item: " + box.getMinItem() + " (" +
		box.getMinPrice() + ")");
		System.out.printf("average price of items: %.2f", box.getAvgPrice());
}}