import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class MapManager{
	private static Map<String,Double> map = new TreeMap<String,Double>(){
		public String toString() {
			String print = new String();
			Set<Map.Entry<String,Double>> set = map.entrySet();
			Iterator<Map.Entry<String,Double>> it = set.iterator();
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

public class Problem17 {
	public static void main(String[] args) {
		Map<String, Double> map = MapManager.readData("input.txt");	
		if(map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}