/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks_queues;

import java.util.ArrayList;

/**
 *
 * @author ethanmiller
 */
abstract class c_Base implements Collection {

    public ArrayList<String> str = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return str.isEmpty();

    }

    @Override
    public int size() {
        return str.size();
    }

    @Override
    public void add(String s) {
        this.str.add(0, s);
    }
}
