package com.mygdx.calliespaceadventure.handlers;

import java.util.Stack;

import com.mygdx.calliespaceadventure.main.CallieGame;
import com.mygdx.calliespaceadventure.states.GameState;
import com.mygdx.calliespaceadventure.states.Play;

public class GameStateManager {
	//access to the game class itself
	private CallieGame game;
	
	//a stack that holds the game states of the game
	private Stack<GameState> gameStates;
	
	//unique number used to identify PLAY state
	public static final int PLAY = 95873524;
	
	//constructor
	public GameStateManager (CallieGame game){
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	//access method for game variable
	public CallieGame getGame(){
		return game;
	}
	
	//updates the game state
	public void update(float deltaTime){
		gameStates.peek().update(deltaTime);
	}
	
	//helps run rendering based on game state
	public void render(){
		gameStates.peek().render();
	}
	
	//sets current game state
	public void setState(int state){
		popState();
		pushState(state);
	}
	
	//push/pop states from stack based on GameState ID
	public void pushState(int state){
		gameStates.push(getState(state));
	}
	
	public void popState(){
		GameState g = gameStates.pop();
		g.dispose();
	}
	
	//method only used inside this class
	private GameState getState(int state){
		if(state == PLAY){
			return new Play(this);
		}
		return null;
	}
	
}
