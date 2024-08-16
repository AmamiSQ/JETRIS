package jetris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import mino.Block;
import mino.Ivan;
import mino.Jared;
import mino.Lucy;
import mino.Mino;
import mino.Olivia;
import mino.Susan;
import mino.Theo;
import mino.Zara;

public class PlayManager {
    //set up the board
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    Mino placeholderMino;
    final int PLACEHOLDER_START_X;
    final int PLACEHOLDER_START_Y;

    public static int dropInterval = 60; //drops every 60 frames

    public PlayManager() {
        //set the board size
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        //set the starting position of the minos
        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE+12;

        //set the starting mino
        currentMino = new Lucy();
        currentMino.setPos(MINO_START_X, MINO_START_Y);
        
        //TODO: REMOVE PLACEHOLDERS
        PLACEHOLDER_START_X = right_x + 170;
        PLACEHOLDER_START_Y = top_y + Block.SIZE+40;

        placeholderMino = new Olivia();
        placeholderMino.setPos(PLACEHOLDER_START_X, PLACEHOLDER_START_Y);
    }

    public void update() {
        currentMino.update();
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

        //draw the current mino
        if (currentMino != null) {
            currentMino.draw(graph);
        }

        if (placeholderMino != null) {
            placeholderMino.draw(graph);
        }
    }
}
