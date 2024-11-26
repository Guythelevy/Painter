package ex2.geo;

import java.util.ArrayList;

public class Polygon_2D implements GeoShape{
	////// add your code here //////
	private ArrayList<Point_2D> PointsArr; //Dynamic array of points
	////////////////////////////////
	public Polygon_2D() { //constructor
		////// add your code here //////
		PointsArr = new ArrayList<>();
		////////////////////////////////
	}
	public Polygon_2D(Polygon_2D po) {
		////// add your code here //////
		this.PointsArr = new ArrayList<>(po.PointsArr);
		////////////////////////////////
	}

	public Polygon_2D (ArrayList<Point_2D> points){ //constructor that gets an arraylist for load function

		if (points == null || points.isEmpty()) {
			throw new IllegalArgumentException("ERROR:Polygon empty !");
		}
		this.PointsArr=points;
	}
	public Point_2D[] getAllPoints() { //returns all the points as an Point array
		////// add your code here //////
		Point_2D[] arr = new Point_2D[PointsArr.size()];
		for (int i = 0; i <arr.length; i++) {
			arr[i]=PointsArr.get(i);
		}
        return arr;
		////////////////////////////////
	}

	public void add(Point_2D p) { // add a point
		////// add your code here //////
		PointsArr.add(p);
		////////////////////////////////
	}
	@Override
	public String toString() //for the save method
	{
		////// add your code here //////
		String s="";
		if (!PointsArr.isEmpty()){
		for (int i = 0; i < PointsArr.size() ; i++) {
			s=s+PointsArr.get(i).toString()+", ";
		}}
		String m = s.substring(0, s.length() - 2); //get rid of the last ", "
		return m;
		////////////////////////////////
	}

	@Override
	public boolean contains (Point_2D ot){ //draws a line from one of the polygons points, to the end of the grid
		int i, j;
		boolean result = false; //then counts the number of intersections. if its even, the point is not contained
		for (i = 0, j = PointsArr.size() - 1; i < PointsArr.size(); j = i++) {
			if ((PointsArr.get(i).y() > ot.y()) != (PointsArr.get(j).y() > ot.y()) &&
					(ot.x() < (PointsArr.get(j).x() - PointsArr.get(i).x()) * (ot.y() - PointsArr.get(i).y()) / (PointsArr.get(j).y() - PointsArr.get(i).y()) + PointsArr.get(i).x())) {
				result = !result; //if its odd then the points contained
			}
		}
		return result;

	}


	@Override
	public double area() { //this method breaks the polygon into triangles, then calculates the area of each triangle, and sums up everyone all together
		////// add your code here //////

		int n = PointsArr.size();
		double polyarea = 0.0;

		for (int i = 0; i < n; i++) {
			Point_2D current = PointsArr.get(i);
			Point_2D next = PointsArr.get((i + 1) % n); // Handle top index

			polyarea += current.x() * next.y() - next.x() * current.y();
		}

		polyarea /= 2.0;
		return Math.abs(polyarea); //to insure its positive

		////////////////////////////////
	}

	@Override
	public double perimeter() { //this method goes over each edge of the polygon, and adds up the edgeLength all together
		////// add your code here //////

		double perimeter = 0;
		int n = PointsArr.size();

		for (int i = 0; i < n; i++) {

			Point_2D current = PointsArr.get(i);
			Point_2D next = PointsArr.get((i + 1) % n);

			double edgeLength = Math.sqrt(Math.pow(next.x() - current.x(), 2) +
					Math.pow(next.y() - current.y(), 2));

			perimeter += edgeLength;
		}

		return perimeter;
		////////////////////////////////
	}
	@Override
	public void translate(Point_2D vec) {
		////// add your code here //////
		if (!PointsArr.isEmpty()) {
			for (int i = 0; i <PointsArr.size() ; i++) {
				PointsArr.get(i).move(vec);
			}
			}
		}
		////////////////////////////////

	@Override
	public GeoShape copy() { //copy constructor
		////// add your code here //////
		return new Polygon_2D(this);
		////////////////////////////////
	}

	@Override
	public boolean equals(Object p){ //checks if ALL the points are the same.
		int counter=0;
		if(p==null || !(p instanceof Polygon_2D)) {return false;}
		Polygon_2D p2 = (Polygon_2D) p;

		for (int i = 0; i <PointsArr.size() ; i++) {
			if (PointsArr.get(i).equals(p2.PointsArr.get(i)))
				counter++;
		}
		return (counter==PointsArr.size());
	}

	@Override
	public void scale(Point_2D center, double ratio) { //scaling all the points with a loop
		////// add your code here //////
		if (!PointsArr.isEmpty()) {
			for (int i = 0; i <PointsArr.size() ; i++) {
				PointsArr.get(i).scale(center, ratio);
			}
		}
		////////////////////////////////
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) { //rotating all the points with a loop
		////// add your code here //////
		if (!PointsArr.isEmpty()){
            for (Point_2D point2D : PointsArr) {
                point2D.rotate(center, angleDegrees);
            }
        }
		////////////////////////////////
	}


}
