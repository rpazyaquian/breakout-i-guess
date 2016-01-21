package com.retrocombine.breakout;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by rpaz on 1/20/16.
 */
public class Brick {
    public TextureRegion texture;
    public Position position;
    public Size size;

    public Brick(int x, int y) {
        this.texture = new TextureRegion(new Texture("sprites/brick.png"));
        this.position = new Position(x, y);
        this.size = new Size(64, 32);
    }

    public boolean collidesWith(Ball ball) {
        return Collision.overlap(position, size, ball.position, ball.size);
    }
}
