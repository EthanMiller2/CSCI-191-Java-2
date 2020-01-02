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
abstract class cBase implements Collection {

    public ArrayList<Point> pointlist = new ArrayList<Point>();

    public boolean isEmpty() {
        return pointlist.isEmpty();
    }

    public int size() {
        return pointlist.size();
    }

    public void add(Point p) {
        this.pointlist.add(0, p);
    }

}
