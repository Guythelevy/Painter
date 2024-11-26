package ex2.geo;

import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {

    @Test
    void equals() {

        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);
        Circle_2D c2 = new Circle_2D(cetner1,radius);

        assertTrue(c1.equals(c2)); //same circle, should be true

    }


    @Test
    void contains() {

        //ideal case, perfect circle with 0,0 center
        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);
        Point_2D p2 = new Point_2D(0,0); //should be contained

        assertTrue(c1.contains(p2));


        //harder case
        double radius2 =5;
        Point_2D cetner2 = new Point_2D(1,5);
        Circle_2D c2 = new Circle_2D(cetner2, radius2);
        Point_2D p3 = new Point_2D(2,7);

        assertTrue(c2.contains(p3));

    }

    @Test
    void area() {

        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);

        //ideal case
        assertEquals(c1.area(),3.14);

        double radius2 =2.5;
        Point_2D cetner2 = new Point_2D(0,0);
        Circle_2D c2 = new Circle_2D(cetner2, radius2);

        //harder case
        assertEquals(c2.area(),19.625);

    }

    @Test
    void perimeter() {

        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius); //permiter should be 2pie

        assertEquals(c1.perimeter(), 6.28);

    }

    @Test
    void translate() {

        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);

        Point_2D v1 = new Point_2D(4,4);

        c1.translate(v1);

        assertEquals(c1.getCenter().x(), 4); //is the new center (4,4) ?
        assertEquals(c1.getCenter().y(), 4);
    }

    @Test
    void copy() {
        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);
        Circle_2D c2 = (Circle_2D) c1.copy();

        assertEquals(c1.getRadius(),c2.getRadius()); //does the new circle have the same radius ?
        assertEquals(c1.getCenter().x(),c2.getCenter().x()); //double check for the center

    }

    @Test
    void scale() {
        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);

        c1.scale(cetner1,1.5);

        assertEquals(c1.getRadius(),1.5); //radius should be 1*1.5;
    }

    @Test
    void rotate() {
        double radius =10;
        Point_2D cetner1 = new Point_2D(0,5);
        Circle_2D c1 = new Circle_2D(cetner1, radius);

        Point_2D center=new Point_2D(0,0);
        c1.rotate(center,180);
        Point_2D checker=new Point_2D(0,-10); //to check if it actually rotated by 180
        assertTrue(c1.contains(checker));
    }
    @Test
    void testToString() {
        double radius =1;
        Point_2D cetner1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(cetner1, radius);


        String checker="0.0,0.0, 1.0";
        assertEquals(checker,c1.toString());
    }
}