/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

/**
 *
 * @author ethanmiller
 */
public class DistanceMetric implements RoadMetric {

    @Override
    public int getMetric(Road r) {
        return r.length;
    }

}
