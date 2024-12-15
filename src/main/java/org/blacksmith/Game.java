package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements MouseMotionListener, ActionListener {

    Image enemy;
    int x = 0;
    int y = 0;
    int velX;
    int velY;
    double width;
    double height;
    Timer timer;

    Hero hero;

    Game(){
        hero = new Hero(x,y);
//        enemy = new ImageIcon("characters/enemy/ball_obstacle.png").getImage();

        timer = new Timer(10,this);
        timer.start();

        JPanel panel = new JPanel();
        panel.addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(panel);
        pack();


        setVisible(true);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();

        /* code that may be helpful
        "GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
Rectangle bounds = env.getMaximumWindowBounds();
System.out.println("Screen Bounds: " + bounds );
        * */
        width = 1740; // TODO : Remove this hard coded value, and get the frame's actual width
        height = 930;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(hero.happy , hero.x, hero.y,null);
//        g2d.drawImage(enemy,velX,velY,null);
//        if (collision()) {
//            g2d.drawImage(hero,0,0,null);
//            repaint();
//        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        if (!collision()) {
//            x = e.getX();
//            y = e.getY();
//        }

//        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!collision()) {
            hero.y += 3;
        }

//        hero.y += velY;
        repaint();
    }

    public boolean collision(){
        if(hero.y >= height ){
            System.out.println("collided at X " + width);
            return true;
        }

//        if(y == velY){
//            System.out.println("collided at Y " + y);
//            return true;
//        }
        return false;
    }
}
