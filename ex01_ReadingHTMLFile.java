package cse3040_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ex01 {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address ="https://www.google.com";
				//"https://icslsogang.github.io/courses/cse3040/hello.html";
		String line = "";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
