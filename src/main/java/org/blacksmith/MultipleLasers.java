package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleLasers {
    ArrayList<Lasers> laserList;

    MultipleLasers(){
        laserList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            laserList.add(new Lasers(0 + (2*i),+ 0 + (2*i)));
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

    public void move(){
        for (int i = 0; i < 9; i++) {
            laserList.get(i).move();
        }
    }
}
