package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    ArrayList<MultipleLasers> newLasers;
    ArrayList<MultipleAi> ai;

    Hero hero;


    int heroPosX;
    int heroPosY;

    int laserPosX;
    int laserPosY;

    int aiPosX;
    int aiPosY;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);
    int healthScore = 100;
    int healthWidth = 500;
    boolean gameOver = false;


//    int push = 50;
//    int laserPosX = push;

    Timer timer;
    Timer laserLoop;
    Timer scoreLoop;
    Timer healthLoop;

    int score;

    Game(){
        laserPosX = 500;
        laserPosY = 0;

        heroPosX = 500;
        heroPosY = 500;

        aiPosX = 190;
        aiPosY = 1000;
        hero = new Hero(heroPosX, heroPosY);
        newLasers = new ArrayList<>();
        ai = new ArrayList<>();
        score = 0;

        this.setBackground(Color.black);

        JFrame jFrame = new JFrame();
        jFrame.addKeyListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Escape the lasers");
        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        jFrame.add(this);
        jFrame.pack();


        jFrame.setVisible(true);


        timer = new Timer(10,this);
        timer.start();

        scoreLoop = new Timer(180, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score ++;
                if (score == 5) {
                    newLasers.add(new MultipleLasers(new RandomPos().push,0,new RandomPos().dir));
                }
                if (score % 100 == 0) {
                    newLasers.add(new MultipleLasers(new RandomPos().push, aiPosY, new RandomPos().dir));
                }
                if (score % 200 == 0) {
                    ai.add(new MultipleAi(new RandomPos().push,aiPosY));
                }
            }
        });
        scoreLoop.start();

        healthLoop = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int deduct = 0;
                int scoreDeduct = 0;


                for (int i = 0; i < newLasers.size(); i++) {
                if (newLasers.get(i).collision(hero.x, hero.y)) {
                    deduct = -50;
                    scoreDeduct = -10;
                }
                else {
                        deduct = 0;
                    scoreDeduct = 0;
                    }
                }

                healthWidth += deduct;
                healthScore += scoreDeduct;

                for (int i = 0; i < ai.size(); i++) {
                    if (ai.get(i).collision(hero.x, hero.y)) {
                        deduct = -50;
                        scoreDeduct = -10;
                    }
                    else {
                        deduct = 0;
                        scoreDeduct = 0;
                    }
                    healthWidth += deduct;
                    healthScore += scoreDeduct;
                    System.out.println("Width is : " + healthWidth);
                    System.out.println("Score is : " + healthScore);
                }


                if (healthScore < 0) {
                    healthLoop.stop();
                    laserLoop.stop();
                    scoreLoop.stop();
                    timer.stop();
                }

            }
        });
        healthLoop.start();

        laserLoop = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    boolean push = true;
                    if (push ){
                        for (int i = 0; i < newLasers.size(); i++) {
                            newLasers.get(i).push();
                            newLasers.get(i).move();
                        }
                    }
                    push = false;

                repaint();
            }
        });
        laserLoop.start();
//        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
//        height = 930;


    }

    public void healthBar(Graphics2D g){
        g.setColor(Color.green);
        g.fillRect(30,30,healthWidth,50);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString(healthScore + " %",560,65);
        if (gameOver) {
            g.drawString(0 + " %",0,65);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        healthBar((Graphics2D) g);
        hero.draw((Graphics2D) g);
        for (int i = 0; i < ai.size(); i++) {
            ai.get(i).draw((Graphics2D) g);
        }
        Strings((Graphics2D) g);
        for (int i = 0; i < newLasers.size(); i++) {
            newLasers.get(i).draw((Graphics2D) g);
        }

    }

    public void Strings(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString("" + score, 1700,100);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        hero.move();
        for (int i = 0; i < ai.size(); i++) {
            ai.get(i).follow(hero.x,hero.y);
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            hero.velY = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            hero.velY = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            hero.velX = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            hero.velX = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            hero.velY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            hero.velY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            hero.velX = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            hero.velX = 0;
        }
    }
}