package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author GUY LEVY
 * ID:322317918
 */
import ex2.geo.*;
import java.awt.*;
import java.util.ArrayList;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	public GUIShape(String s) { //this is the shape constructor from a string ! it is used for saving and loading methods.

		String[] properties = s.split(","); //seperates the string lines using split ","
		String Color = properties[1];
		String filled = properties[2];
		double colorCode = Double.parseDouble(Color); //convers the color code to double
		double tag =(int) Double.parseDouble(properties[3]); //converts the tag to int

		String type = properties[4]; //type of shape

		boolean f=true;
		if (filled.matches("false")) //detemains if a shape will be filled or no
			f=false;
		Color c=new Color((int) colorCode);

		if (type.equals("Circle_2D")){ //for a circle
			System.out.println("Loading a Circle...");
			double x=Double.parseDouble(properties[5]);
			double y=Double.parseDouble(properties[6]);
			Point_2D center=new Point_2D(x,y); //center of circle
			double radius = Double.parseDouble(properties[7]); //radius...

			this._g = new Circle_2D(center,radius);
			this._color=c;
			this._fill=f;
			this._tag= (int) tag;
		}

		if (type.equals("Rect_2D")){
			System.out.println("Loading a rect...");
			double bottomLeftX=Double.parseDouble(properties[5]);
			double bottomLeftY=Double.parseDouble(properties[6]);
			Point_2D bottomLeft=new Point_2D(bottomLeftX,bottomLeftY);
			double topRightX=Double.parseDouble(properties[9]);
			double topRightY=Double.parseDouble(properties[10]);
			Point_2D topRight=new Point_2D(topRightX,topRightY);

			this._g = new Rect_2D(bottomLeft,topRight);
			this._color=c;
			this._fill=f;
			this._tag= (int) tag;
		}

		if (type.equals("Segment_2D")){
			System.out.println("Loading a segment...");
			double X1=Double.parseDouble(properties[5]);
			double Y1=Double.parseDouble(properties[6]);
			double X2=Double.parseDouble(properties[7]);
			double Y2=Double.parseDouble(properties[8]);
			Point_2D p1 = new Point_2D(X1,Y1);
			Point_2D p2 = new Point_2D(X2,Y2);

			this._g = new Segment_2D(p1,p2);
			this._color=c;
			this._fill=f;
			this._tag= (int) tag;
		}

		if (type.equals("Triangle_2D")){
			System.out.println("Loading a Triangle...");
			double X1=Double.parseDouble(properties[5]);
			double Y1=Double.parseDouble(properties[6]);
			double X2=Double.parseDouble(properties[7]);
			double Y2=Double.parseDouble(properties[8]);
			double X3=Double.parseDouble(properties[9]);
			double Y3=Double.parseDouble(properties[10]);

			Point_2D p1 = new Point_2D(X1,Y1);
			Point_2D p2 = new Point_2D(X2,Y2);
			Point_2D p3 = new Point_2D(X3,Y3);


			this._g = new Triangle_2D(p1,p2,p3);
			this._color=c;
			this._fill=f;
			this._tag= (int) tag;
		}

		if (type.equals("Polygon_2D")){ //endless array of points generator
			System.out.println("Loading a polygon...");
			Polygon_2D p1 = new Polygon_2D();
			for (int i = 5; i <properties.length-1 ; i=i+2) {
				double x=Double.parseDouble(properties[i]);
				double y=Double.parseDouble(properties[i+1]);
				Point_2D p= new Point_2D(x,y);
				p1.add(p); //all into an arraylist
			}
			this._g = p1;
			this._color=c;
			this._fill=f;
			this._tag= (int) tag;
		}


	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}


	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+_color+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
}
