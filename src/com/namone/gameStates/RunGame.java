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
import com.namone.worldLoad.LoadWorld;

public class RunGame extends GameState {

	// STORE ENEMIES
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	// TO MOVE/UPDATE PLAYER POSITION
	private playerMovement playerMovement;
	private Enemy enemy;
	private LoadWorld loadWorld;

	// ITERATE THROUGH ARRAYLIST OF ENEMIES
	public int currentEnemy;
	public int maxEnemy = 0; // CONTROLS HOW MANY ENEMIES ARE DRAWN TO SCREEN
	private Random random = new Random();

	// INITIALIZE EVERYTHING
	public RunGame() {

		playerMovement = new playerMovement();
		enemy = new Enemy();
		loadWorld = new LoadWorld();
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
		// DRAW MAP
		loadWorld.drawMap();
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

		// UPDATE PLAYER
		player.updatePlayer();

		// IF THE ARRAY ISN'T EMPTY - UPDATE (PREVENTS INDEXOUTOFBOUNDS)
		if (!enemies.isEmpty()) {
			for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {

				enemies.get(currentEnemy).updateEnemy(player);
			}
		}

		// PLAYER ATTACK
		player.playerAttack(enemies, maxEnemy);

		// PLAYER MOVEMENT - FIX THIS
		/*
		 * if(player.hitbox.getX() >= 0 && player.hitbox.getY() >= 0) {
		 * player.canMove = true; }
		 */

		playerMovement.movePlayer(player);

	}

	// CREATE ENEMIES
	public void createEnemies() {
		// FOR LOOP TO ITERATE THROUGH ARRAY LIST
		for (currentEnemy = 0; currentEnemy <= maxEnemy; currentEnemy++) {
			enemies.add(new Knight(random.nextInt(800), random.nextInt(600)));
		}

	}

}
