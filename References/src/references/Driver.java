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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
//        Person pOne = new Person("First");
//        Person pTwo = new Person("Second");
//        int a = 5;
//        pOne = pTwo.changeName(pTwo, pOne, a); 
//        System.out.println(pOne.getName()); //8 
//        System.out.println(a); //9 
//        System.out.println( pTwo.getName()); //10

//        Daffy quack = new Daffy("funny", 6); 
//        Daffy webbed = new Daffy("silly"); 
//        Daffy beak = quack;
//        quack = quack.testQuestion(beak, webbed, new Daffy("tickly", 2));
//        System.out.println(quack.getFeature()); 
//        System.out.println(webbed.getFeature()); 
//        System.out.println(beak.getFeature()); 
//        System.out.println(beak.num);
        
//        Car tow = new Car( "Mater");
//        Garage radiatorSprings = new Garage(new Car("McQueen"));    
//        Car lizzie = new Car();
//        
//        System.out.println(tow.getName()); //Print statement one 
//        System.out.println(radiatorSprings.getName()); //print statement two 
//        System.out.println(lizzie.getName()); //print statement three
//        
//        radiatorSprings.setCar(tow.testQuestion(radiatorSprings, new Garage(new Car("Sally")), lizzie));
//        System.out.println(tow.getName()); //print statement ten 
//        System.out.println(radiatorSprings.getName()); //print statement eleven
//        System.out.println(lizzie.getName()); //print statement twelve
        
        Band frampton = new Band( "Alive", 6000);
        RecordCompany warner = new RecordCompany(new Band("Devo", 1000)); Band startUp = new Band(30);
        RecordCompany rca = new RecordCompany(warner.getBand());
        System.out.println(frampton.getAlbum()); 
        System.out.println(warner.getAlbum());
        System.out.println(startUp.getAlbum());
//Question 1
//Question 2 //Question 3
        rca = frampton.testQuestion(warner, new RecordCompany(new Band(9)), rca.getBand());
        System.out.println(frampton.getAlbum()); //Question 12 System.out.println(warner.getAlbum()); //Question 13
        System.out.println(startUp.getAlbum()); System.out.println(warner.getBand().count);

    }
    
}
