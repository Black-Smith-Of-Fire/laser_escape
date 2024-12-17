package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Lasers {
    Image ball;
    int x;
    int y;

    int velX;
    int velY;

    int collision;
    int boardWidth = 1860;
    int boardHeight = 1010;

    Timer laserLoop;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        setCollision(0);
        ball = new ImageIcon("characters/enemy/ball_obstacle.png").getImage();
    }

    public void move(){
        if (y >= 0 && getCollision() == 0) {
            x += 2;
            y += 2;
            setCollision(boardHeight);
        }
//        if (y >= boardHeight && getCollision() == boardHeight) {
//            x += 2;
//            y -= 2;
//        }
    }

//    public void collision(){
//        if (x >= boardWidth) {
//            setX(-2);
//        }
//        if (y >= boardHeight) {
//            setY(-2);
//        }
//        if (x == 0) {
//            setX(2);
//        }
//        if (y == 0) {
//            setY(2);
//        }
//    }

    public void setX(int velX){
        this.velX = velX;
    }

    public int getX(){
        return velX;
    }

    public void setY(int velY){
        this.velY = velY;
    }

    public int getY(){
        return velY;
    }

    public void setCollision(int collision){
        this.collision = collision;
    }

    public int getCollision(){
        return collision;
    }
}
