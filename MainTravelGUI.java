/*
Used these following resources to assist with the creation of the swing app portion:
https://wcpss.instructure.com/courses/1113970/pages/java-swing-tutorials-gui-graphical-user-interfaces?module_item_id=64259129
https://www.youtube.com/watch?v=5o3fMLPY7qY
*/ 


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainTravelGUI {
    private JFrame mainFrame;
    private JTextArea detailsArea;
    private JList<Destination> destinationList;
    private JComboBox<String> climateComboBox;
    private JCheckBox hikingCheckBox, sightseeingCheckBox, shoppingCheckBox, culturalToursCheckBox;
    private JButton searchButton;
    private JTextField budgetTextField;
    private TravelDestinationHelper travelHelper;

    public MainTravelGUI() {
        travelHelper = new TravelDestinationHelper();
        travelHelper.loadDestinations();
    }
    //Rigor Piece #1
    public void initComponents() {
        mainFrame = new JFrame("Travel Helper");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailsArea = new JTextArea(10, 30);
        detailsArea.setEditable(false);
        destinationList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(destinationList);

        climateComboBox = new JComboBox<>(new String[]{"Any", "Warm", "Cold", "Temperate"});
        hikingCheckBox = new JCheckBox("Hiking");
        sightseeingCheckBox = new JCheckBox("Sightseeing");
        shoppingCheckBox = new JCheckBox("Shopping");
        culturalToursCheckBox = new JCheckBox("Cultural Tours");
        
        JLabel budgetLabel = new JLabel("Budget: ");
        budgetTextField = new JTextField(10);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserPreferences prefs = getUserPreferences();
                ArrayList<Destination> suggestedDestinations = travelHelper.getSuggestedDestinations(prefs);
                updateDestinationList(suggestedDestinations);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0, 2));
        controlPanel.add(new JLabel("Climate:"));
        controlPanel.add(climateComboBox);
        controlPanel.add(new JLabel("Activities:"));
        controlPanel.add(hikingCheckBox);
        controlPanel.add(sightseeingCheckBox);
        controlPanel.add(shoppingCheckBox);
        controlPanel.add(culturalToursCheckBox);
        controlPanel.add(budgetLabel);
        controlPanel.add(budgetTextField);
        controlPanel.add(new JLabel());
        controlPanel.add(searchButton);

        mainFrame.add(scrollPane, BorderLayout.CENTER);
        mainFrame.add(detailsArea, BorderLayout.SOUTH);
        mainFrame.add(controlPanel, BorderLayout.NORTH);

        destinationList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Destination selectedDest = destinationList.getSelectedValue();
                if (selectedDest != null) {
                    displayDestinationDetails(selectedDest);
                }
            }
        });

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    //Rigor Piece #2
    private UserPreferences getUserPreferences() {
        UserPreferences prefs = new UserPreferences();
        
        String selectedClimate = (String) climateComboBox.getSelectedItem();
        prefs.setClimate(selectedClimate.equals("Any") ? "" : selectedClimate);
        
        ArrayList<String> activities = new ArrayList<>();
        if (hikingCheckBox.isSelected()) activities.add("Hiking");
        if (sightseeingCheckBox.isSelected()) activities.add("Sightseeing");
        if (shoppingCheckBox.isSelected()) activities.add("Shopping");
        if (culturalToursCheckBox.isSelected()) activities.add("Cultural Tours");
        prefs.setActivities(activities);
        
            //Used ChatGPT on January 14th to assist with this method

        try {
            double budget = Double.parseDouble(budgetTextField.getText());
            prefs.setBudget(budget);
        } catch (NumberFormatException e) {
            prefs.setBudget(1000.00); 
        }

        return prefs;
    }
    //Rigor #8
    private void updateDestinationList(ArrayList<Destination> destinations) {
        DefaultListModel<Destination> listModel = new DefaultListModel<>();
        for (Destination destination : destinations) {
            listModel.addElement(destination);
        }
        destinationList.setModel(listModel);
    }

    private void displayDestinationDetails(Destination dest) {
        detailsArea.setText(dest.getDetails());
    }
}
