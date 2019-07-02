package com.mygdx.calliespaceadventure.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.calliespaceadventure.handlers.GameStateManager;
import com.mygdx.calliespaceadventure.main.CallieGame;

public abstract class GameState {
	
	//variables for game state management
	protected GameStateManager GSManager;
	protected CallieGame game;
	
	//camera and sprite batch for rendering and camera movement
	protected SpriteBatch SB;
	protected OrthographicCamera camera;
	protected OrthographicCamera hudCamera;
	
	protected GameState(GameStateManager gsm){
		this.GSManager = gsm;
		game = gsm.getGame();
		SB = game.getSpriteBatch();
		camera = game.getCamera();
		hudCamera = game.getHUDCamera();
	}
	
	public abstract void handleInput();
	public abstract void update(float deltaTime);
	public abstract void render();
	public abstract void dispose();
}
