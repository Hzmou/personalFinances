package personalfinances;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class personalFinances {

    public transaction[] tr1; // An array of transactions objects.

    public int recordsCount; // a counter that keeeps track of the number of records that were processed.

    public void readFile(String fileName) {

        try { // try to connect to a physical file
            Scanner inFile = new Scanner(new FileReader(fileName));
            if (!inFile.hasNext()) {
                System.err.println("file " + fileName + " is empty.");
                System.exit(3);
            }

            tr1 = new transaction[250]; // this will contain an array of objects transactions.
            inFile.useDelimiter("[/, \t\n\r]+");

            // we declare an array that will only contain column headers.

            String[] headers = new String[6];

            // now we have to populate this array with the headers.

            for (int i = 0; i < headers.length; i++) {

                headers[i] = inFile.next();

            }

            while (inFile.hasNext()) {

                int month = inFile.nextInt();
                int day = inFile.nextInt();
                int year = inFile.nextInt();

                Date date = new Date(month, day, year);

                String description = inFile.next().replaceAll("_", " ");
                double amount = inFile.nextDouble();
                String type = inFile.next().replaceAll("_", " ");
                String category = inFile.next().replaceAll("_", " ");

                tr1[recordsCount] = new transaction(recordsCount, date, description, amount, type, category);

                recordsCount++;

            }

            inFile.close();

        }

        catch (FileNotFoundException ex) {
            System.err.println("File not found.");
            System.exit(2);
        } catch (InputMismatchException ex) {
            System.err.println("tried to read the wrong data type.");
            System.exit(4);
        }

    }

    public void swap(int i, int j) {

        transaction temp = tr1[i];

        tr1[i] = tr1[j];

        tr1[j] = temp;

    }

    /*
     * This a selection sort algorithm that sorts by category.
     */

    public void sortByCategory() {
        int i, j, min;

        for (j = 0; j < recordsCount; j++) {

            min = j;

            for (i = j + 1; i < recordsCount; i++) {

                if (tr1[i].getCategory().compareTo(tr1[min].getCategory()) < 0) {

                    min = i;

                }

            }

            if (!(tr1[min].getCategory().equals(tr1[j].getCategory()))) {

                swap(j, min);

            }

        }

    }

    /*
     * This method sorts records by checknumbers
     */
    public void sortByCheckNumber() {

        int i, j, min;

        for (j = 0; j < recordsCount; j++) {

            min = j;

            for (i = j + 1; i < recordsCount; i++) {

                if (tr1[i].getCheckNumber().compareTo(tr1[min].getCheckNumber()) < 0) {

                    min = i;

                }

            }

            if (!(tr1[i].getCheckNumber().equals(tr1[min].getCheckNumber()))) {

                swap(j, min);
            }

        }

    }

    /*
     * This function prints all the transactions by category, it will use the sort
     * by
     * category mathod above.
     * Returns a formatted String with all the transactions by category.
     */

    public String printCategorySubTotals() {

        sortByCategory();

        StringBuilder str = new StringBuilder();
        double total = 0.0;
        double debitTotal = 0.0;
        double creditTotal = 0.0;

        // printing out the headers of the bill:

        str.append(String.format("%7s %-10s %-30s %15s\n",
                "Check#", "Date", "Description", "Amount"));

        /*
         * Printing the total by category, and the total of all transactions.
         */
        for (int i = 0; i < recordsCount - 1; i++) {

            if (tr1[i].getCategory().equals(tr1[i + 1].getCategory())) {

                total += tr1[i].getAmount();

                str.append(String.format("%-87s\n", tr1[i]));

            } else {
                str.append(String.format("%-87s\n", tr1[i]));
                total += tr1[i].getAmount();
                str.append(String.format(
                        "Subtotal for category %-13s%,30.2f\n\n",
                        tr1[i].getCategory(),
                        total));

                total = 0.0;

            }

            if (tr1[i].getType().equals("debit")) {
                debitTotal += tr1[i].getAmount();

            } else if (tr1[i].getType().equals("credit")) {
                creditTotal += tr1[i].getAmount();

            }

        }

        str.append(String.format(
                "Total Debits:%,15.2f\tTotalCredits:%,15.2f",
                debitTotal, creditTotal));
        return str.toString();

    }

    /*
     * This method returns a String that prints the register.
     */

    public String printRegister(double balance) {

        // first we sort the array by check numbers so we can print accordinly.

        sortByCheckNumber();

        StringBuilder str = new StringBuilder();

        double savings = 0.0;
        double adjustedBalance = balance;

        // printing the column headlines for the register receipt.

        str.append(String.format("\n%7s %-10s %-30s %15s %-7s %-13s %8s\n",
                "Check#", "Date", "Description", "Amount", "Type",
                "Category", "Balance Forward"));

        str.append(String.format("%,102.2f\n", balance));

        for (int i = 0; i < recordsCount; i++) {

            if (tr1[i].getType().equals("debit")) {

                balance -= tr1[i].getAmount();

            } else if (tr1[i].getType().equals("credit")) {
                double savingPerct = tr1[i].getAmount() * 0.1;
                savings += savingPerct;
                balance += tr1[i].getAmount() - savingPerct;

            }

            str.append(String.format("%-87s%,15.2f\n",
                    tr1[i], balance));

        }

        if (balance > adjustedBalance) {
            savings += balance - adjustedBalance;
            balance -= balance - adjustedBalance;

        }

        str.append(String.format("Savings Balance\tAdj Checking Balance\n"
                + "%,12.2f%,27.2f", savings, balance));

        return str.toString();
    }

    public void run(String[] args) {

        readFile(args[0]); // first file name
        System.out.println(printCategorySubTotals());
        System.out.println(printRegister(Double.parseDouble(args[1])));

    }

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Usage prog inputFile balance");
            System.exit(1);
        }

        personalFinances pf = new personalFinances();

        pf.run(args);

    }
}
