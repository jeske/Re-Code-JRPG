package com.namone.gameStates;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;

// @ CONTAINS METHODS ALL GAME-STATES MUST HAVE @

public abstract class GameState {
	
	public GameStateManager gameStates = new GameStateManager();
	
	public abstract void draw(Player player);
	public abstract void update();

}
