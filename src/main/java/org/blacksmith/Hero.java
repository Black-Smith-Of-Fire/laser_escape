package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hero {

    Image happy;
    Image shocked;
    Image worried;
    int x;
    int y;

    Hero(int x, int y){
        this.x = x;
        this.y = y;

        happy = new ImageIcon("characters/hero/happy_hero.png").getImage();
        shocked = new ImageIcon("characters/hero/shocked_hero.png").getImage();
        worried = new ImageIcon("characters/hero/worried_hero.png").getImage();

    }
}
