package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Ai {

    Image star;

    int x;
    int y;
    int xDir;
    int yDir;
    int width = 179;
    int height = 128;
    int deduct = 0;
    int scoreDeduct = 0;

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

    public boolean collision(int heroX, int heroY){
            if (x >= heroX &&
                    y >= heroY &&
                    (heroX + width) > x &&
                    (heroY + height) > y) {
                System.out.println("Hurray");
                return true;
            }
        return false;
    }

    public void score(int heroX, int heroY){

        if (collision(heroX, heroY)) {
            deduct = -50;
            scoreDeduct = -10;
        }
        else {
            deduct = 0;
            scoreDeduct = 0;
        }

    }
}
