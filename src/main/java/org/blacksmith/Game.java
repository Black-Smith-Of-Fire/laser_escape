package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    MultipleLasers multipleLasers;
    MultipleLasers lol;
    Hero hero;
    Ai ai;

    int heroPosX;
    int heroPosY;
    int heroWidth = 200;
    int heroHeight = 200;

    int laserPosX;
    int laserPosY;

    int aiPosX;
    int aiPosY;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);


    Random random = new Random();
//    int push = random.nextInt(0, 1750);
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
        ai = new Ai(aiPosX, aiPosY);
        hero = new Hero(heroPosX, heroPosY);
        multipleLasers = new MultipleLasers(10,90,1);
        lol = new MultipleLasers(1500,0, -1);
        score = 0;

//        lasers = new Lasers(laserPosX, laserPosY);

        this.setBackground(Color.black);
//        paintComponents(getGraphics());

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

                if (!lol.collision(hero.x, hero.y)) {
                    int push = 0;
                    if (push != 1){
                        lol.push();
                    }
                    push ++;
                    lol.move();
                }

                repaint();
            }
        });
        laserLoop.start();
//        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
//        height = 930;


    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        hero.draw((Graphics2D) g);
        Strings((Graphics2D) g);
        multipleLasers.draw((Graphics2D) g);
        lol.draw((Graphics2D) g);
    }

    public void Strings(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString("" + score, 1700,100);
    }


    public void move(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                hero.wallCollision();
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
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