package com.jrpg.engine;

import org.newdawn.slick.Graphics;

import com.jrpg.player.Player;

public abstract class GameStates {
	
	/*
	 * Blue-print for ALL game-states we will create.
	 * This class holds all methods & variables
	 * each game-state will have.
	 * 
	 */
	
	// Methods each game-state will have
	public abstract void init();
	public abstract void init(Player player);
	public abstract void update(GameStateManager gsm);
	public abstract void draw(Graphics graphicsContext, Graphics graphics);	

}
