package ex2.geo;

import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {

    @Test
    void getAllPoints() {

        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D(); //manual polygon

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        Point_2D[] arr= new Point_2D[4]; //manual Array with the same points
        arr[0]=p1;
        arr[1]=p2;
        arr[2]=p3;
        arr[3]=p4;

        assertArrayEquals(poly.getAllPoints(), arr);
    }

    @Test
    void add() {

        Point_2D p1 = new Point_2D(1, 1); //manual polygon with p1
        Polygon_2D poly = new Polygon_2D();
        poly.add(p1);
        Point_2D[] arr=poly.getAllPoints(); //get p1 out of the polygon

        assertEquals(p1.x(),arr[0].x()); // do they have the same X ?
    }

    @Test
    void testToString() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);


        String checker="1.0,1.0, 1.0,4.0, 4.0,4.0, 4.0,1.0";
        assertEquals(checker,poly.toString());



    }

    @Test
    void contains() {

        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D(); //manual polygon

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        Point_2D ot = new Point_2D(2, 2); //should be contained

        assertTrue(poly.contains(ot));

    }

    @Test
    void area() {


        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        assertEquals(poly.area(),9); //calculated manully with a calculator
    }

    @Test
    void perimeter() {

        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        assertEquals(poly.perimeter(),12); //calculated manully with canculator

    }

    @Test
    void equals(){
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        Polygon_2D poly2 = new Polygon_2D();

        poly2.add(p1);
        poly2.add(p2);
        poly2.add(p3);
        poly2.add(p4); //two simmilar poly's

        assertTrue(poly.equals(poly2));

    }
    @Test
    void translate() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);
        Point_2D vec = new Point_2D(100,100);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        poly.translate(vec);

        Polygon_2D poly2 = new Polygon_2D();

        poly2.add(p1);
        poly2.add(p2);
        poly2.add(p3);
        poly2.add(p4); //two simmilar poly's

        Point_2D[] polyarr = poly.getAllPoints();
        Point_2D[] polyarr2 = poly2.getAllPoints();

        assertEquals(polyarr[0].x(),polyarr2[0].x());

    }

    @Test
    void copy() {

        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 1);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        //(after permiter works for sure)
        assertEquals(poly.copy().perimeter(), poly.perimeter()); // do they have the same permiter ?

    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(0, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 0);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        Point_2D center = new Point_2D(2,2);
        poly.scale(center,2);

        assertEquals(poly.area(), 64);//is the area 2 times bigger ? ?
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(0, 4);
        Point_2D p3 = new Point_2D(4, 4);
        Point_2D p4 = new Point_2D(4, 0);

        Polygon_2D poly = new Polygon_2D();

        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);

        Polygon_2D poly2 = new Polygon_2D();

        poly2.add(p1);
        poly2.add(p2);
        poly2.add(p3);
        poly2.add(p4); //two simmilar poly's

        poly.rotate(p1, 90); //rotate the first

        Point_2D[] polyarr = poly.getAllPoints();
        Point_2D[] polyarr2 = poly2.getAllPoints();

        assertEquals(polyarr[0].x(),polyarr2[0].x());

        //are the points the same after rotating only one ?

    }

}