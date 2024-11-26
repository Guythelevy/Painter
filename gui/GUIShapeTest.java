package ex2.gui;

import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    @Test
    void getShape() {

        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);


        assertEquals(g1.getShape().area(),3.14);

    }

    @Test
    void setShape() {
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        Point_2D p2 = new Point_2D(0,0);
        Circle_2D c2 = new Circle_2D(p1,4);


        g1.setShape(c2);

        assertEquals(g1.getShape().area(),50.24); //did the radious grow ?
    }

    @Test
    void isFilled() {
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        assertTrue(g1.isFilled());
    }

    @Test
    void setFilled() {

        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        g1.setFilled(false);

        assertFalse(g1.isFilled());

    }

    @Test
    void getColor() {
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        assertEquals(g1.getColor(),Color.blue);


    }

    @Test
    void setColor() {
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        g1.setColor(Color.BLUE);

        assertEquals(g1.getColor(),Color.BLUE);

    }

    @Test
    void getTag() {
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        assertEquals(g1.getTag(),4);
    }

    @Test
    void setTag() {

        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        g1.setTag(5);
        assertEquals(g1.getTag(),5);
    }

    @Test
    void copy() {

        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        GUIShape g2= (GUIShape) g1.copy();

        assertEquals(g1.isFilled(),g2.isFilled());

    }

    @Test
    void testToString() {

        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);

        assertEquals(g1.toString(),"GUIShape,java.awt.Color[r=0,g=0,b=255],true,4,Circle_2D,0.0,0.0, 1.0");
    }
    @Test
    void GUIShape(){
        String line="GUIShape,0,true,1,Circle_2D,3.0,4.0, 2.0";

        GUIShape g1 = new GUIShape(line);
        assertEquals(g1.getShape().area(),4*3.14); //circle area same as described in the string ?
    }

    @Test
    void isSelected() {
        String line="GUIShape,0,true,1,Circle_2D,3.0,4.0, 2.0";

        GUIShape g1 = new GUIShape(line);
        g1.setSelected(true);
        assertTrue(g1.isSelected());
    }

    @Test
    void setSelected() {
        String line="GUIShape,0,true,1,Circle_2D,3.0,4.0, 2.0"; //same same

        GUIShape g1 = new GUIShape(line);
        g1.setSelected(true);
        assertTrue(g1.isSelected());
    }
}