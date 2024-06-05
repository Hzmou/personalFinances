
import java.text.DecimalFormat;
import java.util.*;

public class stockportfolio {
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static double counter;

    public static void generalElectric() {

        double genEle = 167.33;

        System.out.println("Enter the number of shares from General Electric: " + "\n");

        int GE_numshares = input.nextInt();

        double GE_totalValue = GE_numshares * genEle;
        counter += GE_totalValue;

        System.out.println("Total value of your shares in General Electric in USD: $" + df.format(GE_totalValue));

    }

    public static void tylerTech() {

        double tylerTech = 492.05;
        System.out.println("Enter the number of shares from Tyler technologies: " + "\n");

        int TT_numshares = input.nextInt();

        double TT_totalValue = TT_numshares * tylerTech;
        counter += TT_totalValue;

        System.out.println("Total value of your shares in Tyler technologies in USD:  $" + df.format(TT_totalValue));

    }

    public static void unum() {

        double unum = 52.67;

        System.out.println("Enter the number of shares from Unum: " + "\n");

        int unum_numshares = input.nextInt();

        double unum_totalValue = unum_numshares * unum;
        counter += unum_totalValue;

        System.out.println(
                " Your Total value of your shares in Unum in USD:  $" + df.format(unum_totalValue));

    }

    public static void aplhabet() {
        double alpha = 176.33;
        System.out.println("Enter the number of shares from Google (Alphabet): " + "\n");

        int alpha_numshares = input.nextInt();

        double alpha_totalValue = alpha_numshares * alpha;
        counter += alpha_totalValue;

        System.out.println("Total value of your shares in Google in USD:  $" + df.format(alpha_totalValue));

    }

    public static void meta() {

        double meta = 478.22;
        System.out.println("Enter the number of shares from Meta: " + "\n");

        int meta_numshares = input.nextInt();

        double meta_totalValue = meta_numshares * meta;
        counter += meta_totalValue;

        System.out.println("Total value of your shares in Meta (EX Facebook) in USD:  $" + df.format(meta_totalValue));

    }

    public static void shell() {

        double shell = 70.82;

        System.out.println("Enter the number of shares from Shell: " + "\n");

        int shell_numshares = input.nextInt();

        double shell_totalValue = shell_numshares * shell;

        counter += shell_totalValue;

        System.out.println("Total value of your shares in Shell in USD:  $" + df.format(shell_totalValue));

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        // calling all the methods for all the stocks.
        generalElectric();
        tylerTech();
        unum();
        aplhabet();
        meta();
        shell();
        System.out.println("The total value of your Portfolio in USD:  $" +df.format(counter));
        input.close();
    }

}
