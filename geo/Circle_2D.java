package ex2.geo;

import org.junit.jupiter.api.Test;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;
	
	public Circle_2D(Point_2D cen, double rad) { //constructor from a radius and a point
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c) {

		this(c.getCenter(), c.getRadius());
	}
	public double getRadius() {return this._radius;}
	public Point_2D getCenter(){ return _center;}
	 @Override
	    public String toString()
	    {
			////// add your code here //////
			return _center.toString()+", "+_radius;
			//return null;
			////////////////////////////////
		}
	@Override
	public boolean equals(Object p) //is the center point and radius the same ?

	{
		if(p==null || !(p instanceof Circle_2D)) {return false;}
		Circle_2D c2 = (Circle_2D) p;
		return ((_center.x()==c2.getCenter().x()) && (_center.y()==c2.getCenter().y()) && _radius==c2.getRadius());
	}

	@Override
	public boolean contains(Point_2D ot) { // checks if the radius is smaller than the distance
		////// add your code here //////
		if (_center.distance(ot)>_radius)
			return false;
		else
			return true;
		////////////////////////////////
	}
	
	@Override
	public double area() { //2*radius^2
		////// add your code here //////
		if (_radius>0)//handle just right cases
			return 3.14*_radius*_radius;
		else {
			System.out.println("Error!");
			return -1;
		}
		////////////////////////////////
	}
	@Override
	public double perimeter() { //2*pie*radius
		////// add your code here //////
		if (_radius>0) //handle just right cases
			return 2*3.14*_radius;
		else {
			System.out.println("Error!");
			return -1;
		}
		////////////////////////////////
	}
	public Point_2D vector(Point_2D target) {
		double dx = target.x() - this._center.x();
		double dy = target.y() - this._center.y();
		return new Point_2D(dx,dy);
	}
	@Override
	public void translate(Point_2D vec) {
		////// add your code here //////
		this._center=vec;
		////////////////////////////////
	}
	@Override
	public GeoShape copy() { // a copy constructor
		////// add your code here //////
		return new Circle_2D(this);
		////////////////////////////////
	}

	@Override
	public void scale(Point_2D center, double ratio) { //scales the circle
		////// add your code here //////
		this._radius=this._radius*ratio;
		////////////////////////////////
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) { //rotate the circle from the center
		////// add your code here //////
		_center.rotate(center,angleDegrees);
		////////////////////////////////
	}


}
