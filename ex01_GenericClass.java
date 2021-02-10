package cse3040_14;

class A {public String toString() {return "Class A Object";}}
class B {public String toString() {return "Class B Object";}}
class C {public String toString() {return "Class C Object";}}

class Box<T>{
	T item;
	// constructor 만들기
	public Box(T item) {
		this.item = item;
		// T t= new T(); type T instance를 만들 수 없다.
		//T t[] = new T[10]; 불가.
	}
	void setItem(T item) { this.item = item; }
	public T getItem() {return item;}
}

public class ex01_GenericClass {
	public static void main(String[] args) {
		Box<A> boxa = new Box<>(new A());
		//boxa.setItem(new A());
		Box<B> boxb = new Box<B>(new B());
		//boxb.setItem(new B());
		Box<C> boxc = new Box<C>(new C());
		//boxc.setItem(new C());
		System.out.println(boxa.getItem());
		System.out.println(boxb.getItem());
		System.out.println(boxc.getItem());
	}
}