import java.util.ArrayList;

public class Destination {
    //Instance Variables 
    private String name;
    private String country;
    private String famousFoods;
    private String culture;
    private String history;
    private ArrayList<String> topAttractions;
    private String climate;
    private double cost; 
    private ArrayList<String> activities; 
    
    //Constructor
    public Destination(String name, String country, String famousFoods, String culture, String history, 
                       ArrayList<String> topAttractions, String climate, double cost, ArrayList<String> activities) {
        this.name = name;
        this.country = country;
        this.famousFoods = famousFoods;
        this.culture = culture;
        this.history = history;
        this.topAttractions = topAttractions;
        this.climate = climate;
        this.cost = cost;
        this.activities = activities;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public double getCost() {
        return cost;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "Destination: " + name;
    }
    //Used ChatGPT on January 13th for troubleshooting
    public String getDetails() {
        String attractions = String.join(", ", topAttractions);
        String activityList = String.join(", ", activities);

        return "Name: " + name + "\n" +
               "Country: " + country + "\n" +
               "Famous Foods: " + famousFoods + "\n" +
               "Culture: " + culture + "\n" +
               "History: " + history + "\n" +
               "Top Attractions: " + attractions + "\n" +
               "Climate: " + climate + "\n" +
               "Activities: " + activityList + "\n" +
               "Cost: $" + cost;
    }
}



