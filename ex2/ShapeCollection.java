package ex2.ex2;

import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) { //removes element at index i
		//////////add your code below ///////////
		_shapes.remove(i);
		return null;
		//////////////////////////////////////////
	}

	@Override
	public void addAt(GUI_Shape s, int i) { //adds element at index i
		//////////add your code below ///////////
		_shapes.add(i,s);
		//////////////////////////////////////////
	}
	@Override
	public void add(GUI_Shape s) { //adds a shape
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}

	}
	@Override
	public GUI_Shape_Collection copy() { //copys the original array and creates a new ShapeCollection with it
		//////////add your code below ///////////
		ArrayList<GUIShape> guiShapes = new ArrayList<>();
		ShapeCollection s1 = new ShapeCollection();
		for (int i = 0; i < _shapes.size()-1 ; i++) {
			s1.add(this._shapes.get(i));
		}

		return s1;
		//////////////////////////////////////////
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) { // Method for sorting the shapes, uses ShapeComp!
		//////////add your code below ///////////
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < this._shapes.size() - 1; i++) {
				int ans = comp.compare(this._shapes.get(i), this._shapes.get(i + 1)); //compares the shape with next in the array
				if (ans > 0) {
					flag = true;
					GUI_Shape gs = this._shapes.get(i);
					this._shapes.set(i, this._shapes.get(i + 1)); //sets accordingly !
					this._shapes.set(i + 1, gs);
				}
			}
		}
	}
		//////////////////////////////////////////


	@Override
	public void removeAll() { //removes all shapes
		//////////add your code below ///////////
		_shapes.clear();
		//////////////////////////////////////////
	}
	public static int colorEncoding(Color c) { //Color coding ! for save and load functions
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r*256*256 + g*256 + b;
		return ce;
	}


	@Override
	public void save(String file) { //this function is for saving files. it uses the fileWriter package
//		//////////add your code below ///////////
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < _shapes.size(); i++) { //Creats a long String with all of the GUIShape propeties in it
				String s="GUIShape," + colorEncoding(_shapes.get(i).getColor()) + "," + _shapes.get(i).isFilled() + "," + _shapes.get(i).getTag()+","+_shapes.get(i).getShape().getClass().getSimpleName()+","+_shapes.get(i).getShape().toString();
				writer.write(s);
				writer.newLine(); //next line for the next shape
			}
			writer.close(); //closes after going through all the shapes
			System.out.println("File saved !");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


        //////////////////////////////////////////


	@Override
	public void load(String file) { //this method is for loading from a txt file ! it uses file reade and GUIShape string constructor
		_shapes.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) { //goes through all the lines in the file
				_shapes.add(new GUIShape(line)); //each line adds a shape to the array using the constructor
				System.out.println("Shape "+_shapes.size()+" added successfully!"); //for added interaction with the user
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}

}
