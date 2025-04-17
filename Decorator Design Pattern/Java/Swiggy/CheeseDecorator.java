public class CheeseDecorator extends Decorator {
    private String description = "Cheese";
    private double cost;

    public CheeseDecorator(FoodItem foodItem, double cost) {
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
