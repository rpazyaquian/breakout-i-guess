package com.retrocombine.breakout;

/**
 * Created by rpaz on 1/20/16.
 */
public class Boundary {
    public Position position;
    public Size size;

    public Boundary(int w, int h) {
        this.position = new Position(0, 0);
        this.size = new Size(w, h);
    }

    public boolean collidingWith(Ball ball) {
        return (ball.position.x <= 0 || ball.position.x >= (size.w - ball.size.w) || ball.position.y <= 0 || ball.position.y >= (size.h - ball.size.w));
    }
}
