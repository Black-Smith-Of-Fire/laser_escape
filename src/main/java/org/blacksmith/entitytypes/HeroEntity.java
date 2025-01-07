package org.blacksmith.entitytypes;

public abstract class HeroEntity extends CollisionEntity {

    // moves X or Y in either direction. X and Y can be negative
    public void move(int x, int y) {
        setX(getX()+x);
        setY(getY()+y);
    }
}
