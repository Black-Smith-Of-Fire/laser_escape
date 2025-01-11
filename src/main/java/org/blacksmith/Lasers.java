package org.blacksmith;

import org.blacksmith.components.Animator;
import org.blacksmith.components.SingleImageAnimator;
import org.blacksmith.entitytypes.EnemyEntity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lasers extends EnemyEntity {

    int width;
    int height;

    int velX;
    int velY;

    int boardWidth = 1860;
    int boardHeight = 1010;

    ArrayList<Items> laserList;

    Lasers(int x, int y, Animator animator){
        setX(x);
        setY(y);
        setAnimator(animator);

        laserList = new ArrayList<>();
        laserList.add(new Items(x,y));

        velX = 0;
        velY = 0;
        width = 29;
        height = 26;
    }

    public void move(
    ){
        new Thread(new Runnable() {
            @Override
            public void run() {
                wallCollision();
            }
        }).start();
    }

    public void tick() {
        move();
    }

    public void wallCollision(){
        if (x <= 0) {
            velX +=  2;
        }

        if (y <= 0) {
            velY += 2;
        }

        if (x >= boardWidth) {
            velX -=  2;
        }

        if (y >= boardHeight) {
            velY -= 2;
        }
        x += velX;
        y += velY;
    }
}
