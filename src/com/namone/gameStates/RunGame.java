package com.namone.gameStates;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

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
		
		// NOTE: PLAYER IS CREATED IN MAINGAME CLASS
		
		
		/*
		 * @ NOTE @ 
		 * 
		 * WILL CREATE FOR LOOP TO ITERATE THROUGH ALL ENEMIES
		 * IN ARRAYLIST AND DRAW/UPDATE THEM. HOWEVER, FOR NOW,
		 * I AM JUST MAKING THEM INDIVIDUALY. 
		 * 
		 */
		// CREATE ENEMIES (NOT DRAWN YET)
		enemies.add(new Knight(300, 95)); // CAN MAKE RANDOM LATER
		// CREATE ENEMIES (NOT DRAWN YET)
		enemies.add(new Knight(400, 95)); // CAN MAKE RANDOM LATER
		
	}

	// DRAW PLAYER
	public void draw(Player player) {
		player.drawPlayer();
		
		// IF THE ARRAY ISN'T EMPTY - DRAW (PREVENTS INDEXOUTOFBOUNDS)
		if(!enemies.isEmpty()){
			enemies.get(0).drawEnemy();
			enemies.get(1).drawEnemy();
		} 
	}
	
	// UPDATE PLAYER
	public void update(Player player) {	
		
		//UPDATE PLAYER
		player.updatePlayer();
		
		// IF THE ARRAY ISN'T EMPTY - UPDATE (PREVENTS INDEXOUTOFBOUNDS)
		if(!enemies.isEmpty()){
			enemies.get(0).updateEnemy(player);
			enemies.get(1).updateEnemy(player);
		} 
		
		// PLAYER ATTACK
		player.playerAttack(enemies);
		
		// PLAYER MOVEMENT
		playerMovement.movePlayer(player);

	}

}
