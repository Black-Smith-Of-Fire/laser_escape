package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    Image hero;
    Image enemy;
    int x = 0;
    int y = 0;
    int velX = 0;
    int velY = 0;
    int width;
    int height;
    Timer timer;

    Game(){

        hero = new ImageIcon("characters/hero/happy_hero.png").getImage();
        enemy = new ImageIcon("characters/enemy/ball_obstacle.png").getImage();

        timer = new Timer(10,this);
        timer.start();

        JPanel panel = new JPanel();
        panel.addMouseMotionListener(this);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        width = getWidth();
        height = getHeight();


        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(hero,x,y,null);
        g2d.drawImage(enemy,velX,velY,null);
//        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        System.out.println("The height of frame is : " + height);

        System.out.println("The width of frame is : " + width);

//        if (x == width) {
//        if (x == width) {
//            velX =
//            velX =
//        }
//
//        if (y == height) {
//            velY = 0;
//        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        velX ++;
        velY ++;
        repaint();
    }
}
