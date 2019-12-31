package hw5;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ethanmiller
 */
public class Ball {

    public double x;
    public double y;
    public Color c;
    public double lastx;
    public double lasty;
    public double xv;
    public double yv;

    public Ball(double x, double y, double xv, double yv, Color c) {
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.c = c;
        this.lastx = x;
        this.lasty = y;
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
    }

    public void move() {
        lastx = x;
        lasty = y;
        x = x + xv / 10;
        y = y + yv / 10;
        if (x < 0) {
            x = -x;
            xv = -xv;
        }
        if (x > 399) {
            x = 798 - x;
            xv = -xv;
        }
        if (y < 0) {
            y = -y;
            yv = -yv;
        }
    }
}
