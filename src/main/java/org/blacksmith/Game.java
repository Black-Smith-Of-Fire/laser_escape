package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Game extends JFrame implements ActionListener, KeyListener {

    int heroPosX = 520;
    int heroPosY = 620;
    int heroWidth = 200;
    int heroHeight = 200;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);
    int boardWidth;
    int boardHeight;

    MultipleLasers multipleLasers;

    int velX;
    int velY;

    int laserPosX;
    int laserPosY;

    Random random = new Random();
//    int push = random.nextInt(0, 1750);
//    int push = 50;
//    int laserPosX = push;

    Timer timer;


    Hero hero;
    Lasers lasers;

    Game(){
        laserPosX = 500;
        laserPosY = 0;
        hero = new Hero(heroPosX, heroPosY);
        multipleLasers = new MultipleLasers();

//        lasers = new Lasers(laserPosX, laserPosY);

        JPanel panel = new JPanel();

        panel.setBackground(Color.black);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(panel);
        pack();


        setVisible(true);


        timer = new Timer(10,this);
        timer.start();

//        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
//        height = 930;

        boardWidth = 1750;
        boardHeight = 940;

    }

    public void paint(Graphics g){
        super.paint(g);
        draw((Graphics2D) g);
        multipleLasers.draw((Graphics2D) g);
//        lasers.draw((Graphics2D) g);
//        lasers.lol((Graphics2D) g);
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(hero.happy, hero.x, hero.y, heroWidth, heroHeight, null);
    }

    public void collision(){
        // For checking the collision in the future
        System.out.println("The position of hero is : " + hero.x);
//        if (hero.x < multipleLasers.x) {
//            System.out.println("X coordinates have intersected");
//        }
    }

    public void move(){
        if (hero.x <= boardWidth && hero.x >= 0) {
            hero.x += velX;
        }
        if (hero.y <= boardHeight && hero.y >= 0) {
            hero.y += velY;
        }
//        laserPosX += 2;
//        laserPosY += 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        if (!multipleLasers.collision(hero.x, hero.y)) {
        int push = 0;
        if (push != 1){
            multipleLasers.push();
        }
        push ++;
        multipleLasers.move();
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

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