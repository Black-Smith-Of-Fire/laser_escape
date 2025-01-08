package org.blacksmith.entitytypes;

public abstract class HeroEntity extends CollisionEntity {

    @Override
    public void tick() {
        move();
    }
}
