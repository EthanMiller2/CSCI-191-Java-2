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
public interface Collection {
    
    public boolean isEmpty();
    
    public int size();
    
    public void add (Point p);
    
    public Point get();
            
    
}
