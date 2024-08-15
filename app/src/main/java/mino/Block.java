package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle{
    public int x, y;
    public static final int SIZE = 30;
    public Color color;

    public Block(Color color) {
        this.color = color;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }
}
