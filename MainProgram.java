/*
Used these resources to assist to make this class due to necessary swing componenets:
https://wcpss.instructure.com/courses/1113970/pages/java-swing-tutorials-gui-graphical-user-interfaces?module_item_id=64259129
https://www.youtube.com/watch?v=5o3fMLPY7qY
*/ 

//Used ChatGPT on January 14th to troubleshoot problems involving this main class 

//Rigor #5
import javax.swing.SwingUtilities;

public class MyProgram {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainTravelGUI gui = new MainTravelGUI();
                gui.initComponents(); 
            }
        });
    }
}
