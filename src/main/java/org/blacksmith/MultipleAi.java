package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleAi {
    ArrayList<Ai> laserList;
    Image star;
    int width = 179;
    int height = 128;

    MultipleAi(int x, int y){
        laserList = new ArrayList<>();
        laserList.add(new Ai(x, y, new ImageIcon("characters/enemy/ai/ai_3.png").getImage()));

        for (int i = 1; i < 3; i++) {
        laserList.add(new Ai(laserList.get(i - 1).x - 14,laserList.get(i - 1).y - 13, new ImageIcon("characters/enemy/ai/ai_" + i + ".png").getImage())); //
        }
    }


    public void draw(Graphics2D g2d){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).draw(g2d);
        }
    }



    public boolean collision(int x, int y){
//        for (int i = 0; i < laserList.size(); i++) {
//            if (laserList.get(i).x >= x &&
//                    laserList.get(i).y >= y &&
//                    (x + width) > laserList.get(i).x &&
//                    (y + height) > laserList.get(i).y) {
//                System.out.println("Here at x " + laserList.get(i).x + " and hero X : " + x);
//                System.out.println("Here at Y " + laserList.get(i).y + " and hero x : " + y);
//                return true;
//            }
//        }
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).collision(x,y);
        }

        return false;
    }


    public void follow(int x, int y){
        laserList.get(0).follow(x, y);
        for (int i = 1; i < laserList.size(); i++) {

        if (laserList.get(i - 1).x > laserList.get(i).x + 14) {
            laserList.get(i).x ++;
        }
        if (laserList.get(i - 1).x + 29 < laserList.get(i).x + 14) {
            laserList.get(i).x --;
        }
        if (laserList.get(i - 1).y > laserList.get(i).y + 13) {
            laserList.get(i).y ++;
        }
        if (laserList.get(i - 1).y + 26 < laserList.get(i).y + 13) {
            laserList.get(i).y --;
        }
        }
    }
}
