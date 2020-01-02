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
public class Car {

private String name;
public Car(String n) {
name = n; }
public Car() {
name = "Generic";
}
public String getName() 
{ return name; }


public void changeName(String x) 
{ name = x; }
public Car testQuestion(Garage one, Garage two, Car three)
{
    Car four = two.getCar(); four.changeName("Doc"); 
    one.setCar(four); 
    System.out.println(one.getName()); 
    System.out.println(two.getName()); 
    System.out.println(four.getName()); 
    three.changeName("Mack"); 
    one.setCar(three);
    two = one; 
    System.out.println(one.getName()); 
    System.out.println(two.getName()); 
    System.out.println(four.getName());
    return two.getCar();
    
}
}

