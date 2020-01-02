/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongproject;

import java.awt.Color;
import java.awt.Graphics;
import static pongproject.PongFrame.ballRadius;
import static pongproject.PongFrame.fieldHeight;

/**
 *
 * @author ethanmiller
 */
public class Ball {

    public int x;
    public int y;
    public int xv;
    public int yv;
    public int radius;
    public Color c;
    public boolean score = false;

    public Ball(int x, int y, int xv, int yv, int radius, Color c) {
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.radius = radius;
        this.c = c;
    }

    public void move() {
        x = x + xv;
        y = y + yv;

        if (y < ballRadius) {
            yv = -yv;
            y = 2 * ballRadius - y; // Nudge the ball back onto the field 
        }
        if (y > fieldHeight - ballRadius) {
            yv = -yv;
            y = 2 * (fieldHeight - ballRadius) - y;
        }
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval(x - ballRadius, y - ballRadius, ballRadius * 2, ballRadius * 2);

    }
}
