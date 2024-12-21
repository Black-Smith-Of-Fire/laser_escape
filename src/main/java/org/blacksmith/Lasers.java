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
        placeObstacles();

        width = 29;
        height = 26;
    }


    public void placeObstacles(){
        for (int i = 1; i < 9; i++) {
            laserList.add(new Items(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));//0
//            System.out.println(i + " x : " + laserList.get(i).x);
        }
    }

    public void draw(Graphics2D g2d){
        for (int i = laserList.size() - 1; i >= 0; i--) {
            Image star = new ImageIcon("characters/enemy/starRed/redRect" + i +".png").getImage();
            Items laser = laserList.get(i);
            g2d.drawImage(star, laser.x, laser.y, width, height, null);
        }
    }

    public void move(){
        // TODO : This for loop checks if each rectangle within the bounds .Afterwards it doesn't bother to
        // move it on
        for (int i = 0; i < 9; i++) {
            if (laserList.get(i).x <= 0) {
                velX = 2;
//                System.out.println("x is " + laserList.get(1).x);
            }

            if (laserList.get(i).y <= 0) {
                velY = 2;
//                System.out.println("y is " + laserList.get(1).y);
            }

            if (laserList.get(i).x >= boardWidth) {
                velX = -2;
//                System.out.println(" kkkkkkkkkkkkkkkklol x is " + laserList.get(1).x);
            }

            if (laserList.get(i).y >= boardHeight) {
                velY = -2;
//                System.out.println("lol lllllllllllllllllly is " + laserList.get(1).y);
            }
            Items item = new Items(laserList.get(i).x + velX, laserList.get(i).y + velY);
            System.out.println(i + " " + i + " " + i +" "+ i);
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX : " + item.x);
            System.out.println("OOOOOOOOOOOOOOOOOO is : " + item.y);
            laserList.set(i, item);
        }
    }

}
