package jetris;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel  implements Runnable{
    //set window properties
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    final int FPS = 60; 
    Thread gameThread;
    PlayManager pm;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        pm = new PlayManager();
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //game loop
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        //while the game thread is running
        while (gameThread != null) {
            //get the current time
            currentTime = System.nanoTime();

            //calculate the time since the last update
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            //check if it is time to update (a frame has passed)
            if (delta >= 1) {
                update();
                repaint();

                //reset the last update time
                delta--;
            }
        }
    }

    public void update() {
        pm.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;
        pm.draw(g2d);
    }
    
}
