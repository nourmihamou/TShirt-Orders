/**
 * CSIS-120 Project 5
 * This class represents one t-shirt order.
 *
 * COMPLETE THIS CLASS ACCORDING TO ITS METHOD COMMENTS.
 * 
 * @author Nour Mihamou and Lulama Nyembe
 * @version 05/13/2021
 */
public class TShirtOrder
{
    private static int nextOrderNumber = 0;
    private int orderNumber;
    private Category category; 
    private Size size;
    private Color color;
    private int quantity;

    /**
     * Constructs a new t-shirt order.  The quantity must be >= 0 or
     * is set to 0.  Sets the order number to the next order number 
     * in the sequence.
     * 
     * @param category BOYS, GIRLS, MENS, WOMENS
     * @param size XSMALL, SMALL, MEDIUM, LARGE, XLARGE
     * @param color GREEN, GOLD, WHITE, BLACK, MULTI
     * @param quantity The number of t-shirts of this type ordered >= 0.  If
     * not >= 0, is set to 0.
     */
    public TShirtOrder(Category category, Size size, Color color, int quantity)
    {
        this.category = category;
        this.size = size;
        this.color = color;
        
        if(quantity >= 0){
            this.quantity = quantity;
        } else{
            this.quantity = 0;
        }
        
        nextOrderNumber += 1;
        orderNumber = nextOrderNumber;
    }

    /**
     * Returns the order number.
     * 
     * @return The order number.
     */
    public int getOrderNumber()
    { 
        return orderNumber;
    }

    /**
     * Returns the category as a string.
     * 
     * @return The category as a string.
     */
    public String getCategory()
    {
        String catString = "";
        
        switch(category){
            case BOYS: catString = "Boys";
                    break;
            case GIRLS: catString = "Girls";
                    break;
            case MENS: catString = "Mens";
                    break;
            case WOMENS: catString = "Womens";
                    break;
        }
        
        return catString;
    }

    /**
     * Returns the size as a string.
     * 
     * @return The size as a string.
     */
    public String getSize()
    {
        String sizeString = "";
        
        switch(size){
            case XSMALL: sizeString = "Extra Small";
                    break;
            case SMALL: sizeString = "Small";
                    break;
            case MEDIUM: sizeString = "Medium";
                    break;
            case LARGE: sizeString = "Large";
                    break;
            case XLARGE: sizeString = "Extra Large";
                    break;
        }
        
        return sizeString;
    }

    /**
     * Returns the color as a string.
     * 
     * @return The color as a string.
     */
    public String getColor() 
    {
        String colorString = "";
        
        switch(color){
            case GREEN: colorString = "Green";
                    break;
            case GOLD: colorString = "Gold";
                    break;
            case WHITE: colorString = "White";
                    break;
            case BLACK: colorString = "Black";
                    break;
            case MULTI: colorString = "Multi";
                    break;
        }
        
        return colorString;
    }

    /**
     * Returns the quantity ordered.
     * 
     * @return The quantity ordered.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Changes the category to the input category.
     * 
     * @param newCategory  The new category for this order.
     */
    public void setCategory(Category newCategory)
    {
        this.category = newCategory;
    }

    /**
     * Changes the size to the input size.
     * 
     * @param  newSize The new size for this order.
     */
    public void setSize(Size newSize)
    {
        this.size = newSize;
    }

    /**
     * Changes the color to the input color.
     * 
     * @param newColor The new color for this order.
     */
    public void setColor(Color newColor)
    {
        this.color = newColor;
    }

    /**
     * Changes the quantity for this order to the input
     * quantity.  If the input quantity is < 0, changes
     * the quantity for this order to 0.
     * 
     * @param quantity The new quantity for this order.
     */
    public void setQuantity(int quantity)
    {
        if(quantity >= 0){
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    /**
     * Returns a string representation of this order.
     * 
     * @param Returns a string representation of this order.
     */
    public String toString()
    {
        return "Order Number:  " + getOrderNumber() + "\n" + quantity + " " + getCategory() 
        + " " + getSize() + " " + getColor();
    }
}
