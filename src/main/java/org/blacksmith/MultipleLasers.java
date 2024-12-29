package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MultipleLasers {
    ArrayList<Lasers> laserList;
    Lasers lol;

    MultipleLasers(){
        laserList = new ArrayList<>();
        lol = new Lasers(620, 500);
    }

    public void draw(Graphics2D g2d){
        lol.draw(g2d);
    }
}
