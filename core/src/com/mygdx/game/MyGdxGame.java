package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;


public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	int x = 50;
	int y  =50;
	double frames = 0;
	Bird bird;
	Block[] blocks;

	@Override
	public void create() {
		shape = new ShapeRenderer();
		bird = new Bird();

		blocks = new Block[3];
		for(int i = 0; i < 3; i++) {
			blocks[i] = new Block(i*275+600);
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			bird.clicked();
		}
		if(frames >= 120){

		}
		bird.update();
		bird.draw(shape);
		for(int i = 0; i < 3; i++) {
			blocks[i].draw1(shape);
			blocks[i].draw2(shape);
			blocks[i].update();
		}


		frames ++;
		shape.end();
	}

}
