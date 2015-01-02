package com.namone.checkDistance;

import java.util.ArrayList;

import com.namone.enemies.Enemy;
import com.namone.player.Player;

public class DistanceDetect {

	private boolean inRange;
	private float deltaX;
	private float deltaY;
	private float pX;
	private float pY;
	private float eX;
	private float eY;
	private float distance;

	// CHECK IF PLAYER IS IN ENEMY SIGHT RANGE
	// ABLE TO PASS IN ANY PLAYER/ENEMY (AND IT'S RANGE, POSITION, ETC.) TO
	// CHECK
	public boolean checkEnemySight(Player player, Enemy Enemy) {
		// CALCULATE THE DIFFERENCE BETWEEN PLAYER POSITION & ENEMY POSITION
//TODO DISTANCE FORUMAL 
		pX = player.PlayerX;
		pY = player.PlayerY;
		eX = Enemy.enemyX;
		eY = Enemy.enemyY;
		distance = (float) Math.sqrt(Math.pow((pX - eX), 2) + Math.pow((pY - eY), 2));  //Distance forumal. creates a more circular area of range
		// EVAULATE
		if (distance < Enemy.viewRadius) { 
			inRange = true;
		}	else {
			inRange = false;
		}

		// RETURN
		return inRange;

	}

	public boolean checkPlayerAttackRange(Player player,
			ArrayList<Enemy> Enemy, int maxEnemy) {

		/*
		 * FOR EACH ENEMY IN THE ARRAY LIST CHECK IF IS IN RANGE... THEN MAKE A
		 * DECISION
		 * 
		 * - ALMOST WORKING -
		 * 
		 * DETECTS INRANGE FOR ONLY 1 ENEMY. NOT SURE WHY.
		 */

		for (int i = 0; i <= maxEnemy; i++) {
			float playerDeltaX = Enemy.get(i).enemyX - player.PlayerX;
			float playerDeltaY = Enemy.get(i).enemyY - player.PlayerY;
			
			if (playerDeltaX <= player.playerRange
					&& playerDeltaX >= -player.playerRange) {
				inRange = true;
			}

			else if (playerDeltaY >= player.playerRange
					&& playerDeltaY <= -player.playerRange) {
				inRange = true;
			}

			else {
				inRange = false;
			}

		}

		return inRange;
	}

}
