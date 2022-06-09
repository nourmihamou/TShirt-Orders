import java.util.ArrayList;
import java.util.Random;

/**
 * CSIS-120, Project 5
 * 
 * Write a program that creates an ArrayList of customer orders.
 * Add 5 customers, 3 paid and 2 unpaid, to the ArrayList.  
 * -For each customer, add a random number of orders in [1, 5].  *
 * -For each order, the category, size, and color of the t-shirts 
 * should be randomly selected, as well as a random quantity in
 * [1, 24].  
 * -Then, print each customer's orders to the terminal window.  
 * -Finally, print a matrix showing the boys t-shirt order for 
 * all customers with rows of sizes and columns of colors as 
 * shown in the sample program run.
 * 
 * Add any additional private methods you need for
 * good program design.
 * 
 * @author Nour Mihamou and Lulama Nyembe
 * @version 05/14/2021
 */
public class RandomDriver
{
    private static Random rand;
    private static ArrayList<CustomerOrder> cos;

    /**
     * This program behaves as described in the banner comment.
     * 
     * @param No command line arguments required.
     */
    public static void main(String[] args)
    {
        cos = new ArrayList<CustomerOrder>();
        rand = new Random();

        // Add five new customers to the ArrayList
        cos.add(new CustomerOrder("Robert", "Smith", true));
        cos.add(new CustomerOrder("Angela", "Simpson", true));
        cos.add(new CustomerOrder("Tony", "Mucci", true));
        cos.add(new CustomerOrder("Marc", "Anthony", false));
        cos.add(new CustomerOrder("Jackie", "Teller", false));

        for(int i = 0; i < cos.size(); i++){
            //random number 1 to 5
            int order = rand.nextInt(5) + 1;

            for(int j = 0; j < order; j++){
                //get category size color and quantity
                cos.get(i).addTShirtOrder(new TShirtOrder(getCategory(rand.nextInt(4) + 1),
                        getSize(rand.nextInt(4) + 1), getColor(rand.nextInt(4) + 1), rand.nextInt(24) + 1));
            }
        }

        for(int i = 0; i < cos.size(); i++){
            System.out.println(cos.get(i).toString());
            System.out.println("*****************");
        }

        printBoysOrder();
    }

    /**
     * This method takes as input a random integer from 1 to 4 and returns an enumerated type,
     * Category based on the integer.
     * 
     * Category: BOYS, GIRLS, MENS, WOMENS
     * 
     * @param randomInt The random integer from 1 to 4.
     * @return Returns a 
     */
    private static Category getCategory(int randomInt)
    {
        Category cat = null;

        switch(randomInt){
            case 1 : cat = Category.BOYS; 
            break;
            case 2 : cat = Category.GIRLS; 
            break;
            case 3 : cat = Category.MENS; 
            break;
            case 4 : cat = Category.WOMENS; 
            break;
        }

        return cat;
    }

    /**
     * This method takes as input a random integer from 1 to 5 and returns an enumerated type,
     * Size based on the integer.
     * 
     * Category: XSMALL, SMALL, MEDIUM, LARGE, XLARGE
     * 
     * @param randomInt The random integer from 1 to 5.
     * @return Returns a size
     */
    private static Size getSize(int randomInt)
    {
        Size size = null;

        switch(randomInt){
            case 1 : size = Size.XSMALL; 
            break;
            case 2 : size = Size.SMALL; 
            break;
            case 3 : size = Size.MEDIUM; 
            break;
            case 4 : size = Size.LARGE; 
            break;
            case 5 : size = Size.XLARGE; 
            break;
        }

        return size;
    }

    /**
     * This method takes as input a random integer from 1 to 5 and returns an enumerated type,
     * Color based on the integer.
     * 
     * Category: GREEN, GOLD, WHITE, BLACK, MULTI
     * 
     * @param randomInt The random integer from 1 to 5.
     * @return Returns a Color
     */
    private static Color getColor(int randomInt)
    {
        Color color = null;

        switch(randomInt){
            case 1 : color = Color.GREEN; 
            break;
            case 2 : color = Color.GOLD; 
            break;
            case 3 : color = Color.WHITE; 
            break;
            case 4 : color = Color.BLACK; 
            break;
            case 5 : color = Color.MULTI; 
            break;
        }

        return color;
    }

    /**
     * This method prints a row of the array boysTShirts.
     * 
     * @param arr The two-demnsional array.
     * @param size A string of the size.
     * @param row An integer representing the row of the two-dimensional array.
     */
    private static void printRow(int[][] arr, String size, int row)
    {
        System.out.printf("%4s %5d %5d %5d %5d %5d%n",size, arr[row][0], arr[row][1], arr[row][2],
            arr[row][3], arr[row][4]);
    }

    /**
     * This method prints a matrix showing the boys t-shirt order for 
     * all customers with rows of sizes and columns of colors as 
     * shown in the sample program run.
     */
    private static void printBoysOrder()
    {
        int[][] boysTShirts = new int[5][5];

        //rows
        final int XSMALL = 0;
        final int SMALL = 1;
        final int MEDIUM = 2;
        final int LARGE = 3;
        final int XLARGE = 4;

        //cols
        final int GREEN = 0;
        final int GOLD = 1;
        final int WHITE = 2;
        final int BLACK = 3;
        final int MULTI = 4;

        int row = 0;
        int col = 0;

        //for every cust order, if the order is Boys then, what color size and quantity, add that amnt
        //to the array 
        //if category is Boys, then if the size isxsmall then the row is 0, 
        //switch statements
        //if color is green, then column is equal to constance green

        //if this category from this customer's order number is Boys then getcolor getsize getquantity
        //heres my tshirt size what row should that be

        TShirtOrder[] tsArray = new TShirtOrder[5];

        for(int i = 0; i < cos.size(); i++){
            tsArray = cos.get(i).getTShirtOrders();

            for(int j = 0; j < tsArray.length; j++){
                if(tsArray[j] != null){

                    String cate = tsArray[j].getCategory();
                    if(cate.equals("Boys")){                    
                        String size = tsArray[j].getSize();
                        if(size.equals("XSmall")){
                            row = XSMALL;
                        } else if(size.equals("Small")){
                            row = SMALL;
                        } else if (size.equals("Medium")){
                            row = MEDIUM;
                        } else if (size.equals("Large")){
                            row = LARGE;
                        } else {
                            row = XLARGE;
                        } 

                        String color = tsArray[j].getColor();
                        if(color.equals("Green")){
                            col = GREEN;
                        } else if(color.equals("Gold")){
                            col = GOLD;
                        } else if (color.equals("Black")){
                            col = BLACK;
                        } else if (color.equals("White")){
                            col = WHITE;
                        } else {
                            col = MULTI;
                        } 

                        boysTShirts[row][col] += tsArray[j].getQuantity();
                    }
                }
            }
        }

        System.out.println("Boys Order:");
        System.out.println("\tGreen Gold White Black Multi");
        printRow(boysTShirts, "XS", 0);
        printRow(boysTShirts, "S", 1);
        printRow(boysTShirts, "M", 2);
        printRow(boysTShirts, "L", 3);
        printRow(boysTShirts, "XL", 4);
    }
}
