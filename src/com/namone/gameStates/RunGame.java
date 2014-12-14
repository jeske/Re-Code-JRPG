package com.namone.gameStates;

import java.util.ArrayList;
import java.util.Random;

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
	
	// ITERATE THROUGH ARRAYLIST OF ENEMIES
	public int currentEnemy;
	public int maxEnemy = 25; // CONTROLS HOW MANY ENEMIES ARE DRAWN TO SCREEN
	private Random random = new Random();
	
	// INITIALIZE EVERYTHING
	public RunGame(){	
		
		playerMovement = new playerMovement();
		enemy = new Enemy();
		
		// NOTE: PLAYER IS CREATED IN MAINGAME CLASS
		
		// FOR LOOP TO ITERATE THROUGH ARRAY LIST
		for (currentEnemy = 0; currentEnemy <= maxEnemy; 
				currentEnemy++) {
			enemies.add(new Knight(random.nextInt(800), random.nextInt(600)));
		}

		
	}

	// DRAW PLAYER
	public void draw(Player player) {
		player.drawPlayer();
		
		// IF THE ARRAY ISN'T EMPTY - DRAW (PREVENTS INDEXOUTOFBOUNDS)
		if(!enemies.isEmpty()){
			// DRAW EACH ITEM IN ARRAY-LIST
			for (currentEnemy = 0; currentEnemy <= maxEnemy;
					currentEnemy++) {
				enemies.get(currentEnemy).drawEnemy();
			}
		} 
	}
	
	// UPDATE PLAYER
	public void update(Player player) {	
		
		//UPDATE PLAYER
		player.updatePlayer();
		
		// IF THE ARRAY ISN'T EMPTY - UPDATE (PREVENTS INDEXOUTOFBOUNDS)
		if(!enemies.isEmpty()){
			for (currentEnemy = 0; currentEnemy <= maxEnemy;
					currentEnemy++) {
				
				enemies.get(currentEnemy).updateEnemy(player);
			}
		} 
		
		// PLAYER ATTACK
		player.playerAttack(enemies, maxEnemy);
		
		// PLAYER MOVEMENT
		playerMovement.movePlayer(player);

	}

}
