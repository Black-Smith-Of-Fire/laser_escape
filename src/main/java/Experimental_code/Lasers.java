package Experimental_code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lasers extends JFrame{

    int x;
    int y;
    int width;
    int height;

    int boardWidth = 1860;
    int boardHeight = 1010;

    ArrayList<Items> laserList;

    Lasers(int x, int y){
        this.x = x;
        this.y = y;

        laserList = new ArrayList<>();
        laserList.add(new Items(x, y));
        placeObstacles();

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
            laserList.add(new Items(laserList.get(i - 1).x + 14, laserList.get(i - 1).y - 14));//0
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
            Items laser = laserList.get(i);
            g2d.drawImage(star, laser.x, laser.y, width, height, null);
        }
    }


    public void move(){
        if (x <= 0) {
            x += 2;
        }
        if (y <= 0) {
            y += 2;
        }
        if (x >= boardWidth) {
            x -= 2;
        }
        if (y >= boardHeight) {
            y -= 2;
        }
    }


}
