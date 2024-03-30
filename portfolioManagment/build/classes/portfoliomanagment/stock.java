
package portfoliomanagment;

public class stock {

  private String name;
  private double quotes[];
  private double lowPrice;
  private double highPrice;
  private double netChange;
  private double averagePrice;
  private double standDiv;
  private double longestupWardTrend;
  private static double bestGrowthRate;
  private double bestPerRate;

  /*
   * Default constructor for the stock class, it receives a name and the array of
   * quotes.
   */
  public stock(String name, double quotes[]) {

    this.name = name;
    this.quotes = quotes;

  }

  /*
   * 
   * Function for finding the minimum element of the quotes array.
   * 
   * @author Hamza.
   */
  public void calcMin() {

    lowPrice = quotes[0];

    for (int i = 0; i < quotes.length; i++) {

      if (lowPrice > quotes[i]) {
        lowPrice = quotes[i];
      }

    }
  }

  /*
   * Function for finding the max elements in the prices array.
   * 
   * @author Hamza
   */

  public void findMax() {

    highPrice = quotes[0];

    for (int i = 0; i < quotes.length; i++) {

      if (highPrice < quotes[i]) {
        highPrice = quotes[i];
      }

    }
  }

  public void netChange() {

    netChange = quotes[quotes.length - 1] - quotes[0];

  }

  /*
   * This function calculates the Average price on the prices array.
   */
  public void findAverage() {

    double sum = 0.0;
    averagePrice = 0.0;

    // finding the sum first so we can find the average.

    for (int i = 0; i < quotes.length; i++) {

      sum = sum + quotes[i];
    }

    averagePrice = sum / quotes.length - 1;

  }

  public void standDiv() {

    double diff = 0.0;
    double temp = 0.0;

    for (int i = 0; i < quotes.length; i++) {

      diff = Math.pow(quotes[i] - averagePrice, 2);

      temp += diff;
    }

    standDiv = Math.sqrt(temp / quotes.length - 1);

  }

  /*
   * This function keep track of the incerease of the stock prices.
   * 
   */
  public void longestupWardTrend() {

    int upwardCount = 0;
    int k = 0;

    for (int i = 0; i < quotes.length; i++) {

      if (quotes[i] < quotes[i - 1]) {

        upwardCount++;

      } else {

        k = upwardCount;
        upwardCount = 0;

      }

      if (k > longestupWardTrend) {

        longestupWardTrend = k;

      }

    }

    if (upwardCount > longestupWardTrend) {

      longestupWardTrend = upwardCount;

    }

  }

  /*
   * This method calculates the best upward trend growth. we calculate upward
   * trend growth between
   * each price increase and then sort trough the rate and select the highest one.
   * 
   */

  public void bestupwardTrendRate() {

      double maxSoFar=0.0;

      for(int i=0; i<quotes.length;i++){

        if(quotes[i] < quotes[i - 1]){
           
           double max = (quotes[i-1] - quotes[i])/i - (i-1);

             if(max > maxSoFar){

              maxSoFar = max;

             }
          



        }

      }


      bestGrowthRate = maxSoFar;

  }




  public void bestPerRate() {
    double a[] = new double[10];

    bestPerRate = a[0];

    for (int i = 1; i < quotes.length; i++) {

        bestPerRate = quotes[i] / quotes[i - 1];
        a[i - 1] = bestPerRate;

        if (i == quotes.length - 1) {
            a[i] = bestPerRate;
        }
    }
    for (int b = 0; b < a.length; b++) {
        if (a[b] >= bestPerRate) {
            bestPerRate = a[b];
        }
    }
}

  @Override
  public String toString() {

    StringBuilder str = new StringBuilder();

    str.append(String.format("%-20s", name));
    calcMin();
    findMax();
    findAverage();
    str.append(String.format("%8.2f", lowPrice));
    str.append(String.format("%8.2f", highPrice));
    netChange();
    str.append(String.format("%8.2f", netChange));
    str.append(String.format("%8.2f", averagePrice));

    standDiv();
    str.append(String.format("%7.2f", standDiv));
    longestupWardTrend();
    str.append(String.format("%7.2f", longestupWardTrend));

    if (longestupWardTrend == 0.0) {
        str.append(String.format("%11s", "n/a"));

    } else {
       bestupwardTrendRate();
        str.append(String.format("%11.2f", bestGrowthRate));
    }

    return str.toString();
  }

  public static void main(String[] args) {
    double[] quotes = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
    String name = "A";
    stock s = new stock(name, quotes);
    System.out.println(s);
    System.out.println("The best growth rate for these prices are: " + bestGrowthRate);

  }

}