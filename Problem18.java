import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MapManager{
	private static Map<String,Double> map = new HashMap<String,Double>(){		
		public String toString() {
			List<Entry<String, Double>> entries = new ArrayList<Entry<String,Double>>(map.entrySet());
			Collections.sort(entries, new Comparator<Entry<String, Double>>(){
				public int compare(Entry<String, Double> o1, Entry<String,Double> o2) {
					if(o1.getValue() > o2.getValue()) return 1;
					if(o1.getValue() < o2.getValue()) return -1;
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			
			String print = new String();
			Iterator<Map.Entry<String,Double>> it = entries.iterator();
			while(it.hasNext()) {
				Map.Entry<String,Double> e = it.next();
				print += e.getKey()+ " " + e.getValue() + "\n";
			}
			return print.trim();
		}
	};
	public static Map<String, Double> readData(String f){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		}catch (FileNotFoundException e) {
			return null;
		}
		while(true) {
			try {
				String line = br.readLine();
				if(line == null) break;
				String[] a = line.split(" ");
				map.put(a[0], Double.parseDouble(a[1]));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
public class Problem18 {
	public static void main(String[] args) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if(map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}