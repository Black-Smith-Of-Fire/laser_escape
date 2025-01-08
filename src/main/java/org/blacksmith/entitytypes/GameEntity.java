package org.blacksmith.entitytypes;

import java.awt.*;

public class GameEntity extends OnScreenEntity {
    int score;
    int maxScore = 100;

    int healthWidth;

    int boardWidth;
    int boardHeight;

    public GameEntity() {
        score = 0;
        healthPercent = 100;
        healthWidth = 500;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void tick() {
    }

    @Override
    public void draw(Graphics2D g2d) {

        // draw the healthbar
        g2d.setColor(Color.green);
        g2d.fillRect(30,30,healthWidth*healthPercent/100,50);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString(healthPercent + " %",560,65);
        if (healthPercent<=0) {
            g2d.drawString(0 + " %",0,65);
        }
    }
}
