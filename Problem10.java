class Points{
	private double[] point;
	public Points(double[] p) { this.point = p; }
	public double sum() {
		double s = 0;
		for(int i = 0; i < point.length; i++) {s += point[i];}	
		return s;
	}
	public boolean equals(Object otherO) {
		if(this == otherO) return true;
		if(otherO == null) return false;
		if(getClass() != otherO.getClass()) return false;
		Points other = (Points)otherO;
		return (this.sum() == other.sum());
	}
	public String toString(){
		if (point == null)
			return "null";
		else
			return "[sum of points: "+ sum() +"]";
	}
}

public class Problem10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Points p1 = new Points(new double[] {1.0,2.0,3.0});
		Points p2 = new Points(new double[] {4.0,5.0,6.0});
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		Points p3 = new Points(new double[] {1.0,4.0,7.0});
		Points p4 = new Points(new double[] {3.0,9.0});
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.equals(p4));
		Points p5 = new Points(new double[] {1.0,2.0});
		Points p6 = null;
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p5.equals(p6));
	}
}
