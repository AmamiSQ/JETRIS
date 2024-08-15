package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import jetris.KeyHandler;
import jetris.PlayManager;

public class Mino {
    public Block blocks[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;

    public void create(Color color) {
        //fill the arrays with empty blocks
        for (int i = 0; i < 4; i++) {
            blocks[i] = new Block(color);
            tempB[i] = new Block(color);
        }

    }

    public void setPos(int x, int y) {};
    public void updatePos(int x, int y) {};
    public void update() {
        //move the mino!!
        if (KeyHandler.upPressed) {
            KeyHandler.upPressed = false;
        }

        if (KeyHandler.downPressed) {
            for(int i = 0; i < 4; i++) {
                blocks[i].y += Block.SIZE;
            }

            //reset drop counter when moved down
            autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }

        if (KeyHandler.leftPressed) {
            for(int i = 0; i < 4; i++) {
                blocks[i].x -= Block.SIZE;
            }
            KeyHandler.leftPressed = false;
        }

        if (KeyHandler.rightPressed) {
            for(int i = 0; i < 4; i++) {
                blocks[i].x += Block.SIZE;
            }
            KeyHandler.rightPressed = false;
        }

        autoDropCounter++;
        if (autoDropCounter == PlayManager.dropInterval) {
            for(int i = 0; i < 4; i++) {
                blocks[i].y += Block.SIZE;
            }
            autoDropCounter = 0;
        }
    };

    public void draw(Graphics2D g) {
        int margin = 2;
        g.setColor(blocks[0].color);

        for (int i = 0; i < 4; i++) {
            g.fillRect(blocks[i].x+margin, blocks[i].y+margin, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        }
    };
}
