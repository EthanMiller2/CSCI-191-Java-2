/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package references;

/**
 *
 * @author ethanmiller
 */
public class Garage {
Car vehicle;
public Garage(Car t) {
vehicle = t; }
public Car getCar() {
return vehicle; }
public String getName() {
return vehicle.getName();
}

public void setCar(Car x)
{ vehicle = x; }
public void changeName(String x) { vehicle.changeName(x); }

}