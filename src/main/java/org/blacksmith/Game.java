package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JFrame implements ActionListener, KeyListener {

    int heroPosX = 120;
    int heroPosY = 120;
    int heroWidth = 200;
    int heroHeight = 200;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);
    int boardWidth;
    int boardHeight;

    int velX;
    int velY;


    Random random = new Random();
    int push = random.nextInt(0, 1750);
//    int push = 50;
    int laserPosX = push;
    int laserPosY = 0;
    int laserWidth = 50;
    int laserHeight = 50;

    ArrayList<Lasers> laserList;
    Timer timer;
    Timer laserLoop;


    Hero hero;


    Game(){
        hero = new Hero(heroPosX, heroPosY);

        JPanel panel = new JPanel();

        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(panel);
        pack();


        setVisible(true);


        timer = new Timer(10,this);
        timer.start();



        laserLoop = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeObstacles();
                repaint();
            }
        });
        laserLoop.start();


//        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
//        height = 930;

        boardWidth = 1750;
        boardHeight = 940;

        laserList = new ArrayList<>();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Score : ", 1600,0);
        draw((Graphics2D) g);
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(hero.happy, hero.x, hero.y, heroWidth, heroHeight, null);
        for (int i = 0; i < laserList.size(); i++) {
            Lasers lasers = laserList.get(i);
            g2d.drawImage(lasers.ball, lasers.x, lasers.y, laserWidth, laserHeight, null);
        }
    }

    public void collision(){

    }

    public void move(){
        if (hero.x <= boardWidth && hero.x >= 0) {
            hero.x += velX;
        }
        if (hero.y <= boardHeight && hero.y >= 0) {
            hero.y += velY;
        }
    }

    public void placeObstacles(){
        Lasers lasers = new Lasers(laserPosX,laserPosY);
        Random randomx = new Random();
        lasers.x = randomx.nextInt(0,1750);
        laserList.add(lasers);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < laserList.size(); i++) {
            Lasers lasers = laserList.get(i);
            lasers.move();
            if (laserPosX == push) {
                if (randomX == 0) {
                    lasers.x += 2;
                }
                else{
                    lasers.x -= 2;
                }
                repaint();
            }
        }
        move();
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            velY = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            velY = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            velX = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            velX = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            velY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            velY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            velX = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            velX = 0;
        }
    }
}