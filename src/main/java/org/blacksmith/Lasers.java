package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lasers{

    int x;
    int y;
    int width;
    int height;

    int velX;
    int velY;

    int boardWidth = 1860;
    int boardHeight = 1010;

    Image star;
    ArrayList<Items> laserList;

    Lasers(int x, int y, Image star){
        this.x = x;
        this.y = y;
        this.star = star;

        laserList = new ArrayList<>();
        laserList.add(new Items(x,y));

        velX = 0;
        velY = 0;
        width = 29;
        height = 26;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(star, x, y, null);
    }

    public void move(
    ){
        new Thread(new Runnable() {
            @Override
            public void run() {
                wallCollision(
//                        dir
                );
            }
        }).start();
    }

    public void wallCollision(){
        if (x <= 0) {
            velX +=  5;
        }

        if (y <= 0) {
            velY += 5;
        }

        if (x >= boardWidth) {
            velX -=  5;
        }

        if (y >= boardHeight) {
            velY -= 5;
        }
        x += velX;
        y += velY;
    }
}
