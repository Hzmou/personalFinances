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
     *  This a selection sort algorithm that sorts by category. 
     */

    public void sortByCategory() {
        int i, j, min;
    


        for(j=0; j<recordsCount;j++){



        }



    }

    public void run(String[] args) {

        readFile(args[0]); // first file name
        if (recordsCount > 0) {
            System.out.printf("Store inventory loaded, %d titles in "
                    + "the store.%n", recordsCount);
        }
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
