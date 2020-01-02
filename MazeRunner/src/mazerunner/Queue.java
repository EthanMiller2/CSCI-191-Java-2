/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

/**
 *
 * @author ethanmiller
 */
public class Queue extends cBase {

    public Point get() {
        return pointlist.remove(pointlist.size() - 1);
    }

    public String toString() {
        return "Queue of: " + pointlist.size() + "Strings";
    }
}
