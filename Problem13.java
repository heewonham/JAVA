import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Text{
	private String str;
	public Text() {
		str = new String();
	}
	boolean readTextFromFile(String f){
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
				str += line;
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
	int countChar(char a) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.toLowerCase().charAt(i) == a)
				count++;
		}
		return count;
	}
}
public class Problem13 {
	
	public static void main(String[] args) {
		Text t = new Text();
		if(t.readTextFromFile("input_prob13.txt")) {
			for(char c = 'a'; c <= 'z'; c++) {
				System.out.println(c+ ": "+ t.countChar(c));
			}
		}
	}
}