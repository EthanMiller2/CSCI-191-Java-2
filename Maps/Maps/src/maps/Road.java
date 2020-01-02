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
public class Road {
   public City startCity;
   public City endCity;
   public int length;
   public int travelTime;
   public String name;
   public Road(String name, String startCity, String endCity,int length,int travelTime)
   {
       this.name = name;
       this.startCity = City.findCity(startCity);
       this.endCity = City.findCity(endCity);
       this.length = length;
       this.travelTime = travelTime;
       this.startCity.roads.add(this);
   }
   @Override
   public String toString()
   {
     
      return "Road Name: " + name + " goes to " + endCity.name + " (" + length + " miles, " +  + travelTime + " minutes)"; 
   }
    
}
