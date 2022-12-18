package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    double x;
    double y;
    double playerVelocity;
    public Sprite sprite;

    public Background(double x, Texture img){
        this.x = x;
        y = 0;
        sprite = new Sprite(img);
        sprite.setScale(10, 10);
    }
    public void setPlayerVelocity(double velocity){
        playerVelocity = velocity;
    }
    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }


    public void update(){
        x -= 5;
        if(x < -100){
            x = 800;
        }
        y -= playerVelocity*0.5;
    }

}
