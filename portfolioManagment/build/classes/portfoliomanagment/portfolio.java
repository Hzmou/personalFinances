package portfoliomanagment;

import java.util.ArrayList;

public class portfolio {



  ArrayList<stock> portfolio = new ArrayList<stock>();




  public portfolio(){}

  public portfolio(ArrayList<stock> portfolio){
    

      this.portfolio = portfolio;

  }



  public ArrayList<stock> getStock(){
     return portfolio;

  }
  

  public void addStock(stock a){
    portfolio.add(a);

  }

  public stock stockAt(int j){
    return portfolio.get(j);
  }

      /**
     * Unit test for Portfolio class
     * expected output is below
     * @param args
     */
    public static void main(String[] args){
        portfolio portfolio = new portfolio();
        double [] quotes = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String name = "A";
        portfolio.addStock(new stock(name, quotes));
        name = "B";
        double[] quotes2 = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        portfolio.addStock(new stock(name, quotes2));
        System.out.println(portfolio);
        System.out.println("Expected Output without EC");
        System.out.println("Company                Low    Hi    Net    Ave    Dev  Lng  BestTrRt");
        System.out.println("A                     10.0 100.0   90.0   55.0  28.72    9     10.00");
        System.out.println("B                     10.0 100.0  -90.0   55.0  28.72    0       n/a");
    }
}
