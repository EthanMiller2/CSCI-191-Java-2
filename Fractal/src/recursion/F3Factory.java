/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author ethanmiller
 */
public class F3Factory implements SettingsFactory {

    public Settings getSettings(double t, double other) {
        
        return new F3(t, other); 
   
    }
    
}
