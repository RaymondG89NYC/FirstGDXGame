package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Block {
    double x1;
    double y1;
    double y2;
    int width;
    public Sprite topBlock;
    public Sprite bottomBlock;
    double playerVelocity;
    public Block(int x, double speed, Texture img){
        y1 = randomY();
        y2 = y1 - 150;
        x1 = x;
        width = 5;
        topBlock = new Sprite(img);
        topBlock.setScale(width, 5);
        bottomBlock = new Sprite(img);
        bottomBlock.setScale(width, 5);
        playerVelocity = speed;
    }

    public double getX(){
        return x1;
    }
    public double getY1(){
        return y1;
    }
    public double getY2(){
        return y2;
    }
    public void setPlayerVelocity(double velocity){playerVelocity = velocity;};

    public void draw1(SpriteBatch batch){
        topBlock.setPosition((float) x1, (float) y1);
        topBlock.draw(batch);
    }
    public void draw2(SpriteBatch batch){
        topBlock.setPosition((float) x1, (float) y2);
        topBlock.draw(batch);
    }

    public void update(){
        x1 -= 5;
        if(x1 < 5*-width){
            x1 = 800;
            y1 = randomY()-500;
            y2 = randomY()-500;
        }
        y1 -= playerVelocity;
        y2 -= playerVelocity;
    }

    public int randomY(){
        return (int)(Math.random()*(5000));
    }



}
