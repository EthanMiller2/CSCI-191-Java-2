/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.awt.Color;

/**
 *
 * @author ethanmiller
 */
public class F3 implements Settings, SettingsFactory {

    public double t;
    public double extra;
    public F3 (){
        
    }
    

    public F3(double t, double extra) {
        this.t = t;
        this.extra = extra;
        this.colors[0] = new Color((int) (Math.abs(Math.cos(t * 2)) * 255), 0, 50);
        this.colors[1] = new Color(0, (int) (Math.abs(Math.cos(t * 1.6)) * 255), 75);
        
    }

    public Shape s = Shape.regularShape(4);
    Color colors[] = new Color[2];

    public boolean addFractal(Fractal f) {
        return f.depth < 7;
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
        return p1.interp(p2, .50 + t/4);
    }

    public Point2 getFirstPoint(Fractal f, Point2 p1, Point2 p2) {
        return p1.interp(p2, .3);
    }

    public Polygon initialPolygon() {
        Shape seed = Shape.regularShape(4);
        Polygon middle = new Polygon(seed, new Point2(300, 150), new Point2(380, 150), colors[1]);
        return middle;
    }


    public Settings getSettings(double t, double other) {
         return new F1(t, other);
    }
}