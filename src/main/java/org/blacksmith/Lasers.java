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

    int velX = 2;
    int velY = 2;
    int boardWidth = 1860;
    int boardHeight = 1010;

    ArrayList<Items> laserList;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

//        for (int i = 0; i < 9; i++) {
//            laserList.get(i).x += velX;
//            laserList.get(i).y += velY;
//        }

        laserList = new ArrayList<>();
        laserList.add(new Items(x, y));
        placeObstacles();

        width = 29;
        height = 26;
    }


    public void placeObstacles(){
        for (int i = 1; i < 9; i++) {
            laserList.add(new Items(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));//0
            System.out.println(i + " x : " + laserList.get(i).x);
        }
    }

    public void draw(Graphics2D g2d){
        for (int i = laserList.size() - 1; i >= 0; i--) {
            Image star = new ImageIcon("characters/enemy/starRed/redRect" + i +".png").getImage();
            Items laser = laserList.get(i);
            g2d.drawImage(star, laser.x, laser.y, width, height, null);
        }
    }

    public void lol(Graphics2D g2d){
            Image star = new ImageIcon("characters/enemy/starRed/redRect0.png").getImage();
            g2d.drawImage(star,x,y,null);
    }

    public void move(){

        // TODO : This for loop checks if each rectangle within the bounds .Afterwards it doesn't bother to
        // move it on
            if (laserList.get(1).x <= 0) {
                velX = 2;
                System.out.println("x is " + laserList.get(1).x);
            }

            if (laserList.get(1).y <= 0) {
                velY = 2;
                System.out.println("y is " + laserList.get(1).y);
            }

            if (laserList.get(1).x >= boardWidth) {
                velX = -2;
                System.out.println(" kkkkkkkkkkkkkkkklol x is " + laserList.get(1).x);
            }

            if (laserList.get(1).y >= boardHeight) {
                velY = -2;
                System.out.println("lol lllllllllllllllllly is " + laserList.get(1).y);
            }
    }

}
