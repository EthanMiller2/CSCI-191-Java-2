/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongproject;

import java.awt.Color;
import java.awt.Graphics;
import static pongproject.PongFrame.leftPaddlex;

/**
 *
 * @author ethanmiller
 */
public class Paddle {

    public int x;
    public int y;
    public int height;
    public int width;
    public int maxMovement;
    public int score = 0;

    public Paddle(int x, int height, int width, int maxMovement) {
        this.x = x;
        this.height = height;
        this.width = width;
        this.maxMovement = maxMovement;

    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y - height / 2, width, height);

    }

    public void sety(int targety) {
        this.y = Math.max(y - 10, Math.min(y + 10, targety));
    }

    public void Bounce(Ball b) {

        if (b.xv > 0) {
            int bounceline = x - b.radius;
            if (b.x > bounceline && x > 300) {
                if ((b.y > y - height / 2) && (b.y < y + height / 2)) {
                    b.xv = -b.xv;
                    b.x = 2 * bounceline - b.x;
                } else {
                    b.score = true;
                    score++;
                }
            }
        } else {
            int obounceline = x + width + b.radius;
            if (b.x < obounceline && x < 300) {
                if ((b.y > y - height / 2) && (b.y < y + height / 2)) {
                    b.xv = -b.xv;
                    b.x = 2 * obounceline - b.x;
                } else {
                    b.score = true;
                    score++;
                }
            }
        }
    }
}
