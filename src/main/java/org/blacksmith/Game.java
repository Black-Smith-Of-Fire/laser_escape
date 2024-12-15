package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    int heroPosX = 0;
    int heroPosY = 0;
    int ballPosX = 0;
    int ballPosY = 0;

    int velX = 2;
    int velY = 0;
//    double width;
//    double height;

    Timer timer;
    Timer obstacle_timer;

    int mouseX,mouseY;

    Hero hero;
    Lasers lasers;

    Game(){
        hero = new Hero(heroPosX, heroPosY);
        lasers = new Lasers(ballPosX, ballPosY);

        JPanel panel = new JPanel();
        panel.addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(panel);
        pack();


        setVisible(true);


        timer = new Timer(10,this);
        timer.start();

        obstacle_timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        })
        obstacle_timer.start();

//        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
//        height = 930;

        mouseX = 1750;
        mouseY = 940;
    }

    public void paint(Graphics g){
        super.paint(g);
        draw((Graphics2D) g);
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(hero.happy, hero.x, hero.y, null);
        g2d.drawImage(lasers.ball, lasers.x, lasers.y, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!(e.getX() >= mouseX)  && !(e.getY() >= mouseY )) {
            hero.x = e.getX();
            hero.y = e.getY();
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!collision()) {
//            hero.y += 3;
        }

        repaint();
    }

    public boolean collision(){
//        if(e.getX() >= width && e.getY() >= height ){
//            return true;
//        }

        return false;
    }
}
