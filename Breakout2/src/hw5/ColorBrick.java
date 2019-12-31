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
public class ColorBrick extends Brick {

    public Color[] colors;
    public int coltick = 5;
    public int timer = 0;
    public int colnum = 0;

    public ColorBrick(int x, int y, int w, int h, Color[] colors, int i, int j, Brick[][] bricks) {
        super(x, y, w, h, colors[0], i, j, bricks);
        this.colors = colors;

    }

    public ColorBrick() {
    }

    @Override
    public void tick() {
        timer++;
        if (timer > coltick * 10) {
            timer = 0;
            colnum = (colnum + 1) % colors.length;
            c = colors[colnum];
        }

    }

}
