package org.blacksmith.entitytypes;

public abstract class CollisionEntity extends OnScreenEntity {

    public boolean collidesWith(CollisionEntity other) {
        //System.out.println (getX()+"x"+getY()+"+"+getWidth()+"x"+getHeight()+" vs "+other.getX()+"x"+other.getY()+"+"+other.getWidth()+"x"+ other.getHeight());
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
