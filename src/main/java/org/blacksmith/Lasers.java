package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Lasers{

    int x;
    int y;
    int width;
    int height;

    int velX = 0;
    int velY = 0;
    int boardWidth = 1860;
    int boardHeight = 1010;

    ArrayList<Items> laserList;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        laserList = new ArrayList<>();
        laserList.add(new Items(x, y));
//        placeObstacles();

        width = 29;
        height = 26;
    }


    public void placeObstacles(){
        laserList.add(new Items(laserList.get(1).x, laserList.get(1).y));
//        for (int i = 1; i < 9; i++) {
//            laserList.add(new Items(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));
//        }
    }

    public void draw(Graphics2D g2d){
        for (int i = laserList.size() - 1; i >= 0; i--) {
            Image star = new ImageIcon("characters/enemy/starRed/redRect" + i +".png").getImage();
            Items laser = laserList.get(i);
            g2d.drawImage(star, laser.x, laser.y, width, height, null);
        }
    }

    public void lol(Graphics2D g2d){
        Image star = new ImageIcon("characters/enemy/starRed/redRect1.png").getImage();
        g2d.drawImage(star, x, y, null);
    }

    public void moveObs(){
        move(x, y); // God, let this work
    }

    public void move(int x, int y){
        // TODO : This for loop checks if each rectangle within the bounds .Afterwards it doesn't bother to
        // move it on
            if (x <= 0) {
                velX = 2;
            }

            if (y <= 0) {
                velY = 2;
            }

            if (x >= boardWidth) {
                velX = -2;
            }

            if (y >= boardHeight) {
                velY = -2;
            }
        x += velX;
        y += velY;
    }

}
