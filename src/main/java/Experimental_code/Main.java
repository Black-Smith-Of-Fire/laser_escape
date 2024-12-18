package Experimental_code;

import org.blacksmith.Hero;
import org.blacksmith.Lasers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame{

    int x;
    int y;
    int width;
    int height;

    public static void main(String[] args) {
        new Main();
    }

    public class lasers{

        int x;
        int y;

        lasers(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<lasers> laserList;

    Main(){

        laserList = new ArrayList<>();
        laserList.add(new lasers(520,520));
        placeObstacles();
//        laserList.add(new lasers(590,50));
//        laserList.add(new lasers(590,80));
//        laserList.add(new lasers(590,70));
//        laserList.add(new lasers(80,50));

        width = 29;
        height = 26;
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Experimental code");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(panel);
        pack();
        setVisible(true);
    }


    public void placeObstacles(){
        for (int i = 1; i < 9; i++) {
            laserList.add(new lasers(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));//0
            System.out.println(i + " x : " + laserList.get(i).x);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Score : ", 1600,0);
        draw((Graphics2D) g);
    }

    public void draw(Graphics2D g2d){
        for (int i = laserList.size() - 1; i >= 0; i--) {
            Image star = new ImageIcon("characters/enemy/starRed/redRect" + i +".png").getImage();
            lasers laser = laserList.get(i);
            g2d.drawImage(star, laser.x, laser.y, width, height, null);
        }
//        g2d.drawImage(ball8, 520,520, width, height, null);
//        g2d.drawImage(ball9, 520,520, width, height, null);
//        g2d.drawImage(ball2, (x + width)/2,(y + height)/2, width, height, null);
//        g2d.drawImage(ball1, x, y, width, height, null);
    }

//    public void
}
