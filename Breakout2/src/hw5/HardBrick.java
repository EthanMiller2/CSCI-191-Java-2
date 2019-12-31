/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.awt.Color;

/**
 *
 * @author ethanmiller
 */
public class HardBrick extends ColorBrick {

    public int hc = 0;

    public HardBrick(int x, int y, int w, int h, Color[] colors1, int i, int j, Brick[][] bricks) {
        super(x, y, w, h, colors1, i, j, bricks);

    }

    @Override
    public void hit(Ball b) {

        if (hc < 3) {
            if (b.lastx < x) {
                b.x = 2 * x - b.x;
                b.xv = -b.xv;
                hc++;
            }
            if (b.lastx >= x + w - 1) {
                b.x = 2 * (x + w - 1) - b.x;
                b.xv = -b.xv;
                hc++;
            }
            if (b.lasty < y) {
                b.y = 2 * y - b.y;
                b.yv = -b.yv;
                hc++;
            }
            if (b.lasty >= y + h - 1) {
                b.y = 2 * (y + h - 1) - b.y;
                b.yv = -b.yv;
                hc++;
            }
        }
        if (hc == 3) {
            bricks[i][j] = null;
        }
    }

    @Override
    public void tick() {

        timer++;
        if (timer > 2.5) {
            timer = 0;
            colnum = (colnum + 1) % colors.length;
            c = colors[colnum];
        }

    }

}
