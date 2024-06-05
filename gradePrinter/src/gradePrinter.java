import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;

/*
 * This is a simple Java Program that prints Grade for 15 students and prints some statistics about the grades and the class performance. 
 *  Author: Hzmou
 *  
 *
 */



public class gradePrinter {

    public static int[] grades = new int[15];
    public static int[] labels = new int[5];
   

    public static void loadGrades(int[] list)
            throws FileNotFoundException {
        try {

            Scanner ReadFile = new Scanner(new FileReader("data.txt"));
            int tempo , // this is a variable that going to have the number 
                           //that the scanner read.
                    cte = 0; // this is the index of the array list.
            while (ReadFile.hasNext()) {
                tempo = ReadFile.nextInt();
                list[cte] = tempo;  // the element is assigned to the value 
                                 // stored in variable tempo
                cte = cte + 1;   // the index is incremented to +1.

            }
        } catch (FileNotFoundException ex) {
           System.out.println("File not found."); // this is in case the file
                                                  // is not found
           System.exit(1);          
           
        }
    }

    public static void printResults(int[] list) {
        for (int z = 0; z < 5; z++) {
            System.out.printf("%5d", list[z]);
        }
        System.out.println(" ");
        for (int i = 5; i < 10; i++) {

            System.out.printf("%5d", list[i]);
        }
        System.out.println(" ");
        for (int j = 10; j < list.length; j++) {
            System.out.printf("%5d", list[j]);
        }
        System.out.println(" ");

    }

    public static int calcMax(int[] list) {

        int max = list[0];
        for (int i = 0; i < list.length; i++) {

            if (max < list[i]) {
                max = list[i];
            }

        }

        return max;
    }

    public static int calcMin(int[] list) {

        int min = list[0];

        for (int j=0;j< list.length;j++) {

            if (list[j]< min) {
                min = list[j];
            }
        }

        return min;

    }

    public static double calcAverage(int[] list) {
        double average;
        DecimalFormat df = new DecimalFormat("0.00");
        int sum = 0;

        for (int grade : list) {

            sum += grade;

        }

        average = (double) sum / list.length;

        return average;

    }

    public static int calcBelowTarget(int[] list, double target) {
        int counter = 0;
        for (int i=0;i< list.length;i++) {
            if (list[i] < target) {
                counter++;

            }

        }

        return counter;
    }

    public static void calcFrequencies(int[] list, int[] f) {

        for (int i=0; i< list.length;i++) {

            if (list[i] >= 90) {
                f[0]++;
            } else if (list[i] > 80) {
                f[1]++;

            } else if (list[i] >= 70) {
                f[2]++;

            } else if (list[i] >= 60) {
                f[3]++;

            } else if (list[i] < 60) {
                f[4]++;

            }

        }

    }

    public static void printFrequencies(int[] f) {
        for (int i = 0; i < f.length; i++) {

            switch (i) {
                case 0:
                    System.out.print("A's: ");
                    break;
                case 1:
                    System.out.print("B's: ");
                    break;
                case 2:
                    System.out.print("C'S: ");
                    break;
                case 3:
                    System.out.print("D's: ");
                    break;
                case 4:
                    System.out.print("F's: ");
                    break;
            }
            for (int j = 0; j < f[i]; j++) {
                System.out.print("*");
            }
            System.out.println(" ");

        }

    }



    

    public static void main(String[] args) throws FileNotFoundException {

         double average;
         DecimalFormat df = new DecimalFormat("0.00");
         
          loadGrades(grades);
          printResults(grades);

          System.out.println("The maximum grade is: "+calcMax(grades));
          System.out.println("The minimum Grade is: "+calcMin(grades));
          average = calcAverage(grades);
          System.out.println("The class average is: "+df.format(average));
          System.out.println("The number of grades below average: "+calcBelowTarget(grades,calcAverage(grades)));
          calcFrequencies(grades, labels);
          printFrequencies(labels);


        

    }

}
