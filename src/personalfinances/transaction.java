import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class transaction {

    public Integer checkNumber;

    public Integer date;

    public String description;

    public double amount;

    public String type;

    public String category;
  
    public transaction[] transactions;


    public int recordNumber;
 





   
    public transaction( Integer checkNumber, Integer date, String description, double amount, String type, String category) {
        this.checkNumber = checkNumber;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public Integer getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }



    
    public String toString(){
        return String.format("%7d %-10s %-30s %15.2f %-7s %s",
                              checkNumber, date.toString(), description,
                              amount, type, category);

}




public  void readFile(String fileName){


    try { // try to connect to a physical file
            Scanner inFile = new Scanner(new FileReader(fileName));
            if(!inFile.hasNext()) {
                System.err.println("file " + fileName + " is empty.");
                System.exit(3);
            }
          
        

            inFile.useDelimiter("[/, \t\n\r]+");

        

            transactions  = new transaction[250]; // this will contain an array of objects transactions. 

            while(inFile.hasNext()){

                date = inFile.nextInt();
                checkNumber = inFile.nextInt();
                description = inFile.next().replace('_', ' ');
 
                amount = inFile.nextDouble();

                type = inFile.next();

                category = inFile.next();


                recordNumber++;


            } 

            System.out.println("Records registered for now: "+recordNumber);


    } 


        
        // catching exceptions handlers:


        catch (FileNotFoundException ex) {
            System.err.println("File not found.");
            System.exit(2);
        }
        catch (InputMismatchException ex) {
            System.err.println("tried to read the wrong data type.");
            System.exit(4);
        } 

}
public  void run(String[] arguments){
   

        readFile(arguments[0]); // first file name
        if (recordNumber > 0) {
            System.out.printf("Store inventory loaded, %d titles in "
                                + "the store.%n", recordNumber);

        }
              

}


public static void main(String[] args){


     if (args.length == 0) {
            System.err.println("usage: prog songfile");
            return;
        }
      
     

       



    

 

    }
}



