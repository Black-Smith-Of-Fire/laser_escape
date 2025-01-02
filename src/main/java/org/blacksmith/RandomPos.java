package org.blacksmith;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomPos {
    Random random;
    int push;
    int dir;
    RandomPos() {
        random = new Random();
        push = random.nextInt(0, 1750);
        if (random.nextBoolean() == true){
            dir = 1;
        }
        else {
            dir = -1;
        }
    }

}
