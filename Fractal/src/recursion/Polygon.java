package recursion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Polygon {

    public ArrayList<Point2> pts;
    public Color c;
    public Point2 zero = new Point2(0, 0);

    public Polygon() {

    }

    public Polygon(Shape s, Point2 origin, Point2 first, Color c) {
        // Create a polygon based on a shape whose origin is at the given
        // point and whose first point is given - this stretches and rotates
        // the underlying shape

        pts = new ArrayList<Point2>();
        // Code goes here to create a point for each point in the shape.
        double dp = origin.dist(first);
        double ds = zero.dist(s.pts.get(0)); // to the shapes's first point
        double scale = dp / ds;
        double dx = first.x - origin.x;
        double dy = first.y - origin.y;
        double sin = dy / dp;
        double cos = dx / dp;

        for (int i = 0; i < s.pts.size(); i++) {
            Point2 newPt = new Point2();
            newPt.x = scale * ((s.pts.get(i).x * cos) - (s.pts.get(i).y * sin)) + origin.x;
            newPt.y = scale * ((s.pts.get(i).x * sin) + (s.pts.get(i).y * cos)) + origin.y;
            pts.add(newPt);
        }

        this.c = c;

    }

    public void draw(Graphics g) {
        int[] xp = new int[pts.size()];
        int[] yp = new int[pts.size()];
        int np = 0;
        for (Point2 p : pts) {
            xp[np] = (int) Math.round(p.x * Main.zoom - Main.panx);
            yp[np] = (int) Math.round(p.y * Main.zoom - Main.pany);
            np++;

        }
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c);
        g.fillPolygon(xp, yp, np);
    }

    // This changes to the following in part 2:
    // public ArrayList<Fractal> decorate(Fractal f, boolean insideEdge) {
    public ArrayList<Fractal> decorate(Fractal f, boolean insideEdge) {

        ArrayList<Fractal> decorateList = new ArrayList<Fractal>();
        Point2 newFirst = new Point2();
        Point2 midPoint = new Point2();
        int numSides = pts.size();
        if (!insideEdge) {
            numSides = numSides - 1;
        }
        for (int i = 0; i < numSides; i++) {
            newFirst = this.pts.get(i);
            midPoint = this.pts.get((i + 1) % pts.size());
            decorateList.add(f.decorate(newFirst, midPoint, i));
        }

        return decorateList;
    }
    // Create a polygon for every line segment in the polygon and return them.  

    public Point2 min() {
        Point2 p = pts.get(0);
        for (int i = 0; i < pts.size(); i++) {
            p = p.min(pts.get(i));
        }
        return p;
    }

    public Point2 max() {
        Point2 p = pts.get(0);
        for (int i = 0; i < pts.size(); i++) {
            p = p.max(pts.get(i));
        }
        return p;
    }
}
