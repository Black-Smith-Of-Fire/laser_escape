package org.blacksmith.entitytypes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ConcreteCollisionEntity extends CollisionEntity {

    @Override
    public void paint() {

    }

}
public class CollisionEntityTest {

    @Test
    public void testOverlapCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setWidth(10);
        entity1.setHeight(10);

        entity2.setX(2);
        entity2.setY(2);
        entity2.setWidth(10);
        entity2.setHeight(10);

        assertTrue(entity1.collidesWith(entity2));
    }

    @Test
    public void testWithinCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setWidth(10);
        entity1.setHeight(10);

        entity2.setX(2);
        entity2.setY(2);
        entity2.setWidth(2);
        entity2.setHeight(2);

        assertTrue(entity1.collidesWith(entity2));
    }

    @Test
    public void testWithinCollisionReversed() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setWidth(10);
        entity1.setHeight(10);

        entity2.setX(2);
        entity2.setY(2);
        entity2.setWidth(2);
        entity2.setHeight(2);

        assertTrue(entity2.collidesWith(entity1));
    }

    @Test
    public void testNoCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setWidth(10);
        entity1.setHeight(10);

        entity2.setX(20);
        entity2.setY(20);
        entity2.setWidth(2);
        entity2.setHeight(2);

        assertFalse(entity1.collidesWith(entity2));
    }

    @Test
    public void testCollidesWithSelf() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setWidth(10);
        entity1.setHeight(10);

        assertTrue(entity1.collidesWith(entity1));
    }

}
