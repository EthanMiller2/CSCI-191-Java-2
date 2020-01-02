/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks_queues;

/**
 *
 * @author ethanmiller
 */
public class Queue extends c_Base {

    public String get() {
        return str.remove(size() - 1);
    }

    @Override
    public String toString() {
        return "Queue of: " + str.size() + "Strings";
    }
}
