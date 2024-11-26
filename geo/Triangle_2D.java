package ex2.geo;

import java.util.ArrayList;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{
	////// add your code here //////
	private ArrayList<Point_2D> PointsArr = new ArrayList<>(3);
	////////////////////////////////
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) { //defined with an arraylist of 3 points
		////// add your code here //////
		this.PointsArr=new ArrayList<>(3);
		this.PointsArr.add(p1);
		this.PointsArr.add(p2);
		this.PointsArr.add(p3);
		////////////////////////////////
	}


	public Triangle_2D(Triangle_2D t1) {
		////// add your code here //////
		this.PointsArr=new ArrayList<>(t1.PointsArr);
		////////////////////////////////
	}
	public Point_2D[] getAllPoints() { //returnes an array with all the points
		////// add your code here //////
		Point_2D[] arr = new Point_2D[PointsArr.size()];
		for (int i = 0; i <arr.length; i++) {
			arr[i]=PointsArr.get(i);

		}
		return arr;
		////////////////////////////////
	}
	@Override
	public boolean contains(Point_2D ot) { //this method creates 3 new triangles with the given point, and checks if all the areas are same as the original triangle area

		Triangle_2D t1 = new Triangle_2D(ot, this.PointsArr.get(1), this.PointsArr.get(2));
		Triangle_2D t2 = new Triangle_2D(this.PointsArr.get(0),ot , this.PointsArr.get(2));
		Triangle_2D t3 = new Triangle_2D(this.PointsArr.get(0),this.PointsArr.get(1) , ot);

		Triangle_2D big = new Triangle_2D(this.PointsArr.get(0),this.PointsArr.get(1) ,this.PointsArr.get(2));

		double areaSum= t1.area()+t2.area()+t3.area();
		if (big.area()-areaSum==0)
			return true;

		return false;
	}

	@Override
	public double area() {
			//reallllyyy long line, the formula is : 0.5 * |(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))|
	return	0.5 * Math.abs(
					this.PointsArr.get(0).x() * (this.PointsArr.get(1).y() - this.PointsArr.get(2).y())+
					this.PointsArr.get(1).x() * (this.PointsArr.get(2).y() - this.PointsArr.get(0).y())+
					this.PointsArr.get(2).x() * (this.PointsArr.get(0).y() - this.PointsArr.get(1).y())
	);
	}

	@Override
	public double perimeter() { //edge+edge+edge
		double d1=this.PointsArr.get(0).distance(this.PointsArr.get(1));
		double d2=this.PointsArr.get(1).distance(this.PointsArr.get(2));
		double d3=this.PointsArr.get(0).distance(this.PointsArr.get(2));

		return d1+d2+d3;
	}

	@Override
	public void translate(Point_2D vec) { //moving all the points
		PointsArr.get(0).move(vec);
		PointsArr.get(1).move(vec);
		PointsArr.get(2).move(vec);
	}

	@Override
	public GeoShape copy() {

		return new Triangle_2D(this);
	}

	@Override
	public boolean equals(Object p) //checks if all the points are equal

	{
		if(p==null || !(p instanceof Triangle_2D)) {return false;}
		Triangle_2D t2 = (Triangle_2D) p;

		return (this.PointsArr.get(0).equals(t2.PointsArr.get(0)) &&
				this.PointsArr.get(1).equals(t2.PointsArr.get(1)) &&
				this.PointsArr.get(2).equals(t2.PointsArr.get(2)));
	}

	@Override
	public void scale(Point_2D center, double ratio) { //scaling all the points
		this.PointsArr.get(0).scale(center, ratio);
		this.PointsArr.get(1).scale(center, ratio);
		this.PointsArr.get(2).scale(center, ratio);
	}
	@Override
	public String toString(){ //all the points divided by ","
		return this.PointsArr.get(0).toString()+","+this.PointsArr.get(1).toString()+","+this.PointsArr.get(2).toString();
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) { //rotating all the points
		this.PointsArr.get(0).rotate(center, angleDegrees);
		this.PointsArr.get(1).rotate(center, angleDegrees);
		this.PointsArr.get(2).rotate(center, angleDegrees);
	}
}
