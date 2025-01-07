package org.blacksmith;

import org.blacksmith.entitytypes.CollisionEntity;
import org.blacksmith.entitytypes.HeroEntity;
import org.blacksmith.entitytypes.OnScreenEntity;

import javax.swing.*;
import java.awt.*;

public class Ai extends CollisionEntity {

    int xDir;
    int yDir;
    int width = 179;
    int height = 128;
    int deduct = 0;
    int scoreDeduct = 0;

    Ai(int x, int y, Image star){
        setX(x);
        setY(y);
        setImage(star);
    }

    public void tick() {
        HeroEntity hero = EntityContentManager.getInstance().getHero();
        if (collidesWith(hero)) {
            deduct = -50;
            scoreDeduct = -10;
        }

        follow(hero);
    }

    public void follow(HeroEntity hero) {
        if (hero.getX() > x) {
            x += 1;
            xDir = -1;
        }
        if (hero.getX() < x) {
            x -= 1;
            xDir = 1;
        }
        if (hero.getY() > y) {
            y += 1;
            yDir = -1;
        }
        if (hero.getY() < y) {
            y -= 1;
            yDir = 1;
        }
    }

}
