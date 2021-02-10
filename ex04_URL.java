package cse3040_21;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ex04_URL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://mickeymouse@www.google.com");
			
			System.out.println("authority: "+ url.getAuthority());
			System.out.println("content: "+ url.getContent());
			System.out.println("default port: "+ url.getDefaultPort());
			System.out.println("port: "+ url.getPort());
			System.out.println("file: "+ url.getFile());
			System.out.println("Host: "+ url.getHost());
			System.out.println("path: "+ url.getPath());
			System.out.println("protocol: "+ url.getProtocol());
			System.out.println("query: "+ url.getQuery()); //?
			System.out.println("ref: "+ url.getRef()); //#
			System.out.println("userinfo: "+ url.getUserInfo()); //@
			System.out.println("external form: "+ url.toExternalForm());
			System.out.println("uri: "+ url.toURI());
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
