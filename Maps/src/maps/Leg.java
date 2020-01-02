/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author ethanmiller
 */

public class Leg {
    public Color c;
    public Graphics g;

    public int total;
    public Road legRoad;
    public Leg next;

    public Leg(int total, Road legRoad, Leg next) {
        this.total = total;
        this.legRoad = legRoad;
        this.next = next;
        
    }
    public void print(){
        System.out.println("Take " + legRoad + "to " + legRoad.endCity);
        if(next != null){
         next.print();
        }
       
    } 
    public boolean samePath(Leg leg) {

        if (leg == null ||leg.legRoad != this.legRoad) {
            return false;
        }
        return (next != null && next.samePath(leg.next) || next == null && leg.next == null);
        
}
    
    public void draw(Graphics2D g, Color c, int width ){
    g.setColor(c);
    g.setStroke(new BasicStroke(width));
    g.draw(new Line2D.Float(legRoad.startCity.x, legRoad.startCity.y, legRoad.endCity.x, legRoad.endCity.y));
    if(next != null){
        next.draw(g, c, width);
    }
}
    

}
