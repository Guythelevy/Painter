package ex2.geo;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {

	private Point_2D bottomLeft;
	private Point_2D topRight;
	private Point_2D topLeft;
	private Point_2D bottomRight;
	public Rect_2D(Point_2D bottomLeft, Point_2D topRight) { //constructor of a Rectangle using 2 different points

		this.bottomLeft=new Point_2D(bottomLeft);
		this.topRight =new Point_2D(topRight);
		this.topLeft =new Point_2D(bottomLeft.x(), topRight.y());
		this.bottomRight=new Point_2D(topRight.x(), bottomLeft.y());

	}
	public Rect_2D(Rect_2D t1) {
		this(t1.getBottomLeft(),t1.getTopRight());
	}

	@Override
	public boolean equals(Object p) //cehcks if 2 of the main points are the same, the rest are automaticlly included.

	{
		if(p==null || !(p instanceof Rect_2D)) {return false;}
		Rect_2D r2 = (Rect_2D)p;

		return (this.bottomLeft.equals(r2.getBottomLeft()) && this.topRight.equals(r2.getTopRight()));
	}

	public Point_2D getBottomLeft() {
		return bottomLeft;
	}
	public Point_2D[] getAllPoints(){ //returns an array with all the points
		Point_2D[] arrP = new Point_2D[4];
		arrP[0]=this.bottomLeft;
		arrP[1]=this.topLeft;
		arrP[2]=this.topRight;
		arrP[3]=this.bottomRight;

		return arrP;
	}

	public Point_2D getTopRight() {return topRight;}

	@Override
	public boolean contains(Point_2D ot) { //checks wether the given point is between X cords and Y cords
		Triangle_2D t1 = new Triangle_2D(topLeft,topRight,ot);
		Triangle_2D t2 = new Triangle_2D(bottomRight,topRight,ot);
		Triangle_2D t3 = new Triangle_2D(bottomLeft,bottomRight,ot);
		Triangle_2D t4 = new Triangle_2D(topLeft,bottomLeft,ot);

		if (t1.area()+t2.area()+t3.area()+ t4.area()==this.area())
			return true;

		return false;
	}

	@Override
	public double area() { //edge*edge
		double maxX = Math.max(topRight.x(), bottomLeft.x()); //make sure whos the 'upper' point
		double minX = Math.min(topRight.x(), bottomLeft.x());
		double maxY = Math.max(bottomLeft.y(), topRight.y());
     	double minY = Math.min(bottomLeft.y(), topRight.y());
		double segY = maxY-minY;
		double segX = maxX-minX;

		return segX*segY; //returning Segment*Segment
	}

	@Override
	public double perimeter() { //2edges+2edges
		double maxX = Math.max(topRight.x(), bottomRight.x()); //make sure whos the 'upper' point
		double minX = Math.min(topRight.x(), bottomRight.x());
		double maxY = Math.max(bottomLeft.y(), topLeft.y());
		double minY = Math.min(bottomLeft.y(), topLeft.y());
		double segY = maxY-minY; //same algo for canculating segments
		double segX = maxX-minX;
		return 2*((2*segX)+(2*segY));
	}

	@Override
	public void translate(Point_2D vec) { //moving the points
		topLeft.move(vec);
		bottomRight.move(vec);
		topRight.move(vec);
		bottomLeft.move(vec);

	}



	@Override
	public GeoShape copy() {
		return new Rect_2D(this);
	} //copy constructor

	@Override
	public void scale(Point_2D center, double ratio) { //scaling the points
		topLeft.scale(center, ratio);
		bottomRight.scale(center, ratio);
		topRight.scale(center, ratio);
		bottomLeft.scale(center, ratio);
	}


	@Override
	public String toString(){
		return topLeft.toString()+", "+topRight+", "+bottomRight.toString()+", "+bottomLeft.toString();
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) { //rotating the points
	bottomLeft.rotate(center,angleDegrees);
	bottomRight.rotate(center,angleDegrees);
	topRight.rotate(center,angleDegrees);
	topLeft.rotate(center,angleDegrees);
	}
}
