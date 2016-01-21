package com.retrocombine.breakout;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by rpaz on 1/20/16.
 */
public class Ball {

    public TextureRegion texture;
    public Position position;
    public Size size;
    public Velocity velocity;

    public Ball() {
        this.texture = new TextureRegion(new Texture("sprites/ball.png"));
        this.position = new Position(320, 240);
        this.size = new Size(32, 32);
        this.velocity = new Velocity(2, 2);
    }

    public void updatePosition(float delta) {
        position.x += velocity.vx;
        position.y += velocity.vy;

        // TODO: handle moving past boundary

    }

    public void reflectOffBrick(Brick brick) {
        Vector2 brickCenter = new Vector2(brick.position.x + (brick.size.w / 2), brick.position.y + (brick.size.h / 2));
        Vector2 ballCenter = new Vector2(position.x + (size.w / 2), position.y + (size.h / 2));
        Vector2 distanceBetweenCenters = brickCenter.sub(ballCenter);
        if (Math.abs(distanceBetweenCenters.x) > Math.abs(distanceBetweenCenters.y)) {
            velocity.vx *= -1;
        }
        if (Math.abs(distanceBetweenCenters.x) < Math.abs(distanceBetweenCenters.y)) {
            velocity.vy *= -1;
        }

    }

    public void reflectOffBoundary(Boundary boundary) {
        if (position.x <= 0 || (position.x + 32 >= boundary.size.w)) {
            velocity.vx *= -1;
        }

        if (position.y <= 0 || (position.y + 32 >= boundary.size.h)) {
            velocity.vy *= -1;
        }
    }

    public void reflectOffPaddle(Paddle paddle) {
        Vector2 paddleCenter = new Vector2(paddle.position.x + (paddle.size.w / 2), paddle.position.y + (paddle.size.h / 2));
        Vector2 ballCenter = new Vector2(position.x + (size.w / 2), position.y + (size.h / 2));
        Vector2 distanceBetweenCenters = paddleCenter.sub(ballCenter);
        if (Math.abs(distanceBetweenCenters.x) > Math.abs(distanceBetweenCenters.y)) {
            velocity.vx *= -1;
        }
        if (Math.abs(distanceBetweenCenters.x) < Math.abs(distanceBetweenCenters.y)) {
            velocity.vy *= -1;
        }
    }

}
