package com.namone.movement;

import org.lwjgl.input.Keyboard;

import com.namone.collision.WorldCollision;
import com.namone.player.Player;

public class playerMovement {

	public int moveSpeed = 10;

	public void movePlayer(Player player, boolean isCollide) {

		// MOVE UP-LEFT
		// IF PRESSED AND COLLIDE IS FALSE
		if (Keyboard.isKeyDown(Keyboard.KEY_W)
				&& Keyboard.isKeyDown(Keyboard.KEY_A) && !isCollide) {
			player.PlayerX -= moveSpeed;
			player.PlayerY -= moveSpeed;
			
		}

		// MOVE UP-RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_W)
				&& Keyboard.isKeyDown(Keyboard.KEY_D) && !isCollide) {
			player.PlayerX += moveSpeed;
			player.PlayerY -= moveSpeed;
		}

		// MOVE DOWN-RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)
				&& Keyboard.isKeyDown(Keyboard.KEY_D) && !isCollide) {
			player.PlayerX += moveSpeed;
			player.PlayerY += moveSpeed;
		}

		// MOVE DOWN-LEFT
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)
				&& Keyboard.isKeyDown(Keyboard.KEY_A) && !isCollide) {
			player.PlayerX -= moveSpeed;
			player.PlayerY += moveSpeed;
		}

		// MOVE UP
		else if (Keyboard.isKeyDown(Keyboard.KEY_W) && !isCollide) {
			player.PlayerY -= moveSpeed;
		}

		// MOVE DOWN
		else if (Keyboard.isKeyDown(Keyboard.KEY_S) && !isCollide) {
			player.PlayerY += moveSpeed;
		}

		// MOVE LEFT
		else if (Keyboard.isKeyDown(Keyboard.KEY_A) && !isCollide) {
			player.PlayerX -= moveSpeed;
		}

		// MOVE RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_D) && !isCollide) {
			player.PlayerX += moveSpeed;
		}

	}

}
