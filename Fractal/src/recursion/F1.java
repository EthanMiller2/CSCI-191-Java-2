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

/*The fractal parameter is used to convey the location of the current fractal. These methods are as follows:

 initialPolygon - generates the initial polygon for the base of the fractal.
 addFractal - decides whether to add another layer of fractals. Usually depends on the depth.
 getColor - select a color for a new fractal - this depends on the current fractal and the edge number being created.
 getShape - as above, select a shape
 insideEdge - decides whether to grow a fractal on the inside edge of a fractal.
 getOrigin - the origin for the base of a fractal that is on the edge from p1 to p2
 getFirstPoint - the location of the first point of the edge from p1 to p2 

 Create a class which implements this to set the parameters for your fractal. */
public class F1 implements Settings, SettingsFactory {

    public double t;
    public double extra;
    public F1 (){
        
    }
    

    public F1(double t, double extra) {
        this.t = t;
        this.extra = extra;
        this.colors[0] = new Color((int) (Math.abs(Math.cos(t * 3)) * 255), 10, 0);
        this.colors[1] = new Color(52, (int) (Math.abs(Math.cos(t * 1.6)) * 255), 25);
    }

    public Shape s = Shape.regularShape(4);
    Color colors[] = new Color[4];

    public boolean addFractal(Fractal f) {
        return f.depth <  4;
    }

    public Color getColor(Fractal f, int i) {
        return colors[f.depth % 4];
    }

    public Shape getShape(Fractal f, int i) {
        return s;
    }

    public boolean insideEdge(Fractal f) {
        return f.depth == 0;
    }

    public Point2 getOrigin(Fractal f, Point2 p1, Point2 p2) {
        return p1.interp(p2, .5);
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