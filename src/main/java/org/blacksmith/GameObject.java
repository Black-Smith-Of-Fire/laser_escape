package org.blacksmith;

import java.awt.*;

public abstract class GameObject {
    protected int x,y;
//    protected ID id;
    protected int velX, velY;

//    GameObject(int x, int y, ID id){
//        this.x = x;
//        this.y = y;
//        this.id = id;
//    }
    public abstract void tick(); // TODO : find a way to do without this method
    public abstract void render(Graphics g); // TODO: find a way to do without

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

//    public void setId(ID id){
//        this.id = id;
//    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
//    public ID getId(){
//        return id;
//    }
}
