package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Lasers {
    Image ball;
    int x;
    int y;

    int velX;
    int velY;

    int boardWidth = 1860;
    int boardHeight = 1010;

    Timer laserLoop;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        ball = new ImageIcon("characters/enemy/ball_obstacle.png").getImage();
    }

    public void move(){
        collision();
        x += velX;
        y += velY;
    }
    public void collision(){
        if (x >= boardWidth) {
            velX = -2;
        }
        if (y >= boardHeight) {
            velY = -2;
        }
        if (x == 0) {
            velX = 2;
        }
        if (y == 0) {
            velY = 2;
        }
    }

    public void setX(int velX){
        this.velX = velX;
    }

    public int getX(int velX){
        return velX;
    }

    public void setY(int velY){
        this.velY = velY;
    }

    public int getY(int velY){
        return velY;
    }
}
