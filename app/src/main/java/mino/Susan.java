package mino;

import java.awt.Color;

public class Susan extends Mino{

    public Susan() {
        create(Color.GREEN);
    }

    public void setPos(int x, int y) {
        //    0  0  block[1] block[2]
        // 0  0   block[3] block[0]
        //b[0] is the center (second) block
            //this is done so that the others rotate around it
        
        //TODO: optimalize this, can be done better/in a loop
        blocks[0].x = blocks[1].x = x;
        blocks[0].y = blocks[3].y = y;
        blocks[1].y = blocks[2].y = y - Block.SIZE;
        blocks[2].x = x + Block.SIZE;
        blocks[3].x = x - Block.SIZE;
    }

    public void getDirection1() {
        tempB[0].x = tempB[1].x = blocks[0].x;
        tempB[0].y = tempB[3].y = blocks[0].y;
        tempB[1].y = tempB[2].y = blocks[0].y - Block.SIZE;
        tempB[2].x = blocks[0].x + Block.SIZE;
        tempB[3].x = blocks[0].x - Block.SIZE;

        updatePos(1);
    }

    public void getDirection2() {
        tempB[0].y = tempB[1].y = blocks[0].y;
        tempB[2].y = blocks[0].y + Block.SIZE;
        tempB[3].y = blocks[0].y - Block.SIZE;
        tempB[0].x = tempB[3].x = blocks[0].x;
        tempB[1].x = tempB[2].x = blocks[0].x + Block.SIZE;

        updatePos(2);
    }
    
    public void getDirection3() {
        getDirection1();
        updatePos(3);
    }

    public void getDirection4() {
        getDirection2();
        updatePos(4);
    }
}