package com.namone.enemies;

import static org.lwjgl.opengl.GL11.*;

import com.namone.checkDistance.DistanceDetect;
import com.namone.player.Player;
import com.namone.textureLoad.LoadTextures;

public class Knight extends Enemy {

	LoadTextures textureLoad = new LoadTextures();

	// SET HEALTH/ID/IMAGE SPRITE FOR KNIGHT ENEMY
	public Knight(int x, int y) {
		enemyTexture = textureLoad.LoadTexture("resources/knight.png");
		movementSpeed = 1.0f; // MOVEMENT SPEED OF ENEMIES!
		distanceDetect = new DistanceDetect();
		viewRadius = 120;
		enemyX = x; // TEMPORARY
		enemyY = y; // TEMPORARY WILL HOPEFULLY BE RANDOM IN FUTURE
		health = 50; // HEALTH OF ENEMY
		ID = 0; // ID OF ENEMY

	}

	public void drawEnemy() {

		// BIND ENEMY TEXTURE TO SQUARE (LOADED IN ENEMY.CLASS)
		enemyTexture.bind();
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(enemyX, enemyY);
			glTexCoord2f(0, 1);
			glVertex2f(enemyX, enemyY + 64); // CONTROL SIZE OF SPRITE HERE!
			glTexCoord2f(1, 1);
			glVertex2f(enemyX + 64, enemyY + 64);
			glTexCoord2f(1, 0);
			glVertex2f(enemyX + 64, enemyY);
		}
		glEnd();
	}

	public void updateEnemy(Player player) {

		// CREATE A NEW KNIGHT ENEMY AND CHECK RANGE PASSING
		// ITSELF INTO IT ('THIS')
		inRange = distanceDetect.checkEnemySight(player, this);

		// UPPER-RIGHT OF ENEMY
		if (player.PlayerX >= enemyX && player.PlayerY <= enemyY && inRange) {
			enemyX += movementSpeed;
			enemyY -= movementSpeed;
		}

		// LOWER-RIGHT OF ENEMY
		else if (player.PlayerX >= enemyX && player.PlayerY >= enemyY
				&& inRange) {
			enemyX += movementSpeed;
			enemyY += movementSpeed;
		}

		// UPPER-LEFT OF ENEMY
		else if (player.PlayerX <= enemyX && player.PlayerY <= enemyY
				&& inRange) {
			enemyX -= movementSpeed;
			enemyY -= movementSpeed;
		}

		// LOWER-LEFT OF ENEMY
		else if (player.PlayerX <= enemyX && player.PlayerY >= enemyY
				&& inRange) {
			enemyX -= movementSpeed;
			enemyY += movementSpeed;
		}

		// RIGHT OF ENEMY
		else if (player.PlayerX >= enemyX && inRange) {
			enemyX += movementSpeed;
		}

		// LEFT OF ENEMY
		else if (player.PlayerX <= enemyX && inRange) {
			enemyX -= movementSpeed;
		}

		// UP FROM ENEMY
		else if (player.PlayerY <= enemyY && inRange) {
			enemyY -= movementSpeed;
		}

		// DOWN FROM ENEMY
		else if (player.PlayerY >= enemyY && inRange) {
			enemyX += movementSpeed;
		}

		else {
			enemyX = enemyX;
			enemyY = enemyY;
		}

	}

}
