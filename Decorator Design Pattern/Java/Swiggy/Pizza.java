public class Pizza implements FoodItem {
    private String description = "Pizza";
    private double cost = 200.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }

}
