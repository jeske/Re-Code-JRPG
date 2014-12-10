package com.namone.gameStates;

import com.namone.player.Player;

public class RunGame extends GameState{
	
	
	public RunGame(){
		// TODO ?
	}

	// PASS THIS THROUGH SO I CAN DRAW PLAYER
	public void draw(Player player) {
		player.drawPlayer();
	}
	
	public void update() {
		// TODO ?
	}

}
