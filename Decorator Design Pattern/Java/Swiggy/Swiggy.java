public class Swiggy {
    public static void main(String[] args) {
        FoodItem pizza = new Pizza();
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());

        pizza = new CheeseDecorator(pizza, 50.0);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());

        pizza = new SauceDecorator(pizza, 20.0);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());

        System.out.println("--------------------------------------------------");
        System.out.println("                    Burger");
        System.out.println("--------------------------------------------------");
        // Creating a burger with cheese decorator
        FoodItem burger = new Burger();
        System.out.println("Description: " + burger.getDescription());
        System.out.println("Cost: " + burger.getCost());

        // Using the same decorator for burger, since CheeseDecorator is a decorator and
        // it can return the same type of object
        // as the original object, we can use it for burger as well.
        burger = new CheeseDecorator(burger, 30.0);
        System.out.println("Description: " + burger.getDescription());
        System.out.println("Cost: " + burger.getCost());
    }
}
