package org.blacksmith.entitytypes;

import java.awt.*;

public abstract class OnScreenEntity extends Entity {
    public int x, y;

    Image image;

    int width, height;

    int velocityX;
    int velocityY;

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
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int scaleX(float virtualWidth, int screenWidth) {
        float scaled = (x/virtualWidth)*screenWidth;

        return Math.round(scaled);
    }

    public int scaleY(float virtualHeght, int screenHeight) {
        float scaled = (y/virtualHeght)*screenHeight;
        return Math.round(scaled);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void move() {
        setX(getX()+velocityX);
        setY(getY()+velocityY);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    };
}
