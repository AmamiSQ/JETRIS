package jetris.main;

import javax.swing.JFrame;

public class Window {
    //set window width and height
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    //set up a new board and title
    private GamePanel panel;
    // private Title title;
    private JFrame frame;   

    //window constructor
    public Window() {
        //create a new window
        JFrame frame = new JFrame("Jetris");

        //close the window and exit the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set window properties
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //creating a new game panel
        panel = new GamePanel();
        // title = new Title();

        //add listeners to the frame
        frame.add(panel);
        // frame.addMouseMotionListener(title);
        // frame.addMouseListener(title);

        // frame.add(title);

        //set the frame to be visible
        frame.setVisible(true);
    }

    // public void startJetris(){
    //     frame.remove(title);  
    //     frame.addMouseMotionListener(board);  
    //     frame.addMouseListener(board);  
    //     frame.add(board);  
    //     board.sttGame();  
    //     frame.revalidate();  
    // }


    //main method
    public static void main(String[] args) {
        new Window();
    }
    
}
