package ex2.geo;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{

	public Point_2D p1,p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		////// add your code here //////
		p1=new Point_2D(a);
		p2=new Point_2D(b);
		////////////////////////////////
	}
	public Segment_2D(Segment_2D t1) {
		////// add your code here //////
		Point_2D p1 = new Point_2D(t1.get_p1());
		Point_2D p2 = new Point_2D(t1.get_p2());
		////////////////////////////////
	}

	public Point_2D get_p1() {
		////// add your code here //////
		return p1;

		////////////////////////////////
	}
	public Point_2D get_p2() {
		////// add your code here //////
		return p2;
		////////////////////////////////
	}

	private boolean isVertical(){ //function for checking if a line is vertical
		if (p1.x()==p2.x())
			return true;
		else
			return false;
	}
	public double Slope ()
	{
		return calculateSlope(this.p1,this.p2);
	}
	public static double calculateSlope(Point_2D at, Point_2D gt){

		if (at.x()==gt.x()) //vertical case= slope 0;
			return -1;

		if (at.y()==gt.y()) //horizntal case= slope 0;
			return 0;

		return (at.y()-gt.y())/(at.x()-gt.x());
	}

	public boolean intersect (Segment_2D other){ //function for checking if 2 lines intersect. used later.

		//prallel scanario
	if (calculateSlope(this.p1,this.p2)==calculateSlope(other.p1,other.p2))
		if (p1.x()==other.p1.x())
			return true;

		//all other
		double d = (other.p2.y() - other.p1.y()) * (p2.x() - p1.x()) - (other.p2.x() - other.p1.x()) * (p2.y() - p1.y());

		double uA = ((other.p2.x() - other.p1.x()) * (p1.y() - other.p1.y()) - (other.p2.y() - other.p1.y()) * (p1.x() - other.p1.x())) / d;
		double uB = ((p2.x() - p1.x()) * (p1.y() - other.p1.y()) - (p2.y() - p1.y()) * (p1.x() - other.p1.x())) / d;

		if (uA >= 0 && uA <= 1 && uB >= 0 && uB <= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Point_2D ot) { //checks if the distance from the point is logical

		double length = p1.distance(p2);
		double d1 = p1.distance(ot);
		double d2 = p2.distance(ot);


		return Math.abs(d1+d2-length)<0.001;
	}

	@Override
	public double area() {
		return 0;
	} //no area

	@Override
	public double perimeter() { //double the distance
		double d=p1.distance(p2);
		return 2*d;
	}

	@Override
	public void translate(Point_2D vec) { //moving the points
		p1.move(vec);
		p2.move(vec);
	}

	@Override
	public String toString()
	{
		return p1.toString()+", "+p2.toString();
	}

	@Override
	public GeoShape copy() {
		return new Segment_2D(p1, p2);
	} //copy constructor

	@Override
	public void scale(Point_2D center, double ratio) { //scaling the points
		p1.scale(center, ratio);
		p2.scale(center, ratio);

	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) { //rotating the points
	this.p1.rotate(center, angleDegrees);
	this.p2.rotate(center, angleDegrees);

	}
}