package ex2.gui;

import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Polygon_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
    private Ex2 ex2=null;
    Point_2D p1 = new Point_2D(1,1);
    Point_2D p2 = new Point_2D(2,2);
    Point_2D p3 = new Point_2D(3,3);
    Segment_2D segment = new Segment_2D(p1,p2);
    Circle_2D circle = new Circle_2D(Point_2D.ORIGIN,4);
    GUIShape gs1 = new GUIShape(segment,true,Color.pink,1);
    ShapeCollection s1= new ShapeCollection();

    @Test
    void init() {
        ShapeCollection s1= new ShapeCollection();
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        s1.add(g1);

        Ex2 x1 = Ex2.getInstance();
        x1.init(s1);
        assertEquals(x1.getShape_Collection(),s1);
    }



    @Test
    void getInstance() {
        ShapeCollection s1= new ShapeCollection(); //same same :)
        Point_2D p1 = new Point_2D(0,0);
        Circle_2D c1 = new Circle_2D(p1,1);
        GUIShape g1=new GUIShape(c1,true, Color.blue,4);
        s1.add(g1);

        Ex2 x1 = Ex2.getInstance();
        x1.init(s1);
        assertEquals(x1.getShape_Collection(),s1);
    }

    @Test
    void drawShapes() {
        this.ex2=Ex2.getInstance();
        this.ex2.getShape_Collection().add(gs1);
        this.ex2.drawShapes();

    }


    @Test
    void mouseClicked() {
        this.ex2=Ex2.getInstance();
        this.ex2.mouseClicked(p1);
        assertTrue(this.ex2.getShape_Collection().get(0).isSelected());
    }

    @Test
    void mouseRightClicked() {
        s1.add(gs1);
        this.ex2=Ex2.getInstance();
        String _mode="Polygon";
        ex2.actionPerformed(_mode);
        ex2.mouseClicked(p1);
        ex2.mouseClicked(p2);
        ex2.mouseClicked(p3);
        ex2.mouseRightClicked(p2);

    }


    @Test
    void getShape_Collection() {
        ShapeCollection g1 = new ShapeCollection();
        g1.add(gs1);
        //this.ex2.getShape_Collection();
        assertEquals(g1.get(0).getTag(),1);

    }



    @Test
    void getInfo() {
        ex2=Ex2.getInstance();
        s1.add(gs1);
        ex2.init(s1);
        assertEquals(ex2.getInfo(),s1.toString() +"\n");

    }


}