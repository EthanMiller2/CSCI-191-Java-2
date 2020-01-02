/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.util.ArrayList;

/**
 *
 * @author ethanmiller
 */
public class Point {

    public int x;
    public int y;
    public Point p;

    public Point(int x, int y, Point p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

}
