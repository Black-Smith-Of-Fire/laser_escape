package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Ai {

    Image star;

    int x;
    int y;
    int xDir;
    int yDir;

    Ai(int x, int y, Image star){
        this.x = x;
        this.y = y;
        this.star = star;


    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(star, x, y, null);
    }

    public void follow(int heroX, int heroY) {
        if (heroX > x) {
            x += 1;
            xDir = -1;
        }
        if (heroX < x) {
            x -= 1;
            xDir = 1;
        }
        if (heroY > y) {
            y += 1;
            yDir = -1;
        }
        if (heroY < y) {
            y -= 1;
            yDir = 1;
        }
    }
}
