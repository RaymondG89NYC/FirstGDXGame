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



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture blockImg;
	Texture backgroundImg;
	ShapeRenderer shape;
	int x = 50;
	int y  =50;
	double frames = 0;
	Bird bird;
	Block[] blocks;
	Background[] backgrounds;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("GhostSprite.png");
		blockImg = new Texture("Spikes.png");
		backgroundImg = new Texture("background.png");

		shape = new ShapeRenderer();
		bird = new Bird(img);

		blocks = new Block[50];
		for(int i = 0; i < 25; i++) {
			blocks[i] = new Block(i%3*275+600, bird.getVelocity(), blockImg);
		}
		backgrounds = new Background[3];
		for(int i = 0; i < 2; i++) {
			backgrounds[i] = new Background(i*720, backgroundImg);
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.LIGHT_GRAY);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		batch.begin();

		for(int i = 0; i < 2; i++) {
			backgrounds[i].draw(batch);
			backgrounds[i].setPlayerVelocity(bird.getVelocity());
			backgrounds[i].update();
		}

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			bird.clicked();
		}

		bird.update();
		bird.draw(batch);
		for(int i = 0; i < 25; i++) {
			blocks[i].draw1(batch);
			blocks[i].draw2(batch);
			blocks[i].setPlayerVelocity(bird.getVelocity());
			blocks[i].update();
		}

		frames ++;
		batch.end();
		shape.end();
	}

}
