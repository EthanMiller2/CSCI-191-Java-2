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
public class TeleportBrick extends Brick{
    
    public TeleportBrick(int x, int y, int w, int h, Color c, int i, int j, Brick[][] bricks)
    {
       super(x, y, w, h, Color.MAGENTA, i, j, bricks);
    }
    
    @Override
    public void hit(Ball b)
    {
        
        
        if (b.lastx < x ) {
            b.x = 2*x - b.x;
            b.xv = -b.xv;
        }
        if (b.lastx >= x+w-1) {
            b.x = 2*(x+w-1) - b.x;
            b.xv = -b.xv;
        }
        if (b.lasty < y) {
            b.y = 2*y - b.y;
            b.yv = -b.yv;
        }
        if (b.lasty >= y+h-1) {
            b.y = 2*(y+h-1) - b.y;
            b.yv = -b.yv;
        }
        bricks[i][j] = null;
        
        b.y = 0;
    }
    
}
