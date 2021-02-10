class Shape{
	private double area;
	public Shape(double a) {
		area = a;
	}
	public double show() {
		return this.area;
	}
}

class Circle extends Shape{
	public Circle(double r) {
		super((r*r) * Math.PI);
	}
}
class Square extends Shape{
	public Square(double a) {
		super(a*a);
	}
}
class Rectangle extends Shape{
	public Rectangle(double a, double b) {
		super(a*b);
	}
}

public class Problem08 {

	public static double sumArea(Shape[] a) {
		double sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i].show();
		}
		return sum;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] arr = {new Circle(5.0), new Square(4.0),
				new Rectangle (3.0,4.0), new Square(5.0)};
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}
}