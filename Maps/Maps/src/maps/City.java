/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.ArrayList;

/**
 *
 * @author ethanmiller
 */
public class City {
    public int x;
    public int y;
    String name;
    public ArrayList<Road> roads = new ArrayList<>();
    public static ArrayList<City> cities = new ArrayList<>();
    public City(String name, int x, int y)
    {
     this.name = name;
     this.x = x;
     this.y = y;
     cities.add(this);
    }
    @Override
    public String toString()
    {
      return name + " is at " + "("+ x + "," + y + ")" ; 
    }
    public static City findCity(String cityName)
    {
        for(City c : cities)
        {
            if(c.name.equals(cityName))
                return c;
        }
        return null;
    }
   
}
