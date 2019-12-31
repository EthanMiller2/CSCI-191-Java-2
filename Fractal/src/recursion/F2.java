/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author ethanmiller
 */
public class F2 implements Settings, SettingsFactory {

    public double t;
    public double extra;
    
    public F2 (){
        
    }
    
 
    public F2(double t, double extra) {
        this.t = t;
        this.extra = extra;
        this.colors[0] = new Color((int) (Math.abs(Math.cos(t * 2)) * 255), 5, 100);
        this.colors[1] = new Color(0, (int) (Math.abs(Math.cos(t * 1.6)) * 255), 25);
        
    }
    public int count = 3;
    public Shape s = Shape.regularShape(5);
    
    Color colors[] = new Color[2];

    public boolean addFractal(Fractal f) {
        return f.depth < 3;
    }

    public Color getColor(Fractal f, int i) {
        return colors[f.depth % 2];
    }

    public Shape getShape(Fractal f, int i) {
        return s;
        
    }

    public boolean insideEdge(Fractal f) {
        return f.depth == 0;
    }

    public Point2 getOrigin(Fractal f, Point2 p1, Point2 p2) {
        return p1.interp(p2, .5 + t/10);
    }

    public Point2 getFirstPoint(Fractal f, Point2 p1, Point2 p2) {
        return p1.interp(p2, .3);
    }

    public Polygon initialPolygon() {
        Shape seed = Shape.regularShape(3);
        Polygon middle = new Polygon(seed, new Point2(300, 150), new Point2(380, 150), colors[1]);
        return middle;
    }


    public Settings getSettings(double t, double other) {
         return new F1(t, other);
    }
}

    

