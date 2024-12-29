package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleLasers {
    ArrayList<Lasers> laserList;
    Lasers lol;

    MultipleLasers(){
        laserList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            laserList.add(new Lasers(620 + (20 * i), 500 + 100 + (20*i)));
        }
    }

    public void draw(Graphics2D g2d){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.get(i).draw(g2d);
        }
    }
}
