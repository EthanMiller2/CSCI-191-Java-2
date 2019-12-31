package hw5;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {

    public int x;
    public int y;
    public int h;
    public int w;
    public Color c;
    public Brick[][] bricks;
    public int i;
    public int j;

    public Brick(int x, int y, int w, int h, Color c, int i, int j, Brick[][] bricks) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.c = c;
        this.i = i;
        this.j = j;
        this.bricks = bricks;
    }

    public Brick() {
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }

    public void hit(Ball b) {

        if (b.lastx < x) {
            b.x = 2 * x - b.x;
            b.xv = -b.xv;
        }
        if (b.lastx >= x + w - 1) {
            b.x = 2 * (x + w - 1) - b.x;
            b.xv = -b.xv;
        }
        if (b.lasty < y) {
            b.y = 2 * y - b.y;
            b.yv = -b.yv;
        }
        if (b.lasty >= y + h - 1) {
            b.y = 2 * (y + h - 1) - b.y;
            b.yv = -b.yv;
        }
        bricks[i][j] = null;
    }

    public void tick() {

    }

}
