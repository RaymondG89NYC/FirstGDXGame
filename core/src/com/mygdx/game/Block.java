package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Block {
    int x1;
    int y1;
    int y2;
    int width;

    public Block(int x){
        y1 = randomY();
        y2 = y1 - 150;
        x1 = x;
        width = 50;
    }

    public int getX(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getY2(){
        return y2;
    }

    public void draw1(ShapeRenderer shape){
        shape.rect(x1, y1, width,500);
    }
    public void draw2(ShapeRenderer shape){
        shape.rect(x1, y2, width,-500);
    }

    public void update(){
        x1 -= 5;
        if(x1 < -width){
            x1 = 800;
            y1 = randomY();
            y2 = y1 - 150;
        }
    }

    public int randomY(){
        return (int)(Math.random()*(Gdx.graphics.getWidth()-350)+175);
    }



}
