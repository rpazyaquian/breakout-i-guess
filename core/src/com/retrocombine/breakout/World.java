package com.retrocombine.breakout;

/**
 * Created by rpaz on 1/20/16.
 */
public class World {

    public Bricks bricks;
    public Ball ball;
    public Paddle paddle;
    private Boundary boundary;

    public World(int screenWidth, int screenHeight) {
        this.bricks = new Bricks();
        this.ball = new Ball();
        this.paddle = new Paddle();
        this.boundary = new Boundary(screenWidth, screenHeight);
    }

    public void tick(float delta) {
        ball.updatePosition(delta);
        paddle.updatePosition(delta);

        Brick collidingBrick = bricks.collidingWith(ball);

        if (collidingBrick != null) {
            ball.reflectOffBrick(collidingBrick);
            bricks.destroy(collidingBrick);
        }

        if (boundary.collidingWith(ball)) {
            ball.reflectOffBoundary(boundary);
        }

        if (paddle.collidingWith(ball)) {
            ball.reflectOffPaddle(paddle);
        }
    }

}
