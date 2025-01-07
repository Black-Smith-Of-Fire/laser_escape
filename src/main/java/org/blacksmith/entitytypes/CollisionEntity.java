package org.blacksmith.entitytypes;

public abstract class CollisionEntity extends OnScreenEntity {

    float width, height;

    public boolean collidesWith(CollisionEntity other) {
        // Check if this's X is within other's X
        // and this's Y is within other's Y
        if ((getX() >= other.getX()) &&
                (getX() <= other.getX() + other.getWidth()) &&
                (getY() >= other.getY()) &&
                (getY() <= other.getY() + other.getHeight())) {
            return true;
        }

        // Check if the other's X and Y are within this's X and Y
        if ((other.getX() >= getX()) &&
                (other.getX() <= getX() + getWidth()) &&
                (other.getY() >= getY()) &&
                (other.getY() <= getY() + getHeight())) {
            return true;
        }

        // if not,  it doesn't collide
        return false;
    }

}
