class Point{
	private double[] point;
	
	public Point(double[] p) {
		this.point = p;
	}
	public double[] getPoint() {
		return this.point;
	}
}
class EuclideanDistance{
	static double getDist(Point p1, Point p2) {
		if(p1.getPoint().length == p2.getPoint().length) {
			double sum = 0;
			for(int i=0;i<p1.getPoint().length;i++)
				sum+= Math.pow(p1.getPoint()[i]-p2.getPoint()[i],2);
			return Math.sqrt(sum);
		}
		else
			return -1.0;
	}
}
class ManhattanDistance{
	static double getDist(Point p1, Point p2) {
		if(p1.getPoint().length == p2.getPoint().length) {
			double sum = 0;
			for(int i=0;i<p1.getPoint().length;i++)
				sum += Math.abs(p1.getPoint()[i]-p2.getPoint()[i]);
			return sum;
		}
		else
			return -1.0;
	}
}
public class Problem09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(new double[] {1.0,2.0,3.0});
		Point p2 = new Point(new double[] {4.0,5.0,6.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] {1.0,2.0,3.0});
		Point p4 = new Point(new double[] {4.0,5.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}