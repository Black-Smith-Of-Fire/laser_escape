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

    ArrayList<Items> laserList;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        laserList = new ArrayList<>();
        laserList.add(new Items(x,y));

        velX = 0;
        velY = 0;
        width = 29;
        height = 26;
    }


    public void placeObstacles()//        if(laserPosX == 520) {
//            for (int i = 0; i < 9; i++) {
//                lasers.laserList.get(i).x -= 2;
//                lasers.laserList.get(i).y += 2;
//            }
//        }
{
//        laserList.add(new Items(laserList.get(1).x, laserList.get(1).y));
//        for (int i = 1; i < 9; i++) {
//            laserList.add(new Items(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));
//        }
    }

    public void draw(Graphics2D g2d){
//        for (int i = laserList.size() - 1; i >= 0; i--) {
//            Image star = new ImageIcon("characters/enemy/starRed/redRect" + i +".png").getImage();
//            Items laser = laserList.get(i);
//            g2d.drawImage(star, laser.x, laser.y, width, height, null);
//        }
    }

    public void lol(Graphics2D g2d){
        Image star = new ImageIcon("characters/enemy/starRed/redRect1.png").getImage();
        g2d.drawImage(star, x, y, null);
    }

    public void moveObs(){
        move(); // This is sort of working
        x += velX;
        y += velY;
    }

    public void move(){
            if (x <= 0) {
                velX += 2;
                System.out.println("This method is being used at : " + x);
            }

            if (y <= 0) {
                velY += 2;
                System.out.println("This method is being used 000000000000 : " + y);
            }

            if (x >= boardWidth) {
                velX -= 2;
             }

            if (y >= boardHeight) {
                velY -= 2;
                System.out.println("This method is being used at : " + x);
            }
    }

}
