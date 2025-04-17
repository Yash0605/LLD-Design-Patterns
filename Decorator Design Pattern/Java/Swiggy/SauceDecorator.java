public class SauceDecorator extends Decorator {
    private String description = "Sauce";
    private double cost;

    public SauceDecorator(FoodItem foodItem, double cost) {
        super(foodItem);
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra " + description;
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + cost;
    }

}
