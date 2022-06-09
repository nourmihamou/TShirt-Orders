PROJECT TITLE: TShirt Orders
PURPOSE OF PROJECT: This program creates a t-shirt order per customer with a limit of five t-shirt orders per customer. Each t-shirt object has to be added to the customer by calling the addTShirtOrder() method.

VERSION or DATE: May 13, 2021

AUTHORS: Nour Mihamou and Lulama Nyembe

USER INSTRUCTIONS: The user will create a new t-shirt order object with the following parameters:
	category BOYS, GIRLS, MENS, WOMENS
	size XSMALL, SMALL, MEDIUM, LARGE, XLARGE
	color GREEN, GOLD, WHITE, BLACK, MULTI
	quantity The number of t-shirts of this type ordered >= 0.  If not >= 0, is set to 0.
Be sure to remember that since each of these parameters (except the quantity) are enumerated types, include the type followed by a period and then the variable in all caps (I.e. Category.BOYS, Size.XSMALL, Color.GOLD, 4).
Once a t-shirt object has been created, the user may create a customer order object, and then adding the corresponding t-shirt order objects to their corresponding customers. This is done through right-clicking on the customer object and selecting addTShirtOrder(TShirtOrder order), and typing in the name of the t-shirt order object. 



