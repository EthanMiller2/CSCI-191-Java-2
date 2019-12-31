package recursion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

//Note - you should delete the polygon parameter to the constructor in Fractal 
//- this now comes from settings. 
public class Fractal {

    public int depth;
    public int n; //edge number
    public Settings settings;
    public Polygon here;
    public ArrayList<Fractal> kids = new ArrayList<Fractal>();

    public Fractal(Settings settings) {
        this.settings = settings;
        this.here = settings.initialPolygon();
        this.depth = 0;
        this.n = 0;
        expand();
    }

    public Fractal(Settings settings, Polygon here, int depth, int n) {
        this.settings = settings;
        this.here = here;
        this.depth = depth;
        this.n = n;
        expand();
    }
    /* The expand method uses the addFractal method in the settings to determine whether or not
     to add another layer of fractals. If another layer is needed, call decorate in the underlying
     polygon to create a list of child fractals. Make this method "final" to avoid compiler warnings.
     The boolean parameter to determine whether to place a polygon on the bottom is determined
     by calling the insideEdge method in the settings.*/

    public final void expand() {
        // Decide whether to expand the fractal another level.
        if (settings.addFractal(this)) {
            kids = here.decorate(this, settings.insideEdge(this));
        }

    }

    public void draw(Graphics g) {
        // Draw the polygon in the fractal as well as all sub-fractals
        //  g.setColor(settings.getColor(this, n));

        for (Fractal f : kids) {
            f.draw(g);
        }
        here.draw(g);

    }

    public Fractal decorate(Point2 p1, Point2 p2, int i) {
        Point2 newOrigin = settings.getOrigin(this, p1, p2);
        Point2 firstPt = settings.getFirstPoint(this, p1, p2);
        Shape s = settings.getShape(this, i);
        Color c = settings.getColor(this, i);
        Polygon dude = new Polygon(s, newOrigin, firstPt, c);
        return new Fractal(settings, dude, depth + 1, i);

    }

    //(xmin, ymin), (xmin, ymax), (xmax, ymax), (xmax, ymin).
    public Point2 max() {
        Point2 p = here.max();
        for (Fractal f : kids) {
            p = p.max(f.max());
        }
        return p;

    }

    public Point2 min() {
        Point2 p = here.min();
        for (Fractal f : kids) {
            p = p.min(f.min());
        }
        return p;

    }

}
