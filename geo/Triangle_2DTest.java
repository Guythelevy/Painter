package ex2.geo;

import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {

    @Test
    void getAllPoints() {
        Point_2D p1= new Point_2D(0,0); //easy situation
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);

        Point_2D[] arr=new Point_2D[3];
        arr[0]=p1;
        arr[1]=p2;
        arr[2]=p3;

        assertArrayEquals(t1.getAllPoints(), arr);
    }

    @Test
    void contains() {

        Point_2D p1= new Point_2D(0,0); //easy situation
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);
        Point_2D ot= new Point_2D(1,1);
            assertTrue(t1.contains(ot));

        Point_2D p11= new Point_2D(1,8); //harder situation
        Point_2D p22= new Point_2D(5,16);
        Point_2D p33= new Point_2D(8,20);
        Triangle_2D t11 = new Triangle_2D(p11,p22,p33);
        Point_2D ot1= new Point_2D(5,15);
            assertTrue(t11.contains(ot1));

    }

    @Test
    void area() {
        Point_2D p1= new Point_2D(0,0); //easy situation
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);

        assertEquals(t1.area(),3);

        Point_2D p11= new Point_2D(1,8); //harder situation
        Point_2D p22= new Point_2D(5,16);
        Point_2D p33= new Point_2D(8,20);
        Triangle_2D t11 = new Triangle_2D(p11,p22,p33);

        assertEquals(t11.area(),4);
    }

    @Test
    void perimeter() {
        Point_2D p1= new Point_2D(0,0); //easy situation
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);

        assertEquals(t1.perimeter(),8.60555127546399);//calculated via calculator

        Point_2D p11= new Point_2D(1,8); //harder situation
        Point_2D p22= new Point_2D(5,16);
        Point_2D p33= new Point_2D(8,20);
        Triangle_2D t11 = new Triangle_2D(p11,p22,p33);

        assertEquals(t11.perimeter(),27.83671589944896);//calculated via calculator

    }

    @Test
    void translate() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);
        Triangle_2D t2 = new Triangle_2D(p1,p2,p3);

        Point_2D vec = new Point_2D(8,8);

        t1.translate(vec);

        Point_2D[] t1arr=t1.getAllPoints();
        Point_2D[] t2arr=t2.getAllPoints();


        assertEquals(t1arr[0].x(),t2arr[0].x());

    }

    @Test
    void copy() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);
        Triangle_2D t2 = (Triangle_2D) t1.copy();

        assertEquals(t1.perimeter(),t2.perimeter()); //do they have the same perimeter ?
    }

    @Test
    void scale() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);

        Point_2D center= new Point_2D(0,0);
        t1.scale(center,2);
        assertEquals(t1.area(),12); //is the area 4 times bigger ?
    }

    @Test
    void equals(){

        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,2);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);
        Triangle_2D t2 = new Triangle_2D(p1,p2,p3);

        assertTrue(t1.equals(t2));

    }
    @Test
    void rotate() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,3);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);

        t1.rotate(p1,180);

        Point_2D ot= new Point_2D(0,-1);

        assertTrue(t1.contains(ot));
    }
    @Test
    void testToString() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(0,3);
        Point_2D p3= new Point_2D(3,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);


        String checker="0.0,0.0,0.0,3.0,3.0,0.0";
        assertEquals(checker,t1.toString());

    }
}