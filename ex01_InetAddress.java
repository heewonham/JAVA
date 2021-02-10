package cse3040_21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ex01_InetAddress {

	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("www.sogang.ac.kr");
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
			System.out.println("toString(): "+ip.toString());
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
