public class Burger implements FoodItem {
    private String description = "Burger";
    private double cost = 150.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }

}
