package com.namone.enemies;

import static org.lwjgl.opengl.GL11.*;

import com.namone.player.Player;
import com.namone.textureLoad.LoadTextures;

public class Knight extends Enemy {
	
	LoadTextures textureLoad = new LoadTextures();

	// SET HEALTH/ID/IMAGE SPRITE FOR KNIGHT ENEMY
	public Knight(int x, int y) {
		enemyTexture = textureLoad.LoadTexture("resources/knight.png");
		movementSpeed = 1;
		viewRadius = 4; //NOT WORKING YET
		enemyX = x; // TEMPORARY
		enemyY = y; // TEMPORARY
		health = 50;
		ID = 0;		
	}
	
	public void drawEnemy() {
		
		enemyTexture.bind();
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
		{
				glTexCoord2f(0, 0);
			glVertex2f(enemyX, enemyY);
				glTexCoord2f(0, 1);
			glVertex2f(enemyX, enemyY + 64);
				glTexCoord2f(1, 1);
			glVertex2f(enemyX + 64, enemyY + 64);
				glTexCoord2f(1, 0);
			glVertex2f(enemyX + 64, enemyY);			
		}
		glEnd();
	}
	
	public void updateEnemy(Player player) {
		
		// UPPER-RIGHT OF ENEMY
		if(player.PlayerX >= enemyX && player.PlayerY <= enemyY) {
			enemyX += movementSpeed;
			enemyY -= movementSpeed;
		}
		
		// LOWER-RIGHT OF ENEMY
		else if(player.PlayerX >= enemyX && player.PlayerY >= enemyY) {
			enemyX += movementSpeed;
			enemyY += movementSpeed;
		}
		
		// UPPER-LEFT OF ENEMY
		else if(player.PlayerX <= enemyX && player.PlayerY <= enemyY) {
			enemyX -= movementSpeed;
			enemyY -= movementSpeed;
		}
		
		// LOWER-LEFT OF ENEMY
		else if(player.PlayerX <= enemyX && player.PlayerY >= enemyY) {
			enemyX -= movementSpeed;
			enemyY += movementSpeed;
		}
		
		// RIGHT OF ENEMY
		else if(player.PlayerX >= enemyX) {
			enemyX += movementSpeed;
		}
		
		// LEFT OF ENEMY
		else if(player.PlayerX <= enemyX) {
			enemyX -= movementSpeed;
		}
		
		// UP FROM ENEMY
		else if(player.PlayerY <= enemyY) {
			enemyY -= movementSpeed;
		}
		
		// DOWN FROM ENEMY
		else if(player.PlayerY >= enemyY) {
			enemyX += movementSpeed;
		}
		
		else {
			enemyX = enemyX;
			enemyY = enemyY;
		}
		
	}
	
}
