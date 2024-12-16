package org.blacksmith;
//Todo : work on the collision , it is not working with mouselistener


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    int heroPosX = 20;
    int heroPosY = 20;
    int heroWidth = 200;
    int heroHeight = 200;

    int laserPosX = 0;
    int laserPosY = 0;
    int laserWidth = 50;
    int laserHeight = 50;

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
                lasers.move();
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
        g2d.drawImage(hero.happy, hero.x, hero.y, heroWidth, heroHeight, null);
        g2d.drawImage(lasers.ball, lasers.x, lasers.y, laserWidth, laserHeight, null);
    }

    public boolean collision(){
        return hero.x <= lasers.x + laserWidth && // when the hero hits the lasers
                hero.y >= lasers.y + laserHeight &&
                hero.x >= lasers.x + laserWidth &&
                hero.y <= lasers.y + laserHeight;
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
        collision();
        if (collision()) {
            System.out.println("The position of the laser at X is : " + (lasers.x + laserWidth));
            System.out.println("The position of the laser at Y is : " + (lasers.x + laserWidth));
            System.out.println("Hero at X is  : " + hero.x);
            System.out.println("Hero at Y is : " + hero.y);
        }
    }

}