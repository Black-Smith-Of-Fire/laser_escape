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

    }
}
