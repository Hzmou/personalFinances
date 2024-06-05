package portfoliomanagment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class portfoliomanagment {

    private static portfolio portfolio = new portfolio();


    public static void readFile(String fileName) {

        Scanner inputFile = null;

        try {
            inputFile = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found.");
            System.exit(1);

        }

        if (!inputFile.hasNext()) {

            System.out.println("No data file in the following file " + fileName);
            System.exit(1);

        }

        String[] tokens = null;
        String name;

        while (inputFile.hasNext()) {

            name = inputFile.nextLine();
            String line = inputFile.nextLine();

            tokens = line.split("[ \\s]");

            double prices[] = new double[tokens.length];

            for (int j = 0; j < tokens.length; j++) {
                prices[j] = Double.parseDouble(tokens[j]);
            }

            portfolio.addStock(new stock(name, prices));

        }

    }

    public static void printLabel() {

        // we declare a string builder called str as usual
        StringBuilder str = new StringBuilder();

        str.append(String.format("%-25s", "Company"));
        str.append(String.format("%-9s", "Low"));
        str.append(String.format("%-7s", "Hi"));
        str.append(String.format("%-8s", "Net"));
        str.append(String.format("%-8s", "Ave"));
        str.append(String.format("%-6s", "Dev"));
        str.append(String.format("%-6s", "Lng"));
        str.append(String.format("%-12s", "BestTrRt"));
        str.append(String.format("%-10s", "BestPerRt "));

        System.out.println(str.toString());
    }

    // @SuppressWarnings("empty-statement")
    public static void main(String args[]) {

        if (args.length == 0) {

            System.out.println("NO arguments founded");
            return;

        }

        readFile(args[0]);
        printLabel();

        // this for loop get the stock at X. for every company.
        for (int x = 0; x < portfolio.getStock().size(); x++) {

            System.out.println(portfolio.stockAt(x));
            System.out.print(" ");
        }

       

    }

}
