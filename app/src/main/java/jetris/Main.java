package jetris;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        //create new window
        JFrame frame = new JFrame("Jetris");

        //close the window and exit the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //creating a new game panel
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.pack();
        
        //set the window to be visible and centered
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //launch thread logic
        panel.launchGame();
    }
}
