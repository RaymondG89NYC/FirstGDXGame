package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bird {
    int x;
    int y;
    double velocity;
    double acceleration;
    double speed;
    int size;
    //static variables below makes sure that player cant hold down mouse
    static int count = 0;
    static boolean isClicked = false;
    public Sprite sprite;

    public Bird(Texture img){
        x = 50;
        y = Gdx.graphics.getHeight()/2;
        size = 5;
        velocity = 0;
        acceleration = -0.40;
        sprite = new Sprite(img);
        sprite.setScale(size);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getVelocity(){return velocity;}
    public double getAcceleration(){return acceleration;}

    public void setAcceleration(double x){acceleration = x;}

    public void update(){
        velocity += acceleration;
//        y += velocity;
        count ++;
        if(count > 4){
            count = 0;
            isClicked = false;
        }
        if(y < 0){
            y = 300;
            velocity = 0;
        }
    }

    public void clicked(){
        if(!isClicked) {
            velocity = 8;
            isClicked = true;
        }
    }

    public void draw(SpriteBatch batch){
        sprite.setPosition(x, y);
        sprite.draw(batch);
        if(velocity>4){
            sprite.setRotation(5*4);
        }
        else {
            sprite.setRotation(5 * (int) velocity);
        }
//        sprite.rotate(10*(int)velocity);
    }

}
