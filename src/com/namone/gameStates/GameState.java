package com.namone.gameStates;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;

// @ CONTAINS METHODS ALL GAME-STATES MUST HAVE @

/** Use similar set up to the setup of Menu to create more menuScreens.**/

public abstract class GameState {

	public GameStateManager gameStates; //Reworked gameStateManager inheritance to carry the same var through from MainGame.class. The var is passed through when GameStateManager is init and set in the first line of each GameState class

	// NOTE: PLAYER OBJECT IS PASSED THROUGH FOR EASE OF ACCESS TO
	// PLAYER THROUGHOUT GAME PROCESS
	public abstract void draw(Player player);

	public abstract void update(Player player);

}
