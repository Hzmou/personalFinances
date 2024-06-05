
/*
 * Project for pet store.  program to calculate the total pay of an employee at a pet store. 
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class petStore {
    public static String firstName;
    public static String lastName;
    public static double basePay;
    public static double numHours;
    public static double comm;
    public static int numAnimalsSold;
    public static double grossPay;
    public static double netPay;
    public static double commRt;
    public static double totalSales;
    public static double longBonus;
    private static String bonusStatus;
    private static double numYears;
    private static int bonusCat;

    public static void prompt() {
          Scanner input = new Scanner(System.in);
          

          

          System.out.println("Enter your First Name: ");
          firstName = input.next();
          System.out.println("Enter your last Name: ");
          lastName = input.next();
          System.out.println("Enter the number of hours worked this week: ");
          numHours = input.nextDouble();
          System.out.println("Enter the number of animals sold: ");
          numAnimalsSold = input.nextInt();
          System.out.print("Enter the total sales amount of all animals sold: $");
          totalSales = input.nextDouble();
          System.out.println("Enter the number of years worked at the pet store: ");
          numYears = input.nextDouble();

        
        input.close();
          
    }

    public static void calculateCommission() {

        if (numAnimalsSold <= 10) {

            commRt = 0.07;
            comm = totalSales * commRt;

        } else if (numAnimalsSold > 10 && numAnimalsSold <= 20) {

            commRt = 0.10;
            comm = totalSales * commRt;

        } else if (numAnimalsSold > 20 && numAnimalsSold <= 30) {

            commRt = 0.15;
            comm = totalSales * commRt;

        } else if (numAnimalsSold > 30) {
            commRt = 0.18;
            comm = totalSales * commRt;

        }

    }

    public static void grossPay() {
        if (numHours >= 35) {
            basePay = 175.00;

        } else if (numHours < 35) {
            basePay = 0.0;
        }

        grossPay = comm + basePay;
        
    }

    public static void bonuscategory() {

        if (numYears >= 10) {

            bonusCat = 3;

        } else if (numYears >= 7) {
            bonusCat = 2;

        } else if (numYears >= 4) {
            bonusCat = 1;

        } else {
            bonusCat = 0;
        }

    }

    public static void longBonus() {

        switch (bonusCat) {

            case 0:

                longBonus = 0.00;
                bonusStatus = "None";
                break;

            case 1:
                longBonus = 30.00;
                bonusStatus = "Bronze Status";
                break;
            case 2:
                longBonus = 45.00;
                bonusStatus = "Silver Status";
                break;
            case 3:
                longBonus = 60.00;
                bonusStatus = "Gold Status";
                break;

        }
    }

    public static void netPay() {

        netPay = grossPay + longBonus;
        

    }

    public static void printRegister() {

        StringBuffer sbs = new StringBuffer();
        DecimalFormat df = new DecimalFormat("0.00");
        sbs.append("Full Name: ").append(firstName+ " "+lastName).append("\n");
        sbs.append("Number of hours worked: "+numHours).append("\n");
        sbs.append("Number of Animals Sold: "+numAnimalsSold).append("\n");
        sbs.append("Total Sales Amount for all animal sold:$ "+df.format(totalSales)).append("\n");
        sbs.append("Amount of commission: $"+df.format(comm)).append("\n");
        sbs.append("Bonus Status: "+bonusStatus).append("\n");
        sbs.append("Gross Pay: $"+df.format(grossPay)).append("\n");
        sbs.append("Bonus Amount: $"+longBonus).append("\n");
        sbs.append("Net Pay: $"+df.format(netPay)).append("\n");
        System.out.println(sbs.toString());
    }

    public static void main(String[] args) {

       prompt();
       calculateCommission();
       grossPay();
       bonuscategory();
       longBonus();
       netPay();
       printRegister();

        
    }
}
