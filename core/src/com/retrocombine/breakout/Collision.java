package com.retrocombine.breakout;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by rpaz on 1/20/16.
 */
public class Collision {

    public static boolean overlap(Position topPosition, Size topSize, Position bottomPosition, Size bottomSize) {
        Rectangle topRectangle = new Rectangle(topPosition.x, topPosition.y, topSize.w, topSize.h);
        Rectangle bottomRectangle = new Rectangle(bottomPosition.x, bottomPosition.y, bottomSize.w, bottomSize.h);

        return topRectangle.overlaps(bottomRectangle);
    }
}
