package org.blacksmith.entitytypes;

import org.blacksmith.EntityContentManager;
import org.blacksmith.components.Animator;

import java.awt.*;

public abstract class OnScreenEntity extends Entity {
    Animator animator;

    public int x, y;

    int velocityX;
    int velocityY;

    int healthPercent;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        if (animator == null) {
            return 0;
        }
        return animator.getWidth();
    }

    public int getHeight() {
        if (animator == null) {
            return 0;
        }

        return animator.getHeight();
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getHealthPercent() {
        return healthPercent;
    }

    public void setHealthPercent(int healthPercent) {
        this.healthPercent = healthPercent;
    }

    public int scaleX(float virtualWidth, int screenWidth) {
        float scaled = (x/virtualWidth)*screenWidth;

        return Math.round(scaled);
    }

    public int scaleY(float virtualHeght, int screenHeight) {
        float scaled = (y/virtualHeght)*screenHeight;
        return Math.round(scaled);
    }

    public void move() {
        wallCollision();
        setX(getX()+velocityX);
        setY(getY()+velocityY);
    }

    void wallCollision() {
        GameEntity game = EntityContentManager.getInstance().getGame();
        int boardWidth = game.getBoardWidth();
        int boardHeight = game.getBoardHeight();

        if (x<=0) {
            setX(5);
        }
        if (x>= boardWidth) {
            setX(boardWidth-5);
        }
        if (y<=0) {
            setY(5);
        }
        if (y>=boardHeight) {
            setY(boardHeight-5);
        }
    }

    public Animator getAnimator() {
        return animator;
    }

    public void setAnimator(Animator animator) {
        this.animator = animator;
    }


    public void draw(Graphics2D g2d) {
        g2d.drawImage(animator.getImage(), x, y, null);
    };
}
