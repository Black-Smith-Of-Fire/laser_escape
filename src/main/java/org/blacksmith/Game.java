package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    int heroPosX = 990;
    int heroPosY = 920;
    int heroWidth = 200;
    int heroHeight = 200;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);
    int boardWidth;
    int boardHeight;

    MultipleLasers multipleLasers;
    MultipleLasers lol;

    int velX;
    int velY;

    int laserPosX;
    int laserPosY;

    Random random = new Random();
//    int push = random.nextInt(0, 1750);
//    int push = 50;
//    int laserPosX = push;

    Timer timer;
    Timer laserLoop;
    Timer scoreLoop;

    Hero hero;
    int score;

    Game(){
        laserPosX = 500;
        laserPosY = 0;
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

        boardWidth = 1750;
        boardHeight = 940;

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        draw((Graphics2D) g);
        Strings((Graphics2D) g);
        multipleLasers.draw((Graphics2D) g);
        lol.draw((Graphics2D) g);
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(hero.happy, hero.x, hero.y, heroWidth, heroHeight, null);
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
                wallCollision();
            }
        }).start();
    }

    public void wallCollision(){
        if (hero.x <= boardWidth && hero.x >= 0) {
            hero.x += velX;
        } else if (hero.x <= 0) {
            hero.x += 1;
        } else if (hero.x >= boardWidth) {
            hero.x -= 1;
        }

        if (hero.y <= boardHeight && hero.y >= 0) {
            hero.y += velY;
        } else if (hero.y <= 0) {
            hero.y += 1;
        } else if (hero.y >= boardHeight) {
            hero.y -= 1;
        }
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