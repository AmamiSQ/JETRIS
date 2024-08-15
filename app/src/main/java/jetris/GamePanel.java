package main.java.jetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    final int FPS = 60;
    Thread gameThread;
    Board board;
    
    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        board = new Board();
    }

    public void startJetris() {
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
            delta = (currentTime - lastTime) / drawInterval;
            
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
        board.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graph = (Graphics2D)g;
        board.draw(graph);
    }
}
