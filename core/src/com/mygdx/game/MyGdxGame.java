package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;

import java.awt.*;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer shape;
	int x = 50;
	int y  =50;
	double frames = 0;
	Bird bird;
	Block[] blocks;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("GhostSprite.png");

		shape = new ShapeRenderer();
		bird = new Bird(img);

		blocks = new Block[3];
		for(int i = 0; i < 3; i++) {
			blocks[i] = new Block(i*275+600);
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.GRAY);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		batch.begin();

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			bird.clicked();
		}
		if(frames >= 120){

		}
		bird.update();
		bird.draw(batch);
		for(int i = 0; i < 3; i++) {
			blocks[i].draw1(shape);
			blocks[i].draw2(shape);
			blocks[i].update();
		}
		frames ++;
		batch.end();
		shape.end();
	}

}
