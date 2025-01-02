package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    MultipleLasers multipleLasers;
    ArrayList<MultipleLasers> newLasers;
//    MultipleLasers lol;
    Hero hero;
    MultipleAi ai;

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


//    int push = 50;
//    int laserPosX = push;

    Timer timer;
    Timer laserLoop;
    Timer scoreLoop;

    int score;

    Game(){
        laserPosX = 500;
        laserPosY = 0;

        heroPosX = 500;
        heroPosY = 500;

        aiPosX = 190;
        aiPosY = 1000;
        ai = new MultipleAi(aiPosX, aiPosY);
        hero = new Hero(heroPosX, heroPosY);
        multipleLasers = new MultipleLasers(10,90,1);
        newLasers = new ArrayList<>();
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

        scoreLoop = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score ++;
                if (score % 100 == 0) {
                    newLasers.add(new MultipleLasers(new RandomPos().push,0,new RandomPos().dir));
                }
            }
        });
        scoreLoop.start();

        laserLoop = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!multipleLasers.collision(hero.x, hero.y)) {
                    int push = 0;
                    if (push != 1){
                        multipleLasers.push();
                    }
                    push ++;
                    multipleLasers.move();
                }
//                else {
//                    timer.stop();
//                    scoreLoop.stop();
//                    laserLoop.stop();
//                }

                for (int i = 0; i < newLasers.size(); i++) {

                if (!newLasers.get(i).collision(hero.x, hero.y)) {
                    int lol = 0;
                    if (lol != 1){
                        newLasers.get(i).push();
                    }
                    lol ++;
                    newLasers.get(i).move();
                }

                }
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
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        healthBar((Graphics2D) g);
        hero.draw((Graphics2D) g);
        ai.draw((Graphics2D) g);
        Strings((Graphics2D) g);
        multipleLasers.draw((Graphics2D) g);
        for (int i = 0; i < newLasers.size(); i++) {
            newLasers.get(i).draw((Graphics2D) g);
        }
//        lol.draw((Graphics2D) g);
    }

    public void Strings(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString("" + score, 1700,100);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        hero.move();
        if (!ai.collision(hero.x, hero.y)) {
            ai.follow(hero.x, hero.y);
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