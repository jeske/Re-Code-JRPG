package com.namone.enemies;

import com.namone.player.Player;

public class DistanceDetect extends Enemy {

	private boolean inRange = false;
	private int deltaX;
	private int deltaY;

	public DistanceDetect() {

	}

	// CHECK IF PLAYER IS IN ENEMY ATTACK RANGE
	// ABLE TO PASS IN ANY ENEMY (AND IT'S RANGE, POSITION, ETC.) TO CHECK
	// HAVE NOT TESTED WITH MULTIPLE ENEMIES
	public boolean checkRange(Player player, Enemy enemy) {

		deltaX = enemy.enemyX - player.PlayerX;
		deltaY = enemy.enemyY - player.PlayerY;

		if (deltaX <= enemy.viewRadius && deltaX >= -enemy.viewRadius) {
			inRange = true;
		}

		else if (deltaY >= enemy.viewRadius && deltaY >= -enemy.viewRadius) {
			inRange = true;
		}

		else {
			inRange = false;
		}

		return inRange;

	}

}
