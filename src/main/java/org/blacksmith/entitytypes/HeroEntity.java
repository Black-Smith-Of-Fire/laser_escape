package org.blacksmith.entitytypes;

import org.blacksmith.components.SingleImageAnimator;

import java.awt.*;

public abstract class HeroEntity extends CollisionEntity {

    @Override
    public void tick() {
        move();
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        int healthWidth = 500;
        // draw the healthbar
        g2d.setColor(Color.green);
        g2d.fillRect(30,30,healthWidth*healthPercent/100,50);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString(healthPercent + " %",560,65);
        if (healthPercent<=0) {
            g2d.drawString(0 + " %",0,65);
        }

    }
}
