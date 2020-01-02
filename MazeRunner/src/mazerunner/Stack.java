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
public class Stack extends cBase {

    public Point get() {
        return pointlist.remove(0);

    }

    @Override
    public String toString() {
        return "Stack of: " + pointlist.size() + "Strings";
    }

}
