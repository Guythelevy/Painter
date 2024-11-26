package ex2.geo;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {


    @org.junit.jupiter.api.Test
    void calculateSlope() {

        Point_2D p1 = new Point_2D(2,8);
        Point_2D p2 = new Point_2D(10,24);
        //the slope of the 2 given points should be 2
        assertEquals(Segment_2D.calculateSlope(p1,p2),2);

        Point_2D p3 = new Point_2D(0,8);
        Point_2D p4 = new Point_2D(0,20);
        //vertical case
        assertEquals(Segment_2D.calculateSlope(p3,p4),-1);

    }


    @org.junit.jupiter.api.Test
    void contains() {
        //Lets check a vertical line
        Point_2D p1 = new Point_2D(0,2);
        Point_2D p2 = new Point_2D(0,5);
        Segment_2D s1= new Segment_2D(p1,p2);
        Point_2D p3 = new Point_2D(0,4);

        assertTrue(s1.contains(p3));

        //now a non-vertical
        Point_2D p11 = new Point_2D(0,2);
        Point_2D p22 = new Point_2D(2,4);
        Segment_2D s11= new Segment_2D(p11,p22);
        Point_2D p33 = new Point_2D(1,3);


        assertTrue(s11.contains(p33));

    }

    @org.junit.jupiter.api.Test
    void Intersect(){

        //checking a intersecting scnaraio

        Point_2D p1 = new Point_2D(0,2);
        Point_2D p2 = new Point_2D(0,5);
        Segment_2D s1 = new Segment_2D(p1,p2);

        Point_2D p3 = new Point_2D(-2,3);
        Point_2D p4 = new Point_2D(2,3);
        Segment_2D s2 = new Segment_2D(p3,p4);

        assertTrue(s1.intersect(s2));


        Point_2D p11 = new Point_2D(4,17);
        Point_2D p21 = new Point_2D(8,25);
        Segment_2D s11 = new Segment_2D(p11,p21);

        Point_2D p31 = new Point_2D(0,20);
        Point_2D p41 = new Point_2D(10,20);
        Segment_2D s21 = new Segment_2D(p31,p41);

        assertTrue(s11.intersect(s21));


    }


    @org.junit.jupiter.api.Test

    void translate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,10);
        Segment_2D s1 = new Segment_2D(p1,p2);
        Point_2D center= new Point_2D(100,100);

        s1.translate(center);
        Point_2D checker= new Point_2D(100,101);

        assertTrue(s1.contains(checker)); //did it move ?
    }

    @org.junit.jupiter.api.Test
    void copy() {
        Point_2D p1 = new Point_2D(0,2);
        Point_2D p2 = new Point_2D(0,5);
        Segment_2D s1 = new Segment_2D(p1,p2);

        Segment_2D s2 = (Segment_2D) s1.copy();

        assertEquals(s1.p1.x(), s2.p1.x());
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,10);
        Segment_2D s1 = new Segment_2D(p1,p2);
        Point_2D center= new Point_2D(0,0);

        s1.scale(center,100);
        Point_2D checker= new Point_2D(0,15);

        assertTrue(s1.contains(checker)); //did it grow ?
    }

    @org.junit.jupiter.api.Test
    void rotate() {

        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,10);
        Segment_2D s1 = new Segment_2D(p1,p2);
        Point_2D center= new Point_2D(0,0);
        s1.rotate(center,180);
        Point_2D checker= new Point_2D(0,-5);

        assertTrue(s1.contains(checker)); //did it rotate ?
    }

    @Test
    void testToString() {
        Point_2D p1 = new Point_2D(0,2);
        Point_2D p2 = new Point_2D(0,5);
        Segment_2D s1= new Segment_2D(p1,p2);

        String checker="0.0,2.0, 0.0,5.0";
        assertEquals(checker,s1.toString());
    }
}