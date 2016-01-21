package com.retrocombine.breakout;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by rpaz on 1/20/16.
 */
public class Paddle {

    public TextureRegion texture;
    public Position position;
    public Size size;
    public Velocity velocity;

    public Paddle() {
        this.texture = new TextureRegion(new Texture("sprites/paddle.png"));
        this.position = new Position(200, 100);
        this.size = new Size(128, 32);
        this.velocity = new Velocity(0, 0);
    }

    public void updatePosition(float delta) {
        position.x += velocity.vx * delta;
        position.y += velocity.vy * delta;
    }

    public boolean collidingWith(Ball ball) {
        return Collision.overlap(position, size, ball.position, ball.size);
    }
}
