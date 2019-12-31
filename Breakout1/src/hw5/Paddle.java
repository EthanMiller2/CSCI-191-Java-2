package hw5;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    public int y;
    public int x;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x - Main.paddleWidth / 2, y, Main.paddleWidth, Main.paddleHeight);
    }

    public void bounce(Ball b) {
        if (b.lasty < y && b.y >= y && b.x >= x - Main.paddleWidth / 2 && b.x <= x + Main.paddleWidth / 2) {
            b.y = 2 * y - b.y;
            b.yv = -b.yv;
            b.xv = (((int) b.x) - x) / 2;
        }
    }

    public void move(int newx) {
        x = newx;
    }
}
