
/**
 * CSIS-120, Project 5
 * 
 * This class represents the t-shirt orders for one customer.
 * A customer may have a maximum of MAX_ORDERS orders.
 *
 * COMPLETE THIS CLASS ACCORDING TO ITS METHOD COMMENTS.
 * 
 * @author Nour Mihamou and Lulama Nyembe 
 * @version 05/13/2021
 */
public class CustomerOrder
{
    private String firstName;
    private String lastName;
    private boolean paid;
    private TShirtOrder[] orders;

    //The index of the next place in the TShirtOrder array that
    //a new order can be placed.  If nextIndex >= orders.length,
    //no more orders can be accepted.
    private int nextIndex;

    //The maximum number of orders that can be placed for this
    //customer.
    public static final int MAX_ORDERS = 5;

    /**
     * Constructs a new customer order.
     * 
     * @param fName The first name of the customer.
     * @param lName The last name of the customer.
     * @param paid True if the customer paid for the order and
     * false otherwise.
     */
    public CustomerOrder(String fName, String lName, boolean paid)
    {
        firstName = fName;
        lastName = lName;
        this.paid = paid;
        orders = new TShirtOrder[MAX_ORDERS];
        nextIndex = 0;
    }

    /**
     * Returns the first name of the customer.
     * 
     * @return The first name of the customer.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the last name of the customer.
     * 
     * @return The last name of the customer.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns true if the customer paid for this order
     * and false otherwise.
     * 
     * @return True if the customer paid for this order
     * and false otherwise.
     */
    public boolean isPaid()
    {
        boolean paidFor = false;

        if(paid == true){
            paidFor = true;
        }

        return paidFor;
    }

    /**
     * Returns the array of t-shirt orders for this customer.
     * 
     * @return The array of t-shirt orders for this customer.
     */
    public TShirtOrder[] getTShirtOrders()
    {
        return orders;
    }

    /**
     * Updates the paid status to the input value.
     * 
     * @param paid The new pay status.
     */
    public void setPaid(boolean paid)
    {
        this.paid = paid;
    }

    /**
     * Adds the input t-shirt order for this customer
     * as long as the customer had not met the maximum
     * allowable orders.  If the customer has met the
     * maximum allowable orders, the new order is not
     * added.
     * 
     * @param order The new t-shirt order to be added.
     * @return True if the order is added and false otherwise.
     */
    public boolean addTShirtOrder(TShirtOrder order)
    {
        boolean isAdded = false;

        while(!isAdded && nextIndex < orders.length){
            if(orders[nextIndex] == null){
                orders[nextIndex] = order;
                isAdded = true;
            }
            nextIndex++;
        }

        return isAdded;
    }

    /**
     * Removes the t-shirt order matching the input order number
     * and returns true.  If no such order number exists,
     * returns false.
     * 
     * Post condition:  The orders in stored in successive
     * locations in the orders array.  E.g., if the orders
     * in the array were 1, 2, 3, null, null (the customer
     * can still place 2 orders), then removeTShirtOrder(2)
     * would result in 1, 3, null, null, null.
     * 
     * USE THE getIndex and shiftOrders METHODs DEFINED AT THE 
     * END OF THIS CLASS TO HELP YOU.
     * 
     * @param orderNumber The order number to be removed.
     * @return True if the order number is found and removed
     * and false otherwise.
     */
    public boolean removeTShirtOrder(int orderNumber)
    {
        boolean isRemoved = false;

        while(!isRemoved && orders != null){
            shiftOrders(getIndex(orderNumber));
            isRemoved = true;
        }

        return isRemoved;
    }

    /**
     * Updates the category for a particular order.
     * 
     * USE THE getIndex METHOD DEFINED AT THE END OF THIS
     * CLASS TO HELP YOU.
     * 
     * @param orderNumber  The order number.
     * @param newCategory  The new value for the category.
     * @return True if the order number is found and the category is
     * updated and false otherwise.
     */
    public boolean changeCategory(int orderNumber, Category newCategory)
    {
        boolean isChanged = false;

        while(!isChanged && orderNumber < orders.length){
            orders[getIndex(orderNumber)].setCategory(newCategory); 
            isChanged = true;
        }

        return isChanged;
    }

    /**
     * Updates the size for a particular order.
     * 
     * USE THE getIndex METHOD DEFINED AT THE END OF THIS
     * CLASS TO HELP YOU.
     * 
     * @param orderNumber  The order number.
     * @param newSize  The new value for the size.
     * @return True if the order number is found and the size is
     * updated and false otherwise.
     */
    public boolean changeSize(int orderNumber, Size newSize)
    {
        boolean isChanged = false;

        while(!isChanged && orderNumber < orders.length){
            orders[getIndex(orderNumber)].setSize(newSize); 
            isChanged = true;
        }

        return isChanged;
    }

    /**
     * Updates the color for a particular order.
     * 
     * USE THE getIndex METHOD DEFINED AT THE END OF THIS
     * CLASS TO HELP YOU.
     * 
     * @param orderNumber  The order number.
     * @param newColor  The new value for the color.
     * @return True if the order number is found and the color is
     * updated and false otherwise.
     */
    public boolean changeColor(int orderNumber, Color newColor)
    {
        boolean isChanged = false;

        while(!isChanged && orderNumber < orders.length){
            orders[getIndex(orderNumber)].setColor(newColor); 
            isChanged = true;
        }

        return isChanged;
    }

    /**
     * Updates the quantity for a particular order.  If the 
     * quantity is less than 0, sets the quantity to 0.
     * 
     * USE THE setQuantity and getIndex METHODS TO HELP YOU.
     * 
     * @param orderNumber  The order number.
     * @param newQuantity  The new value for the quantity.
     * @return True if the order number is found and the quantity is
     * updated and false otherwise.
     */
    public boolean changeQuantity(int orderNumber, int newQuantity)
    {
        boolean isChanged = false;

        while(!isChanged && orderNumber < orders.length){
            orders[getIndex(orderNumber)].setQuantity(newQuantity); 
            isChanged = true;
        }

        return isChanged;
    }

    /**
     * Returns a string representation of this customer's order.
     * 
     * @return a string representation of this customer's order.
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        String paidFor = "";

        if(isPaid() == true){
            paidFor = "YES";
        } else {
            paidFor = "NO";
        }

        String description = lastName + ", " + firstName + "\nPaid:  " + paidFor + "\n\n";

        for(TShirtOrder order : orders){
            if(order != null){
                sb.append(order.toString() + "\n\n");
            }
        }

        return description + sb.toString();
    }

    /**
     * Returns the index of the input orderNumber in the orders array
     * or -1 if no such orderNumber exists.
     * 
     * @return The index of the input orderNumber in the orders array
     * or -1 if no such orderNumber exists.
     */
    private int getIndex(int orderNumber)
    { 
        int indexOfOrder = -1;
        nextIndex = 0;
        boolean orderIndexBool = false;

        while(!orderIndexBool && nextIndex < orders.length){
            int ordersCurrIndex = orders[nextIndex].getOrderNumber();
            if(orders[nextIndex] != null && ordersCurrIndex == orderNumber){
                indexOfOrder = nextIndex;
                orderIndexBool = true;
            }
            nextIndex++;
        }

        return indexOfOrder;
    }

    /**
     * Shifts the elements in the orders array to the left,
     * starting at the input index.  
     * 
     * E.g., if the orders array has values 0, 1, 2, 3, 4, 
     * after shiftOrders(3) is executed, the orders array has 
     * values, 0, 1, 2, 4, null.
     * 
     */
    private void shiftOrders(int index)
    {
        while(index < orders.length - 1 && orders[index] != null && index != -1){
            orders[index] = orders[index + 1];
            index++;
        }

        orders[orders.length - 1] = null;
    }
}
