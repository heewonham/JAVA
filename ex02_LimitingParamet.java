package cse3040_14;

import java.util.ArrayList;

interface Eatable {  }
class Fruit implements Eatable {public String toString() {return "Fruit";}}
class Apple extends Fruit {public String toString() {return "Apple";}}
class Grape extends Fruit {public String toString() {return "Grape";}}
class Toy { public String toString() {return "Toy";} }

class Bbox<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() {return list.toString(); }
}

class FruitBox<T extends Fruit & Eatable> extends Bbox<T> {  }
//class FruitBox<T> extends Box<T> { }

public class ex02_LimitingParamet {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		//FruitBox<Toy> toyBox = new FruitBox<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Fruit());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		//appleBox.add(new Grape());
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox"+fruitBox);
		System.out.println("appleBox"+appleBox);
		System.out.println("grapeBox"+grapeBox);
	}
}