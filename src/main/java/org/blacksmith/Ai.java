package org.blacksmith;

import org.blacksmith.components.SingleImageAnimator;
import org.blacksmith.entitytypes.*;

import javax.swing.*;
import java.awt.*;

public class Ai extends EnemyEntity {

    Ai(int x, int y){
        setX(x);
        setY(y);
        Image star = new ImageIcon("characters/enemy/ai/ai_3.png").getImage();
        setAnimator(new SingleImageAnimator(star));
    }

    @Override
    public void tick() {
        System.out.println("Ai tick");
        EntityContentManager ecm = EntityContentManager.getInstance();
        HeroEntity hero = ecm.getHero();
        if (collidesWith(hero)) {
            GameEntity game = ecm.getGame();
            game.setScore(game.getScore()-50);
            hero.setHealthPercent(hero.getHealthPercent()-50); // todo - there should be logic so that different hits can be different damage
        }

        follow(hero);
        move();
    }

    public void follow(HeroEntity hero) {
        if (hero.getX() > x) {
            setVelocityX(1);
        }
        if (hero.getX() < x) {
            setVelocityX(-1);
        }
        if (hero.getY() > y) {
            setVelocityY(1);
        }
        if (hero.getY() < y) {
            setVelocityY(-1);
        }
    }

}
