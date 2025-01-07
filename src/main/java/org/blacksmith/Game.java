package org.blacksmith;

import org.blacksmith.entitytypes.HeroEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    EntityContentManager ecm;

    ArrayList<MultipleLasers> newLasers;

    int laserPosX;
    int laserPosY;

    Random randomDir = new Random();
    int randomX = randomDir.nextInt(2);
    boolean gameOver = false;

    int aiStartX = 190;
    int aiStartY = 1000;



//    int push = 50;
//    int laserPosX = push;

    Timer timer;
    Timer laserLoop;
    Timer scoreLoop;
    Timer healthLoop;

    int score;

    Game(){

        ecm = EntityContentManager.getInstance();

        HeroEntity hero = ecm.getHero();
        hero.setX(aiStartX);
        hero.setY(aiStartY);

        laserPosX = 500;
        laserPosY = 0;

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


        timer = new Timer(1,this);
        timer.start();

        scoreLoop = new Timer(180, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score ++;
                if (score == 5) {
                    newLasers.add(new MultipleLasers(new RandomPos().push,0,new RandomPos().dir));
                }
                if (score % 100 == 0) {
                    newLasers.add(new MultipleLasers(new RandomPos().push, aiStartY, new RandomPos().dir));
                }
                if (score % 200 == 0) {
                    ecm.addEnemy(new Ai(new RandomPos().push, aiStartY, new ImageIcon("characters/enemy/ai/ai_3.png").getImage()));
                }
            }
        });
        scoreLoop.start();

        healthLoop = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HeroEntity hero = ecm.getHero();
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

                ecm.getGame().setScore(ecm.getGame().getScore()+deduct);

                if (ecm.getGame().getScore() <= 0) {
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

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        ecm.draw((Graphics2D) g);

        // TODO: we'll get rid of these when the migration to the ECM is done
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
        System.out.println ("Action performed");
        ecm.tick();
        repaint();
        System.out.println ("Action performed done");
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            ecm.getHero().setVelocityY(-2);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            ecm.getHero().setVelocityY(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            ecm.getHero().setVelocityX(-2);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            ecm.getHero().setVelocityX(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            ecm.getHero().setVelocityY(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            ecm.getHero().setVelocityY(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            ecm.getHero().setVelocityX(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            ecm.getHero().setVelocityX(0);
        }
    }
}