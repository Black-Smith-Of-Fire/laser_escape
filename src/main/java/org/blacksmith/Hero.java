package org.blacksmith;

import org.blacksmith.components.Animator;
import org.blacksmith.components.ScoreBasedAnimator;
import org.blacksmith.components.SingleImageAnimator;
import org.blacksmith.components.SpriteSheetAnimator;
import org.blacksmith.entitytypes.HeroEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hero extends HeroEntity {

    Hero(int x, int y) {
        this.x = x;
        this.y = y;

        setHealthPercent(100);

        Image happy = new ImageIcon("characters/hero/happy_hero.png").getImage();
        Image shocked = new ImageIcon("characters/hero/shocked_hero.png").getImage();
        Image worried = new ImageIcon("characters/hero/worried_hero.png").getImage();
        Image sheet = new ImageIcon("characters/hero/spritesheet.png").getImage();

        Animator animator = new SpriteSheetAnimator(sheet, 48, 58, 200);
        setAnimator(animator);
    }

}
