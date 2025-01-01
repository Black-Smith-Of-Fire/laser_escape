package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Ai {

    Image happy;
    Image shocked;
    Image worried;
    int x;
    int y;
    int velX = 0;
    int velY = 0;

    Ai(int x, int y){
        this.x = x;
        this.y = y;

        happy = new ImageIcon("characters/enemy/ai/ai_3.png").getImage();
        shocked = new ImageIcon("characters/hero/shocked_hero.png").getImage();
        worried = new ImageIcon("characters/hero/worried_hero.png").getImage();

    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(happy, x, y, null);
    }

    public void follow(int heroX, int heroY) {
        if (heroX > x) {
            x += 1;
        }
        if (heroX < x) {
            x -= 1;
        }
        if (heroY > y) {
            y += 1;
        }
        if (heroY < y) {
            y -= 1;
        }
    }
}
