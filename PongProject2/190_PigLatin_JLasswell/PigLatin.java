/*
 * 190
 * PigLatin
 * PigLatin.java
 * J Lasswell
 */

import java.util.Scanner;

public class PigLatin
{
  public static void main (String [] args)
  {
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Type a word that starts with only one consonant: ");
    String name = scan.nextLine();
    char first = name.charAt(0);
    String remainder = name.substring(1);
    System.out.println("This word in pig latin is " + remainder + first + "ay");
  }
}
