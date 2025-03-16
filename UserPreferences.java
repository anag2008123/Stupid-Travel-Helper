import java.util.List;

public class UserPreferences {
    //Instance Variables
    private double budget;
    private String climate;
    private List<String> activities;

    //Getters and Setters
    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public double getBudget() {
        return budget;
    }

    public String getClimate() {
        return climate;
    }

    public List<String> getActivities() {
        return activities;
    }
}
