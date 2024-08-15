package jetris.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Board {
    final int WIDTH = 360;
    final int HEIGHT = 550;

    //set up the board
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    public Board() {
        //set the board size
        left_x = (Window.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;
    }

    public void update() {

    }

    //draw the board
    public void draw(Graphics2D graph) {
        //set color and stroke size
        graph.setColor(Color.WHITE);
        graph.setStroke(new BasicStroke(4f));

        //draw the board
        graph.drawRect(left_x-4, top_y+8, WIDTH, HEIGHT);

        //draw the next piece box
        int x = right_x + 100;
        int y = top_y+8;
        graph.drawRect(x, y, 150, 150);
            
        //set font and draw the text
        graph.setFont(new Font("MS Gothic", Font.PLAIN, 20));
        graph.drawString("次", x+60, y+20);
    }
}
