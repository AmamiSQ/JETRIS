package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import jetris.KeyHandler;
import jetris.PlayManager;

public class Mino {
    public Block blocks[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;
    public int direction = 1; //1 through 4 available directions
    boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;
    public boolean countdown;
    public int deactiveCounter = 0;

    public void create(Color color) {
        //fill the arrays with empty blocks
        for (int i = 0; i < 4; i++) {
            blocks[i] = new Block(color);
            tempB[i] = new Block(color);
        }

    }

    public void setPos(int x, int y) {};
    public void updatePos(int direction) {
        checkRotationCollision();

        if (leftCollision == false && rightCollision == false && bottomCollision == false) {
            this.direction = direction;
        
            //Q: why not store the new positions directly instead of using a temp array?
            /* A: it's for handling collision. If the block collides when it's rotating, the rotation needs to be cancelled
                    and that can't be done if it's already been updated */
            for(int i = 0; i<4; i++) {
                blocks[i].x = tempB[i].x;
                blocks[i].y = tempB[i].y;
            }
        }
    };

    public void getDirection1() {};
    public void getDirection2() {};
    public void getDirection3() {};
    public void getDirection4() {};
    public void checkMovementCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkBlockCollision();

        for(int i = 0; i< blocks.length; i++) {
            if(blocks[i].x == PlayManager.left_x) {
                leftCollision = true;
                // System.out.println("LEFT COLLISION");
            }

            if(blocks[i].x + Block.SIZE == PlayManager.right_x) {
                rightCollision = true;
                // System.out.println("RIGHT COLLISION");
            }

            if(blocks[i].y + Block.SIZE >= PlayManager.bottom_y) {
                bottomCollision = true;
                // System.out.println("BOTTOM COLLISION");
            }

        }
    };
    public void checkRotationCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkBlockCollision();

        for(int i = 0; i< blocks.length; i++) {
            if(tempB[i].x < PlayManager.left_x) {
                leftCollision = true;
                // System.out.println("LEFT COLLISION");
            }

            if(tempB[i].x + Block.SIZE > PlayManager.right_x) {
                rightCollision = true;
                // System.out.println("RIGHT COLLISION");
            }

            if(tempB[i].y + Block.SIZE >= PlayManager.bottom_y) {
                bottomCollision = true;
                // System.out.println("BOTTOM COLLISION");
            }

        }
    };

    public void checkBlockCollision() {
        for (int i = 0; i< PlayManager.staticBlocks.size(); i++) {
            int targetX = PlayManager.staticBlocks.get(i).x;
            int targetY = PlayManager.staticBlocks.get(i).y;

            for(int j = 0; j < blocks.length; j++) {
                if (blocks[j].y + Block.SIZE == targetY && blocks[j].x == targetX) {
                    bottomCollision = true;
                }
            }

            for(int j = 0; j < blocks.length; j++) {
                if (blocks[j].x - Block.SIZE == targetX && blocks[j].y == targetY) {
                    leftCollision = true;
                }
            }

            for(int j = 0; j < blocks.length; j++) {
                if (blocks[j].x + Block.SIZE == targetX && blocks[j].y == targetY) {
                    rightCollision = true;
                }
            }
        }
    }

    public void deactivating() {
        deactiveCounter++;
        
        if (deactiveCounter == 45) {
            active = false;
            countdown = false;
            deactiveCounter = 0;
            return;
        }
    }

    public void update() {
        if (countdown) {
            deactivating();
        }

        checkMovementCollision();

        //move the mino!!
        if (KeyHandler.upPressed && active) {
            switch(direction) {
                case 1: getDirection2(); break;
                case 2: getDirection3(); break;
                case 3: getDirection4(); break;
                case 4: getDirection1(); break;
            }
            KeyHandler.upPressed = false;
        }

        if (KeyHandler.downPressed && active) {
            for(int i = 0; i < 4; i++) {
                blocks[i].y += Block.SIZE;
            }

            //reset drop counter when moved down
            autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }

        if (KeyHandler.leftPressed && leftCollision == false && active) {
            for(int i = 0; i < 4; i++) {
                blocks[i].x -= Block.SIZE;
            }
            KeyHandler.leftPressed = false;
        }

        if (KeyHandler.rightPressed && rightCollision == false && active) {
            for(int i = 0; i < 4; i++) {
                blocks[i].x += Block.SIZE;
            }
            KeyHandler.rightPressed = false;
        }

        if (bottomCollision) {
            countdown = true;
        }
        else {
            autoDropCounter++;
            if (autoDropCounter == PlayManager.dropInterval) {
                for(int i = 0; i < 4; i++) {
                    blocks[i].y += Block.SIZE;
                }
                autoDropCounter = 0;
            }
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