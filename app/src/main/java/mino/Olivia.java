package mino;

import java.awt.Color;

public class Olivia extends Mino{

    public Olivia() {
        create(Color.YELLOW);
    }

    public void setPos(int x, int y) {
        // 0  0 blocks[0] blocks[1]
        // 0  0 blocks[2] blocks[3]
        //b[0] is the center (second) block
            //this is done so that the others rotate around it
        
        //TODO: optimalize this, can be done better/in a loop
        blocks[0].x = blocks[2].x = x;
        blocks[0].y = blocks[1].y = y;
        blocks[1].x = blocks[3].x = x + Block.SIZE;
        blocks[2].y = blocks[3].y = y + Block.SIZE;

    }

    public void getDirection1() {
        tempB[0].x = tempB[2].x = blocks[0].x;
        tempB[0].y = tempB[1].y = blocks[0].y;
        tempB[1].x = tempB[3].x = blocks[0].x + Block.SIZE;
        tempB[2].y = tempB[3].y = blocks[0].y + Block.SIZE;

        updatePos(1);
    }

    public void getDirection2() {
        getDirection1();
        updatePos(2);
    }
    
    public void getDirection3() {
        getDirection1();
        updatePos(3);
    }

    public void getDirection4() {
        getDirection1();
        updatePos(4);
    }
}