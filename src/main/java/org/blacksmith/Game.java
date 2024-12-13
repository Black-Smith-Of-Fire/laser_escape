package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game extends JFrame implements MouseMotionListener {

    Image hero;

    Game(){

        hero = new ImageIcon("src/d'blacksmith.png").getImage();

        JPanel panel = new JPanel();
        panel.addMouseMotionListener(this);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escape the lasers");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(hero,20,20,null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("You have moved X : " + e.getX());
        System.out.println("And for YYYYY : " + e.getY());
    }
}
