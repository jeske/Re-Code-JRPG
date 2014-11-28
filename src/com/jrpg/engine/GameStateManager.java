package com.jrpg.engine;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import com.jrpg.gameStates.*;
import com.jrpg.player.Player;

public class GameStateManager {
	
	/*
	 * Game-states:
	 * 
	 * 0 - Title screen
	 * 1 - Game
	 * 2 - Pause Menu
	 * 
	 */
	
	// Current game-state-id selected (default is 0)
	private int currentState; 
	private ArrayList<GameStates> states = new ArrayList<GameStates>();	
	private final int TITLE_SCREEN = 0;
	private final int GAME = 1;
	private final int PAUSE_MENU = 2;
	
	public GameStateManager(){
		currentState = TITLE_SCREEN;
		
		// Add first game-state
		states.add(new TitleScreen());
		
		// Add second game-state
		states.add(new Game());
	}
	
	public void init(Player player){

		// Launch selected game-state
		states.get(currentState).init();
		
		// If the game has started pass player object along
		System.out.println("GAME");
		states.get(currentState).init(player);
		
	}
	
	public void update(GameStateManager gsm){

		// Update selected game-state
		states.get(currentState).update(gsm);
	}
	
	public void draw(Graphics graphicsContext, Graphics graphics){
		
		// Draw selected game-state
		states.get(currentState).draw(graphicsContext, graphics);
	}
	
	public int getCurrentState(){
		return currentState;
	}
	
	public void setCurrentState(int state){
		currentState = state;
	}

}
