package org.blacksmith.entitytypes;

import org.blacksmith.components.Animator;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class ConcreteCollisionEntity extends CollisionEntity {
    @Override
    public void tick(){}
}

public class CollisionEntityTest {

    class TestAnimator implements Animator {
        @Override
        public Image getImage() {
            return null;
        }

        @Override
        public int getWidth() {
            return 10;
        }

        @Override
        public int getHeight() {
            return 10;
        }
    }
    @Test
    public void testOverlapCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setAnimator(new TestAnimator());

        entity2.setX(2);
        entity2.setY(2);
        entity2.setAnimator(new TestAnimator());

        assertTrue(entity1.collidesWith(entity2));
    }

    @Test
    public void testWithinCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setAnimator(new TestAnimator());

        entity2.setX(2);
        entity2.setY(2);
        entity2.setAnimator(new TestAnimator());

        assertTrue(entity1.collidesWith(entity2));
    }

    @Test
    public void testWithinCollisionReversed() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setAnimator(new TestAnimator());

        entity2.setX(2);
        entity2.setY(2);
        entity2.setAnimator(new TestAnimator());

        assertTrue(entity2.collidesWith(entity1));
    }

    @Test
    public void testNoCollision() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();
        ConcreteCollisionEntity entity2 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setAnimator(new TestAnimator());

        entity2.setX(20);
        entity2.setY(20);
        entity2.setAnimator(new TestAnimator());

        assertFalse(entity1.collidesWith(entity2));
    }

    @Test
    public void testCollidesWithSelf() {
        ConcreteCollisionEntity entity1 = new ConcreteCollisionEntity();

        entity1.setX(0);
        entity1.setY(0);
        entity1.setAnimator(new TestAnimator());

        assertTrue(entity1.collidesWith(entity1));
    }

}
