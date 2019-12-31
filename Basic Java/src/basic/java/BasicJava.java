/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.java;

/**
 *
 * @author ethanmiller
 */
public class BasicJava {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //Variables
        double x = 1.5, y = 1 / 4.0, z = 8, j = 100, k = -5, i = 2;
        //Equations
        double equation1 = ((1 / 2.0) * (x) * (Math.pow(y, 2))) + (((z) * (y + k)) / (j - 5));
        double equation2 = Math.sqrt(x * y) - Math.abs(k);
        double equation3 = z % 3;
        //Output
        System.out.println("Formulas: " + equation1 + ", " + equation2 + ", " + equation3);

        //One to Ten 
        System.out.println("OneToTen");
        for (int a = 1; a <= 10; a++) {
            System.out.println(a);
        }

        //One To Ten Spaced
        System.out.println("OneToTenSpaced");
        for (int a = 1; a <= 10; a++) {
            if (a <= 9) {
                System.out.print(a + " ");
            } else {
                System.out.println(a);
            }
        }

        //One To Ten Comma 
        System.out.println("OneToTenComma");
        for (int a = 1; a <= 10; a++) {
            if (a <= 9) {
                System.out.print(a + ", ");
            } else {
                System.out.println(a);
            }
        }

        //One to Fifty
        System.out.println("OneToFifty");
        for (int a = 1; a <= 50; a++) {
            if (a % 2 == 0 || a % 3 == 0 || a % 5 == 0 || a % 7 == 0); else {
                System.out.println(a);
            }
        }

        //Grid
        System.out.println("Grid");
        for (int a = 1; a <= 7; a++) {
            for (int b = 1; b <= 7; b++) {
                System.out.print("(" + a + "," + " " + b + ")");
                if (b == 7) {
                    System.out.println("");
                }
            }
        }

        //Triangle
        System.out.println("Triangle");
        for (int a = 1; a <= 7; a++) {
            for (int b = a; b <= 7; b++) {
                System.out.print("(" + a + "," + " " + b + ")");
                if (b == 7) {
                    System.out.println("");
                }
            }
        }

        //Search
        System.out.println("Search");
        int temp = 0;
        while (temp * temp - 6 * temp - 7 != 0) {
            temp++;
        }
        System.out.println(temp);

        //Search 2
        System.out.println("Search2");
        int count = 0;
        for (int d = 0; d <= 10; d++) {
            for (int e = 0; e <= 10; e++) {
                if (d * d + e * e - 12 * d - 10 * e + 36 == 0) {
                    count++;
                    System.out.println("(" + d + ", " + e + ")");
                }
                if (count == 3) {
                    break;
                }
            }
            if (count == 3) {
                break;
            }
        }

    }
}
