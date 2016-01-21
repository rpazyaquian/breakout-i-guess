package com.retrocombine.breakout;

import com.badlogic.gdx.utils.Array;

/**
 * Created by rpaz on 1/20/16.
 */
public class Bricks {

    public Array<Brick> bricks;

    public Bricks() {
        bricks = new Array<Brick>();
        for (int i = 0; i < 16 ; i += 4) {
            for (int j = 0; j < 16 ; j += 4) {
                bricks.add(new Brick((i*32), (480 + 32) - (j * 32)));
            }
        }
    }

    public Brick collidingWith(Ball ball) {
        for (Brick brick:
             bricks) {
            if (brick.collidesWith(ball)) {
                return brick;
            }
        }
        return null;
    }

    public void destroy(Brick brick) {
        bricks.removeValue(brick, true);
    }
}
