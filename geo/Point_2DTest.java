package ex2.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {

    @Test
    void distance() {
        Point_2D p2= new Point_2D(0,0);
        Point_2D p1= new Point_2D(0,4);

        assertEquals(p1.distance(p2),4);
    }

    @Test
    void close2equals() {
        Point_2D p2= new Point_2D(0,0);
        Point_2D p1= new Point_2D(0,4);
        double eps=1;

        assertTrue(p2.close2equals(p2,5));

    }

    @Test
    void vector() {
        Point_2D p2= new Point_2D(0,0);
        Point_2D p1= new Point_2D(0,4);
        p2.vector(p1);

        assertEquals(p2.y(),0);
    }
    @Test
    void rotate(){
        Point_2D p1= new Point_2D(0,4);
        Point_2D center= new Point_2D(0,0);
        p1.rotate(center,180);

        assertEquals(p1.y(),-4);
    }

    @Test
    void move() {

        Point_2D p2= new Point_2D(0,0);
        Point_2D p1= new Point_2D(0,4);

        p2.move(p1);
        //did the point move ?
        assertEquals(p1.y(),4);
    }
}