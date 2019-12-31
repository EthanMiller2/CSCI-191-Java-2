package recursion;

import java.text.DecimalFormat;

public class Point2 {

    public double x, y;

    public Point2() {

    }

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Multiply x and y by s and return in newP
    public Point2 scale(double s) {
        Point2 newP = new Point2();
        newP.x = this.x * s;
        newP.y = this.y * s;
        return newP;
    }

    // Add two points, and return the sum in newP
    public Point2 add(Point2 p) {
        Point2 newP = new Point2();
        newP.x = this.x + p.x;
        newP.y = this.y + p.y;
        return newP;
    }

    public Point2 interp(Point2 p, double t) {// This is interpolation
        // return a point between the given point and p.
        // For each coordinate, create a point with
        //    (1-t)*coordinate in current object + t*coordinate in p
        Point2 newP = new Point2();
        newP.x = (1 - t) * this.x + t * p.x;
        newP.y = (1 - t) * this.y + t * p.y;
        return newP;
    }

    public double dist(Point2 p) {// Distance from here to point p
        return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
    }

    public String toString() { // Return point in the form "(1,2)"
        return "(" + x + "," + y + ")";
    }

    public Point2 min(Point2 p) {  // Return the min of the x and y coords.
        Point2 newP = new Point2();
        newP.x = Math.min(this.x, p.x);
        newP.y = Math.min(this.y, p.y);
        return newP;
    }

    public Point2 max(Point2 p) {
        Point2 newP = new Point2();
        newP.x = Math.max(this.x, p.x);
        newP.y = Math.max(this.y, p.y);
        return newP;
    }

}
