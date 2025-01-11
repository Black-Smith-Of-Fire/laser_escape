package org.blacksmith.components;

import org.blacksmith.EntityContentManager;
import org.blacksmith.entitytypes.HeroEntity;

import javax.swing.*;
import java.awt.*;

public class ScoreBasedAnimator implements Animator {
    Image happy;
    Image shocked;
    Image worried;

    HeroEntity hero = null;
    public ScoreBasedAnimator(Image happy, Image worried, Image shocked) {

        this.happy = happy;
        this.worried = worried;
        this.shocked = shocked;
    }

    @Override
    public Image getImage() {
        if (hero == null) {
            hero = EntityContentManager.getInstance().getHero();
        }
        if (hero.getHealthPercent()<20) {
            return shocked;
        } else if (hero.getHealthPercent()<50) {
            return worried;
        } else {
            return happy;
        }
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
