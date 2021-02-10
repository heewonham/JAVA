package cse3040_23;

import javax.swing.JOptionPane;

public class ex05 {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter any String");
		System.out.println("You have entered "+input);
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch (Exception e) {e.printStackTrace();}
		}
	}
}