import java.util.ArrayList;

public class TravelDestinationHelper {
    private ArrayList<Destination> destinations = new ArrayList<>();

    public void loadDestinations() {
        // Adding destinations
        ArrayList<String> parisAttractions = new ArrayList<>();
        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Louvre Museum");
        parisAttractions.add("Notre-Dame Cathedral");
        parisAttractions.add("Champs-Élysées");

        ArrayList<String> parisActivities = new ArrayList<>();
        parisActivities.add("Sightseeing");
        parisActivities.add("Shopping");

        destinations.add(new Destination("Paris", "France", "Croissants, Baguettes", "Rich artistic culture", "Long history of monarchy and revolution", 
                                         parisAttractions, "Cold", 1500, parisActivities));
    
        ArrayList<String> kyotoAttractions = new ArrayList<>();
        kyotoAttractions.add("Kinkaku-ji (Golden Pavilion)");
        kyotoAttractions.add("Fushimi Inari Shrine");
        kyotoAttractions.add("Arashiyama Bamboo Grove");
        kyotoAttractions.add("Gion District");

        ArrayList<String> kyotoActivities = new ArrayList<>();
        kyotoActivities.add("Cultural Tours");
        kyotoActivities.add("Hiking");

        destinations.add(new Destination("Kyoto", "Japan", "Sushi, Ramen", "Traditional Japanese culture", "Former capital of Japan", 
                                         kyotoAttractions, "Warm", 1200, kyotoActivities));

        ArrayList<String> romeAttractions = new ArrayList<>();
        romeAttractions.add("Colosseum");
        romeAttractions.add("Roman Forum");
        romeAttractions.add("Pantheon");
        romeAttractions.add("Vatican Museums");
        
        ArrayList<String> romeActivities = new ArrayList<>();
        romeActivities.add("Sightseeing");
        romeActivities.add("Cultural Tours");
        
        destinations.add(new Destination("Rome", "Italy", "Pizza, Pasta", "Rich history, art, and architecture", "Capital of the Roman Empire", romeAttractions, "Temperate", 2000, romeActivities ));

        ArrayList<String> beijingAttractions = new ArrayList<>();
        beijingAttractions.add("Great Wall of China");
        beijingAttractions.add("Forbidden City");
        beijingAttractions.add("Terracotta Army");
        beijingAttractions.add("Summer Palace");

        ArrayList<String> beijingActivities = new ArrayList<>();
        beijingActivities.add("Sightseeing"); 
        beijingActivities.add("Cultural Tours");
        beijingActivities.add("Hiking");

        destinations.add(new Destination("Beijing", "China", "Dumplings, Peking Duck", "Ancient Chinese traditions", 
                                         "Ancient civilization", beijingAttractions, "Temperate", 1800, beijingActivities));
    }

    // Troll response in case no matching destinations
    public ArrayList<Destination> getSuggestedDestinations(UserPreferences prefs) {
        ArrayList<Destination> suggestedDestinations = new ArrayList<>();
        for (Destination dest : destinations) {
            if (matchesPreferences(dest, prefs)) {
                suggestedDestinations.add(dest);
            }
        }
        
        // If no matches, troll the user by suggesting completely irrelevant destinations
        if (suggestedDestinations.isEmpty()) {
            suggestedDestinations.add(new Destination("Mars", "Planet", "Space Food", "Zero gravity", "No atmosphere", new ArrayList<>(), "None", 999999, new ArrayList<>()));
            suggestedDestinations.add(new Destination("Atlantis", "Ocean", "Underwater Snacks", "Mythical", "Lost city", new ArrayList<>(), "Submarine", 0, new ArrayList<>()));
        }
        
        return suggestedDestinations;
    }

    // Match user preferences, trolling when needed
    private boolean matchesPreferences(Destination dest, UserPreferences prefs) {
        if (!prefs.getClimate().isEmpty() && !dest.getClimate().equalsIgnoreCase(prefs.getClimate())) {
            return false; 
        }

        if (!prefs.getActivities().isEmpty()) {
            boolean activityMatch = false;
            for (String activity : prefs.getActivities()) {
                if (dest.getActivities().contains(activity)) {
                    activityMatch = true;
                    break;
                }
            }
            if (!activityMatch) {
                return false; 
            }
        }

        if (prefs.getBudget() > 0) {
            if (dest.getCost() > prefs.getBudget()) { 
                return false; 
            }
        }

        return true;
    }

    // Troll response for destination details
    public Destination getDestinationDetails(String destinationName) {
        for (Destination dest : destinations) {
            if (dest.getName().equalsIgnoreCase(destinationName)) {
                return dest;
            }
        }
        
        // Troll response when the destination is not found
        return new Destination("Unknown Destination", "Unknown Land", "Mysterious Food", "Mysterious Culture", "No History", new ArrayList<>(), "Unknown", 0, new ArrayList<>());
    }
}
