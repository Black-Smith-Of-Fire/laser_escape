package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleLasers {
    ArrayList<Lasers> laserList;
    Image star;

    MultipleLasers(){
        laserList = new ArrayList<>();
        laserList.add(new Lasers(500,90, new ImageIcon("characters/enemy/starRed/redRect0.png").getImage()));
        for (int i = 1; i < 9; i++) {
            star = new ImageIcon("characters/enemy/starRed/redRect" + i + ".png").getImage();
            laserList.add(new Lasers(laserList.get(i-1).x + 14,laserList.get(i-1).y + 13, star));
        }
    }


    public void draw(Graphics2D g2d){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).draw(g2d);
        }
    }

    public void push(){
        for (int i = 0; i < 9; i++) {
            laserList.get(i).x ++;
            laserList.get(i).y ++;
        }
    }

    public boolean collision(int x, int y){
        for (int i = 0; i < 9; i++) {
            if (x <= laserList.get(i).x &&
                    y <= laserList.get(i).y &&
                    (x + 200) > laserList.get(i).x &&
                    (y + 200) > laserList.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public void move(){
        for (int i = 0; i < 9; i++) {
            laserList.get(i).move();
        }
    }
}
