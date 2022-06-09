import java.util.ArrayList;
import java.util.Random;

/**
 * This program is used to test the implementation of
 * CSIS-120, Project 5.
 * 
 * DO NOT ALTER THIS CLASS.
 * 
 * @author Prof. White
 * @version Spring 2021
 */
public class TestDriver
{
    public static void main(String[] args)
    {
        int score = 0;
        int maxScore = 0;

        CustomerOrder custOrder = new CustomerOrder("Pauline", "White", true);

        //test the results of executing the constructor
        if(custOrder.getFirstName().equals("Pauline")){
            score++;
        }
        if(custOrder.getLastName().equals("White")){
            score++;
        }
        if(custOrder.isPaid()){
            score++;
        }
        if(custOrder.toString().equals("White, Pauline\nPaid:  YES\n\n")){
            score++;
        }
        maxScore += 4;

        //Create a tshirt order and test the results of executing the constructor
        TShirtOrder order = new TShirtOrder(Category.BOYS, Size.XSMALL, Color.GREEN, 1);
        if(order.getOrderNumber() > 0){
            score++;
        }
        if(order.getCategory().equals("Boys")){
            score++;
        }
        if(order.getSize().equals("Extra Small")) {
            score++;
        }
        if(order.getColor().equals("Green")){
            score++;
        }
        if(order.getQuantity() == 1){
            score++;
        }
        if(order.toString().equals("Order Number:  1\n1 Boys Extra Small Green")){
            score++;
        }
        if(custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore += 7;

        //Alter the order and test the results
        order.setCategory(Category.GIRLS);
        order.setSize(Size.SMALL);
        order.setColor(Color.GOLD);
        order.setQuantity(5);
        if(order.getCategory().equals("Girls")){
            score++;
        }
        if(order.getSize().equals("Small")) {
            score++;
        }
        if(order.getColor().equals("Gold")){
            score++;
        }
        if(order.getQuantity() == 5){
            score++;
        }
        if(order.toString().equals("Order Number:  1\n5 Girls Small Gold")){
            score++;
        }
        maxScore += 5;

        //Add a second order for this customer
        int orderNum  = order.getOrderNumber(); //1 
        order = new TShirtOrder(Category.MENS, Size.MEDIUM, Color.WHITE, 1);
         if(order.getOrderNumber() == orderNum + 1){ //2
            score++; 
        }
        if(order.getCategory().equals("Mens")){
            score++;
        }
        if(order.getSize().equals("Medium")) {
            score++;
        }
        if(order.getColor().equals("White")){
            score++;
        }
        if(order.getQuantity() == 1){
            score++;
        }
        if(order.toString().equals("Order Number:  2\n1 Mens Medium White")){
            score++;
        }
        if(custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore += 7;

        //Add a third order for this customer
        orderNum  = order.getOrderNumber();
        order = new TShirtOrder(Category.WOMENS, Size.LARGE, Color.BLACK, 1);
        if(order.getOrderNumber() == orderNum + 1){
            score++;
        }
        if(order.getCategory().equals("Womens")){
            score++;
        }
        if(order.getSize().equals("Large")) {
            score++;
        }
        if(order.getColor().equals("Black")){
            score++;
        }
        if(order.getQuantity() == 1){
            score++;
        }
        if(order.toString().equals("Order Number:  3\n1 Womens Large Black")){
            score++;
        }
        if(custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore += 7;

        //Add a fourth order for this customer, with a quantity < 0 --> should be set to 0
        orderNum  = order.getOrderNumber();
        order = new TShirtOrder(Category.MENS, Size.XLARGE, Color.MULTI, -1);
        if(order.getOrderNumber() == orderNum + 1){
            score++;
        }
        if(order.getCategory().equals("Mens")){
            score++;
        }
        if(order.getSize().equals("Extra Large")) {
            score++;
        }
        if(order.getColor().equals("Multi")){
            score++;
        }
        if(order.getQuantity() == 0){
            score++;
        }
        if(order.toString().equals("Order Number:  4\n0 Mens Extra Large Multi")){
            score++;
        }
        if(custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore += 7;

        //Add 1 more orders for this customer to reach the max of 5
        order = new TShirtOrder(Category.MENS, Size.XLARGE, Color.BLACK, 5);
        if(custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore += 1;

        //Attempt to add an additional order
        if(!custOrder.addTShirtOrder(order)){
            score++;
        }
        maxScore++;

        //Attempt to change the quantity of the last order to < 0, should be set to 0
        order.setQuantity(-1);
        if(order.getQuantity() == 0){
            score++;
        }
        maxScore++;

        //test remainder of CustomerOrder class
        custOrder.setPaid(false);
        if(!custOrder.isPaid()){
            score++;
        }
        custOrder.setPaid(true);
        if(custOrder.isPaid()){
            score++;
        }
        maxScore += 2;

        if(custOrder.toString().equals("White, Pauline\nPaid:  YES\n\nOrder Number:  1\n5 Girls Small Gold\n\n" +
            "Order Number:  2\n1 Mens Medium White\n\nOrder Number:  3\n1 Womens Large Black\n\nOrder Number:  4\n" +
            "0 Mens Extra Large Multi\n\nOrder Number:  5\n0 Mens Extra Large Black\n\n")){
            score++;
        }
        custOrder.removeTShirtOrder(1);
        if(custOrder.toString().equals("White, Pauline\nPaid:  YES\n\nOrder Number:  2\n1 Mens Medium White\n\n" +
            "Order Number:  3\n1 Womens Large Black\n\nOrder Number:  4\n0 Mens Extra Large Multi\n\n" +
            "Order Number:  5\n0 Mens Extra Large Black\n\n")){
            score++;
        }
        custOrder.removeTShirtOrder(5);
        if(custOrder.toString().equals("White, Pauline\nPaid:  YES\n\nOrder Number:  2\n1 Mens Medium White\n\n" +
            "Order Number:  3\n1 Womens Large Black\n\nOrder Number:  4\n0 Mens Extra Large Multi\n\n")){
            score++;
        }
        custOrder.removeTShirtOrder(3);
        if(custOrder.toString().equals("White, Pauline\nPaid:  YES\n\nOrder Number:  2\n1 Mens Medium White\n\n" +
            "Order Number:  4\n0 Mens Extra Large Multi\n\n")){
            score++;
        }
        maxScore += 4;

        if(custOrder.changeCategory(2, Category.WOMENS)){
            score++;
        }
        if(!custOrder.changeCategory(10, Category.WOMENS)){
            score++;
        }
        if(custOrder.changeSize(2, Size.SMALL)){
            score++;
        }
        if(!custOrder.changeSize(10, Size.SMALL)){
            score++;
        }
        if(custOrder.changeColor(2, Color.BLACK)){
            score++;
        }
        if(!custOrder.changeColor(10, Color.BLACK)){
            score++;
        }
        if(custOrder.changeQuantity(2, 10)){
            score++;
        }
        if(!custOrder.changeQuantity(10, 10)){
            score++;
        }
        maxScore += 8;

        //Print the results of the tests
        if(score == maxScore){
            System.out.println("Congratulations, all tests complete!");
        } else {
            System.out.println(score + " out of " + maxScore + "\nKeep going!");
        }
    }
}
