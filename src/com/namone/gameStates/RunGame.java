package com.namone.gameStates;

import java.util.ArrayList;

import com.namone.enemies.*;
import com.namone.movement.playerMovement;
import com.namone.player.Player;

public class RunGame extends GameState{
	
	// STORE ENEMIES
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();	
	// TO MOVE/UPDATE PLAYER POSITION
	private playerMovement   playerMovement;
	private Enemy            enemy;
	
	// INITIALIZE EVERYTHING
	public RunGame(){
		playerMovement = new playerMovement();
		enemy = new Enemy();
		
		// CREATE ENEMIES (NOT DRAWN YET)
		enemies.add(new Knight()); // CAN MAKE RANDOM LATER
	}

	// DRAW PLAYER
	public void draw(Player player) {
		player.drawPlayer();
		enemies.get(0).drawEnemy();
	}
	
	// UPDATE PLAYER
	public void update(Player player) {		
		enemies.get(0).updateEnemy(player);
		playerMovement.movePlayer(player);
		
	}

}
