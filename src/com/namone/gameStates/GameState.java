package com.namone.gameStates;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;

// @ CONTAINS METHODS ALL GAME-STATES MUST HAVE @

public abstract class GameState {
	// NOTE: PLAYER OBJECT IS PASSED THROUGH FOR EASE OF ACCESS TO
	// PLAYER THROUGHOUT GAME PROCESS
	public abstract void draw(Player player);

	public abstract void update(Player player);

}
