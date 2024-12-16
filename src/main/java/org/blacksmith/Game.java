package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    int heroPosX = 0;
    int heroPosY = 0;

    int laserPosX = 0;
    int laserPosY = 0;


    Timer timer;
    Timer laserLoop;

    int mouseX,mouseY;

    Hero hero;
    Lasers lasers;


    Game(){
        hero = new Hero(heroPosX, heroPosY);
        lasers = new Lasers(laserPosX,laserPosY);

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

        laserLoop = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                repaint();
            }
        });

        laserLoop.start();
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

    public void move(){
        lasers.x ++;
        lasers.y ++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}