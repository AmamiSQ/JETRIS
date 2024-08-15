package mino;

import java.awt.Color;
import java.awt.Graphics2D;

public class Mino {
    public Block blocks[] = new Block[4];
    public Block tempB[] = new Block[4];

    public void create(Color color) {
        //fill the arrays with empty blocks
        for (int i = 0; i < 4; i++) {
            blocks[i] = new Block(color);
            tempB[i] = new Block(color);
        }

    }

    public void setPos(int x, int y) {};
    public void updatePos(int x, int y) {};
    public void update() {};

    public void draw(Graphics2D g) {
        g.setColor(blocks[0].color);
        for (int i = 0; i < 4; i++) {
            g.fillRect(blocks[i].x, blocks[i].y, Block.SIZE, Block.SIZE);
        }
    };
}
