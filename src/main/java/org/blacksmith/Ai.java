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

        happy = new ImageIcon("characters/hero/happy_hero.png").getImage();
        shocked = new ImageIcon("characters/hero/shocked_hero.png").getImage();
        worried = new ImageIcon("characters/hero/worried_hero.png").getImage();

    }
    public void follow() {
        x += velX;
        y += velY;
    }
}
