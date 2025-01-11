package org.blacksmith;

import org.blacksmith.entitytypes.GameEntity;
import org.blacksmith.entitytypes.HeroEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JPanel implements ActionListener, KeyListener {

    EntityContentManager ecm;

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

    int boardWidth = 1750;
    int boardHeight = 940;


    Game(){

        ecm = EntityContentManager.getInstance();

        GameEntity game = ecm.getGame();
        game.setBoardWidth(boardWidth);
        game.setBoardHeight(boardHeight);

        HeroEntity hero = ecm.getHero();
        hero.setX(aiStartX);
        hero.setY(aiStartY);

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
                    ecm.addEnemy(new MultipleLasers(new RandomPos().push,0, new RandomPos().dir));
                }
                if (score % 100 == 0) {
                    ecm.addEnemy(new MultipleLasers(new RandomPos().push,0, new RandomPos().dir));
                }
                if (score % 200 == 0) {
                    ecm.addEnemy(new Ai(new RandomPos().push, aiStartY));
                }
            }
        });
        scoreLoop.start();

        healthLoop = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HeroEntity hero = ecm.getHero();
                if (ecm.getHero().getHealthPercent() <= 0) {
                    healthLoop.stop();
                    laserLoop.stop();
                    scoreLoop.stop();
                    timer.stop();
                }

            }
        });
        healthLoop.start();

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        ecm.draw((Graphics2D) g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ecm.tick();
        repaint();
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