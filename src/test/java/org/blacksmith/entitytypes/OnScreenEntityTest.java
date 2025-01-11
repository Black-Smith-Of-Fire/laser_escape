package org.blacksmith.entitytypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteOnScreenEntity extends OnScreenEntity {
    public void tick(){}
}

public class OnScreenEntityTest {

    @Test
    public void testScaling() {

        ConcreteOnScreenEntity entity = new ConcreteOnScreenEntity();
        entity.setX(100);
        entity.setY(100);

        // Check that scaling to the same amount equals the same output
        assertEquals(100, entity.scaleX(200, 200));
        assertEquals(100, entity.scaleY(200, 200));

        // Check that scaling to half size gives us the right number
        assertEquals(50, entity.scaleX(200, 100));
        assertEquals(50, entity.scaleY(200, 100));
    }
}
