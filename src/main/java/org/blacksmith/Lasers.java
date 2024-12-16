package org.blacksmith;

import javax.swing.*;
import java.awt.*;

public class Lasers {
    Image ball;
    int x;
    int y;

    Timer laserLoop;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        ball = new ImageIcon("characters/enemy/ball_obstacle.png").getImage();
    }

    public void move(){
        x ++;
        y ++;
    }
}
