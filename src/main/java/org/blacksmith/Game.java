package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    int heroPosX = 0;
    int heroPosY = 0;

    int velX = 2;
    int velY = 0;

    Image ballImg;
    Timer timer;
    Timer lasers_timer;

    int mouseX,mouseY;

    Hero hero;

    ArrayList<Lasers> lasers;

    Game(){
        hero = new Hero(heroPosX, heroPosY);
        ballImg = new ImageIcon("characters/enemy/ball_lasers.png").getImage();

        lasers = new ArrayList<>();

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

        lasers_timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shootObs();
            }
        });
        lasers_timer.start();

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
        for (int i = 0; i < lasers.size(); i++) {
            System.out.println("yyyyyyyyyyyyyyyyyyy");
            Lasers laser = lasers.get(i);
            g2d.drawImage(laser.ball, laser.x, laser.y,300,300, null);
        }
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
        for (int i = 0; i < lasers.size(); i++) {
            System.out.println("Action perffffffffffffffffffff");
            Lasers laser = lasers.get(i);
            laser.x += velX;
            laser.y += velY;
        }
        repaint();
    }

    public void shootObs(){
        System.out.println("XXXXXXXXXXXXXXX");
        Lasers laser = new Lasers(ballImg);
        lasers.add(laser);
    }

//    public boolean collision(){
//        if(e.getX() >= width && e.getY() >= height ){
//            return true;
//        }

//        return false;
//    }
}
