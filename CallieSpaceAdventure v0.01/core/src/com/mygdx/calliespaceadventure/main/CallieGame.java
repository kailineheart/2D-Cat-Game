package com.mygdx.calliespaceadventure.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.calliespaceadventure.handlers.GameStateManager;

public class CallieGame extends ApplicationAdapter {
	
	public static final String TITLE = "Callie's Interplanetary Space Adventure"; //Callie is the name of the cat
	//virtual dimensions of the game screen regardless of actual screen size
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE =2;
	
	//variables to help keep track of time as box2d likes a fixed step amount
	public static final float STEP = 1/60f;
	private float accumulator = 0;  //keeps track of amount of time passed
	
	//game state manager
	GameStateManager GSManager;
	
	//camera and sprite batch for rendering and camera movement
	private SpriteBatch SB;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;	
	
	// methods that run the game itself
	@Override
	public void create () {  //initialize variables
		SB = new SpriteBatch();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false,V_WIDTH, V_HEIGHT);
		
		hudCamera = new OrthographicCamera();
		hudCamera.setToOrtho(false,V_WIDTH, V_HEIGHT);
		
		GSManager = new GameStateManager(this);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		accumulator += Gdx.graphics.getDeltaTime();
		while (accumulator >= STEP){
			accumulator-=STEP;
			GSManager.update(STEP);
			GSManager.render();
		}
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	//access methods for private variables outside this class
	public SpriteBatch getSpriteBatch(){
		return SB;
	}
		
	public OrthographicCamera getCamera(){
		return camera;
	}
		
	public OrthographicCamera getHUDCamera(){
		return hudCamera;
	}
}