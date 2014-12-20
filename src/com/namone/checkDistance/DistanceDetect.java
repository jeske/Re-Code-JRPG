package com.namone.checkDistance;

import java.util.ArrayList;

import com.namone.enemies.Enemy;
import com.namone.player.Player;

public class DistanceDetect {

	private boolean inRange;
	private int deltaX;
	private int deltaY;

	// CHECK IF PLAYER IS IN ENEMY SIGHT RANGE
	// ABLE TO PASS IN ANY PLAYER/ENEMY (AND IT'S RANGE, POSITION, ETC.) TO
	// CHECK
	public boolean checkEnemySight(Player player, Enemy Enemy) {
		// CALCULATE THE DIFFERENCE BETWEEN PLAYER POSITION & ENEMY POSITION
		deltaX = Enemy.enemyX - player.PlayerX;
		deltaY = Enemy.enemyY - player.PlayerY;

		// EVAULATE
		if (deltaX <= Enemy.viewRadius && deltaX >= -Enemy.viewRadius) {
			inRange = true;
		}

		else if (deltaY >= Enemy.viewRadius && deltaY >= -Enemy.viewRadius) {
			inRange = true;
		}

		else {
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
			int playerDeltaX = Enemy.get(i).enemyX - player.PlayerX;
			int playerDeltaY = Enemy.get(i).enemyY - player.PlayerY;
			
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
