package ex2.ex2;

import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.ShapeComp;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {

    @Test
    void get() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        s1.add(g1);

        assertEquals(s1.get(0).getTag(),g1.getTag());
    }

    @Test
    void size() {

        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        s1.add(g1);

        assertEquals(s1.size(),1);

    }

    @Test
    void removeElementAt() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        Circle_2D c2 = new Circle_2D(p1,2);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        GUIShape g2=new GUIShape(c2,true, Color.blue,4);
        s1.add(g1);
        s1.add(g2);

        s1.removeElementAt(1);

        assertEquals(s1.size(),1);

    }

    @Test
    void addAt() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        Circle_2D c2 = new Circle_2D(p1,2);
        Circle_2D c3 = new Circle_2D(p1,4);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        GUIShape g2=new GUIShape(c2,true, Color.blue,4);
        GUIShape g3=new GUIShape(c3,true, Color.blue,4);
        s1.add(g1);
        s1.add(g2);
        s1.add(g3);
        Circle_2D c4 = new Circle_2D(p1,3);
        GUIShape g4=new GUIShape(c4,true, Color.blue,1); //only one with tag 1
        s1.addAt(g4,3);

        assertEquals(s1.get(3).getTag(),1);


    }

    @Test
    void add() {
        ArrayList<GUI_Shape> shapes=new ArrayList<>();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        shapes.add(g1);
        assertEquals(shapes.get(0).getTag(),g1.getTag());

    }

    @Test
    void copy() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        Circle_2D c2 = new Circle_2D(p1,2);
        Circle_2D c3 = new Circle_2D(p1,4);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        GUIShape g2=new GUIShape(c2,true, Color.blue,0);
        GUIShape g3=new GUIShape(c3,true, Color.blue,4);
        s1.add(g1);
        s1.add(g2);
        s1.add(g3);

        ShapeCollection s2 = (ShapeCollection) s1.copy();

        assertEquals(s2.get(1).getTag(),0);
    }

    @Test
    void sort() {
        //creating a shape collection to sort
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        Circle_2D c2 = new Circle_2D(p1,2);


        GUIShape g1=new GUIShape(c1,true, Color.blue,0);
        GUIShape g2=new GUIShape(c2,true, Color.blue,1);

        s1.add(g1);
        s1.add(g2);
        //now lets check all the possible sorts
        ShapeComp comp1 = new ShapeComp(Ex2_Const.Sort_By_Area);
        assertEquals(1,comp1.compare(g2,g1));

        ShapeComp comp2 = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
        assertEquals(-1,comp2.compare(g2,g1));

        ShapeComp comp3 = new ShapeComp(Ex2_Const.Sort_By_Tag);
        assertEquals(1,comp3.compare(g2,g1));

        ShapeComp comp4 = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);
        assertEquals(-1,comp4.compare(g2,g1));

        ShapeComp comp5 = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
        assertEquals(1,comp5.compare(g2,g1));

        ShapeComp comp6 = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
        assertEquals(-1,comp6.compare(g2,g1));

        ShapeComp comp8 = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
        assertEquals(1,comp8.compare(g2,g1));

        ShapeComp comp7 = new ShapeComp(Ex2_Const.Sort_By_toString);
        assertEquals(-1,comp7.compare(g2,g1));

    }

    @Test
    void removeAll() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        Circle_2D c2 = new Circle_2D(p1,2);
        Circle_2D c3 = new Circle_2D(p1,4);
        GUIShape g1=new GUIShape(c1,true, Color.blue,0);
        GUIShape g2=new GUIShape(c2,true, Color.blue,0);
        GUIShape g3=new GUIShape(c3,true, Color.blue,4);
        s1.add(g1);
        s1.add(g2);
        s1.add(g3);

        s1.removeAll();
        assertEquals(s1.size(),0);
    }

    @Test
    void SaveandLoad() {
        try {
            ShapeCollection s1 = new ShapeCollection();
            Point_2D p1 = new Point_2D(0, 0);
            Circle_2D c1 = new Circle_2D(p1, 1);
            Circle_2D c2 = new Circle_2D(p1, 2);
            Circle_2D c3 = new Circle_2D(p1, 4);
            GUIShape g1 = new GUIShape(c1, true, Color.blue, 0);
            GUIShape g2 = new GUIShape(c2, true, Color.blue, 0);
            GUIShape g3 = new GUIShape(c3, true, Color.blue, 4);
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);

            s1.save("saveTest");
            ShapeCollection s2 = new ShapeCollection();
            s2.load("saveTest");
            assertEquals(s1.toString(),s2.toString());

        }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }

    @Test
    void testToString() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        s1.add(g1);

        assertEquals(s1.toString(),"GUIShape,java.awt.Color[r=0,g=0,b=255],true,4,Circle_2D,0.0,0.0, 1.0");
    }
}