package com.namone.gameStates;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.geom.Rectangle;

import com.namone.collision.WorldCollision;
import com.namone.enemies.*;
import com.namone.gameStateManager.GameStateManager;
import com.namone.movement.playerMovement;
import com.namone.player.Player;
import com.namone.worldLoad.DrawMap;
import com.namone.worldLoad.LoadWorld;

public class RunGame extends GameState {

	// STORE ENEMIES
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	// TO MOVE/UPDATE PLAYER POSITION
	private playerMovement playerMovement;
	private Enemy enemy;
	private LoadWorld loadWorld;
	// FOR COLLISION DETECTION
	private WorldCollision collision;
	private ArrayList<Rectangle> rectList;
	private boolean checkCollision;

	// ITERATE THROUGH ARRAYLIST OF ENEMIES
	public int currentEnemy;
	public int maxEnemy = 0; // CONTROLS HOW MANY ENEMIES ARE DRAWN TO SCREEN
	private Random random = new Random();

	// INITIALIZE EVERYTHING
	public RunGame(GameStateManager gsm) {
		loadWorld = new DrawMap();
		collision = new WorldCollision();
		playerMovement = new playerMovement();
		enemy = new Enemy();

		// CREATE ENEMIES

		/*
		 * MAY WANT TO RE-WORK THIS SO THEY ARE CREATED AFTER THE MAP IS
		 * DRAWN...
		 */
		createEnemies();
		// NOTE: PLAYER IS CREATED IN MAINGAME CLASS

	}

	// DRAW ALL GAME COMPONENTS - MAP, ENEMIES, PLAYER, ETC.
	public void draw(Player player) {
		
		loadWorld.draw();
		// DRAW PLAYER
		player.drawPlayer();

		// IF THE ARRAY ISN'T EMPTY - DRAW (PREVENTS INDEXOUTOFBOUNDS)
		if (!enemies.isEmpty()) {
			// DRAW EACH ITEM IN ARRAY-LIST
			for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {
				enemies.get(currentEnemy).drawEnemy();
			}
		}

	}

	// UPDATE ALL GAME OBJECTS
	public void update(Player player) {

		rectList = loadWorld.getRectList();
		// UPDATE PLAYER
		player.updatePlayer();
		
		if (!enemies.isEmpty()) {
			// DRAW EACH ITEM IN ARRAY-LIST
			for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {
				enemies.get(currentEnemy).updateEnemy(player, rectList);
			}
		}

		// IF THE ARRAY ISN'T EMPTY - UPDATE (PREVENTS INDEXOUTOFBOUNDS)
		/*if (!enemies.isEmpty()) {
			for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {

				enemies.get(currentEnemy).updateEnemy(player);
			}
		}  COMMENTED OUT JUST FOR NOW*/ 

		// PLAYER ATTACK
		player.playerAttack(enemies, maxEnemy);

		// PLAYER MOVEMENT - FIX THIS
		/*
		 * if(player.hitbox.getX() >= 0 && player.hitbox.getY() >= 0) {
		 * player.canMove = true; }
		 */
		checkCollision = collision.checkPlayerCollision(player, rectList);
		playerMovement.movePlayer(player, checkCollision);

	}

	// CREATE ENEMIES
	public void createEnemies() {
		// FOR LOOP TO ITERATE THROUGH ARRAY LIST
		for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {
			//enemies.add(new Knight(random.nextInt((((DrawMap) loadWorld).getMapHeight()*32)), random.nextInt((((DrawMap) loadWorld).getMapWidth()*32))));  // Now loads enemies all over the map
			enemies.add(new Knight(1, 1));  // For testing
		}

	}

}
