package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleLasers {
    ArrayList<Lasers> laserList;
    Image star;
    int dir;
    int width = 179;
    int height = 128;

    MultipleLasers(int x, int y, int dir){
        this.dir = dir;
        laserList = new ArrayList<>();
        laserList.add(new Lasers(x, y, new ImageIcon("characters/enemy/starRed/redRect0.png").getImage()));
        for (int i = 1; i < 9; i++) {
            star = new ImageIcon("characters/enemy/starRed/redRect" + i + ".png").getImage();
            laserList.add(new Lasers(laserList.get(i-1).x + (dir * 14),laserList.get(i-1).y + 13, star)); //
        }
    }


    public void draw(Graphics2D g2d){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).draw(g2d);
        }
    }

    public void push(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                pushy();
            }
        }).start();
    }

    public void pushy(){
            laserList.get(0).x += (dir * 2);
            laserList.get(0).y += 2;

    }

    public boolean collision(int x, int y){
        for (int i = 0; i < 9; i++) {
            if (laserList.get(i).x >= x &&
                     laserList.get(i).y >= y &&
                    (x + width) > laserList.get(i).x &&
                    (y + height) > laserList.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public void move(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                movey();
            }
        }).start();
    }

    public  boolean crossedOver(int x, int y){
        for (int i = 0; i < laserList.size(); i++) {
            if (collision(x, y)){
                if (!collision(x,y)){
                    return true;
                }
            }
        }
        return false;
    }

    public void movey(){
            laserList.get(0).move();

        for (int i = 1; i < laserList.size(); i++) {
            if (laserList.get(i - 1).x > laserList.get(i).x + 14) {
                laserList.get(i).x += 2;
            }
            if (laserList.get(i - 1).x + 29 < laserList.get(i).x + 14) {
                laserList.get(i).x -= 2;
            }
            if (laserList.get(i - 1).y > laserList.get(i).y + 13) {
                laserList.get(i).y += 2;
            }
            if (laserList.get(i - 1).y + 26 < laserList.get(i).y + 13) {
                laserList.get(i).y -= 2;
            }
        }
        }
    }

