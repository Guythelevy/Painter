package ex2.geo;

import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {

    @Test
    void equals(){

        Point_2D p1= new Point_2D(0,0); // ideal scanario
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);
        Rect_2D r2= new Rect_2D(p1,p2);

        assertTrue(r1.equals(r2));

    }
    @Test
    void contains() {
        Point_2D p1= new Point_2D(0,0); // ideal scanario
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);
        Point_2D p3= new Point_2D(3,3);

        assertTrue(r1.contains(p3));

    }

    @Test
    void area() {
        Point_2D p1= new Point_2D(0,0); // ideal scanario
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);

        assertEquals(r1.area(),16);

        Point_2D p11= new Point_2D(-1,-1); // minus scanario
        Point_2D p22= new Point_2D(-6,-6);
        Rect_2D r11= new Rect_2D(p11,p22);

        assertEquals(r11.area(),25);

        Point_2D p111= new Point_2D(28,10); // complex scanario
        Point_2D p222= new Point_2D(38,14);
        Rect_2D r111= new Rect_2D(p111,p222);

        assertEquals(r111.area(),40);
    }

    @Test
    void perimeter() {

        Point_2D p11= new Point_2D(-1,-1); // minus scanario
        Point_2D p22= new Point_2D(-6,-6);
        Rect_2D r11= new Rect_2D(p11,p22);

        assertEquals(r11.perimeter(),20);


    }

    @Test
    void translate() {
        Point_2D p1= new Point_2D(0,0); // two simmilar rect's
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);
        Point_2D vec= new Point_2D(9,9);
        Point_2D ot = new Point_2D(9,9);

        r1.translate(vec);// one moved

        assertTrue(r1.contains(ot));
    }

    @Test
    void copy() {

        Point_2D p1= new Point_2D(0,0); // ideal rectangle
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);

        Rect_2D r2 = (Rect_2D) r1.copy();

        assertArrayEquals(r1.getAllPoints(), r2.getAllPoints()); //checking if all the points are the same
    }

    @Test
    void scale() {

        Point_2D p1= new Point_2D(0,0); // ideal rectangle
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);

        Point_2D p3 = new Point_2D(2,2);
        r1.scale(p3, 2);

        assertEquals(r1.area(), 64); //is the area 2 times big ?
    }

    @Test
    void rotate() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);

        Point_2D ot = new Point_2D(0,-1);
        r1.rotate(p1,180);

        assertTrue(r1.contains(ot));
    }
    @Test
    void testToString() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(4,4);
        Rect_2D r1= new Rect_2D(p1,p2);


        String checker="0.0,4.0, 4.0,4.0, 4.0,0.0, 0.0,0.0";
        assertEquals(checker,r1.toString());
    }
}