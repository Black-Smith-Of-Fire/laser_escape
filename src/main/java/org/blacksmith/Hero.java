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
    int boardWidth;
    int boardHeight;
    int velX = 0;
    int velY = 0;

    Hero(int x, int y){
        this.x = x;
        this.y = y;

        boardWidth = 1750;
        boardHeight = 940;

        happy = new ImageIcon("characters/hero/happy_hero.png").getImage();
        shocked = new ImageIcon("characters/hero/shocked_hero.png").getImage();
        worried = new ImageIcon("characters/hero/worried_hero.png").getImage();

    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(happy, x, y, null);
    }

    public void move(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                wallCollision();
            }
        }).start();
    }

    public void wallCollision(){
        if (x <= boardWidth && x >= 0) {
            x += velX;
        } else if (x <= 0) {
            x += 1;
        } else if (x >= boardWidth) {
            x -= 1;
        }

        if (y <= boardHeight && y >= 0) {
            y += velY;
        } else if (y <= 0) {
            y += 1;
        } else if (y >= boardHeight) {
            y -= 1;
        }
    }
}
