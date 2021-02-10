package cse3040_20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EX_03_HashMap {

	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>(); 
	
	public static void main(String[] args) {
		addPhoneNo("friend", "Lee Java", "010-111-1111");
		addPhoneNo("friend", "Kim Java", "010-222-2222");
		addPhoneNo("friend", "Kim Java", "010-333-3333");
		addPhoneNo("work", "Kim Daeri", "010-444-4444");
		addPhoneNo("work", "Kim Daeri", "010-555-5555");
		addPhoneNo("work", "Park Daeri", "010-666-6666");
		addPhoneNo("work", "Lee Guajang", "010-777-7777");
		addPhoneNo("laundary", "010-888-8888");
		printList();
	}
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap<String,String> group = phoneBook.get(groupName);
		group.put(tel, name); // use phone number as key because names can have duplicates.
	}
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("other",name,tel);
	}
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap<String,String>());
	}
	static void printList() {
		Set<Map.Entry<String,HashMap<String,String>>> set = phoneBook.entrySet();
		Iterator<Map.Entry<String,HashMap<String,String>>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String,HashMap<String,String>> e = (Map.Entry<String,HashMap<String,String>>)it.next();
			Set<Map.Entry<String,String>> subset = e.getValue().entrySet();
			Iterator<Map.Entry<String,String>> subIt = subset.iterator();
			System.out.println(" * "+e.getKey()+"["+subset.size()+"]");
			while(subIt.hasNext()) {
				Map.Entry<String,String> subE = (Map.Entry<String,String>)subIt.next();
				String telNo = subE.getKey();
				String name = subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
}
