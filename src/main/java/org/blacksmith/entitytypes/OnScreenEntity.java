package org.blacksmith.entitytypes;

public abstract class OnScreenEntity {
    public int x, y;

    int width, height;

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

    public int scaleX(float virtualWidth, int screenWidth) {
        float scaled = (x/virtualWidth)*screenWidth;

        return Math.round(scaled);
    }

    public int scaleY(float virtualHeght, int screenHeight) {
        float scaled = (y/virtualHeght)*screenHeight;
        return Math.round(scaled);
    }

    public abstract void paint();
}
