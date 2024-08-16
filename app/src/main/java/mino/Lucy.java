package mino;

import java.awt.Color;

public class Lucy extends Mino{

    public Lucy() {
        create(Color.ORANGE);
    }

    public void setPos(int x, int y) {
        //   0   blocks[1]
        //   0   blocks[0] 
        //   0 0  blocks[2] blocks[3]
        //b[0] is the center (second) block
            //this is done so that the others rotate around it
        
        blocks[0].x = blocks[1].x = blocks[2].x = x; //standard x position
        blocks[3].x = x + Block.SIZE; //you want this block to be to the right of the previous one, so add x with one block
        blocks[0].y = y; //standard y position
        blocks[1].y = y - Block.SIZE; //you want this block to be above the previous one, so subtract y with one block
        blocks[2].y = blocks[3].y = y + Block.SIZE;  //you want this block to be below the previous one, so add y with one block
    }

    public void getDirection1() {
        tempB[0].x = tempB[1].x = tempB[2].x = blocks[0].x;
        tempB[3].x = blocks[0].x + Block.SIZE;
        tempB[0].y = blocks[0].y;
        tempB[1].y = blocks[0].y - Block.SIZE;
        tempB[2].y = tempB[3].y = blocks[0].y + Block.SIZE;

        updatePos(1);
    }

    public void getDirection2() {
        tempB[0].y = tempB[1].y = tempB[2].y = blocks[0].y;
        tempB[3].y = blocks[0].y + Block.SIZE;
        tempB[0].x = blocks[0].x;
        tempB[1].x = blocks[0].x + Block.SIZE;
        tempB[2].x = tempB[3].x = blocks[0].x - Block.SIZE;

        updatePos(2);
    }
    
    public void getDirection3() {
        tempB[0].x = tempB[1].x = tempB[2].x = blocks[0].x;
        tempB[3].x = blocks[0].x - Block.SIZE;
        tempB[0].y = blocks[0].y;
        tempB[1].y = blocks[0].y + Block.SIZE;
        tempB[2].y = tempB[3].y = blocks[0].y - Block.SIZE;

        updatePos(3);
    }

    public void getDirection4() {
        tempB[0].y = tempB[1].y = tempB[2].y = blocks[0].y;
        tempB[3].y = blocks[0].y - Block.SIZE;
        tempB[0].x = blocks[0].x;
        tempB[1].x = blocks[0].x - Block.SIZE;
        tempB[2].x = tempB[3].x = blocks[0].x + Block.SIZE;

        updatePos(4);
    }
}