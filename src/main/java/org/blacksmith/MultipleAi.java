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
        laserList.add(new Ai(x, y));

        for (int i = 1; i < 9; i++) {
            star = new ImageIcon("characters/enemy/starRed/redRect" + i + ".png").getImage();
            laserList.add(new Ai(laserList.get(i-1).x + 14,laserList.get(i-1).y + 13)); //
        }
    }


    public void draw(Graphics2D g2d){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).draw(g2d);
        }
    }



    public boolean collision(int x, int y){
        for (int i = 0; i < 9; i++) {
            if (x <= laserList.get(i).x &&
                    y <= laserList.get(i).y &&
                    (x + width) > laserList.get(i).x &&
                    (y + height) > laserList.get(i).y) {
                return true;
            }
        }
        return false;
    }


    public void follow(int x, int y){
        for (int i = 0; i < 9; i++) {
            laserList.get(i).follow(x, y);
        }
    }
}
