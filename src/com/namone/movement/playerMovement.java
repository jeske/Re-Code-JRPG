package com.namone.movement;

import org.lwjgl.input.Keyboard;

import com.namone.player.Player;

public class playerMovement {

	private int moveSpeed = 3;
	private int runSpeed = 5;

	public void movePlayer(Player player) {

		// MOVE UP-LEFT
		if (Keyboard.isKeyDown(Keyboard.KEY_W)
				&& Keyboard.isKeyDown(Keyboard.KEY_A) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX -= runSpeed;
				player.PlayerY -= runSpeed;
			} else {
				player.PlayerX -= moveSpeed;
				player.PlayerY -= moveSpeed;
			}
		}

		// MOVE UP-RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_W)
				&& Keyboard.isKeyDown(Keyboard.KEY_D) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX += runSpeed;
				player.PlayerY -= runSpeed;
			} else {
				player.PlayerX += moveSpeed;
				player.PlayerY -= moveSpeed;
			}
		}

		// MOVE DOWN-RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)
				&& Keyboard.isKeyDown(Keyboard.KEY_D) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX += runSpeed;
				player.PlayerY += runSpeed;
			} else {
				player.PlayerX += moveSpeed;
				player.PlayerY += moveSpeed;
			}
		}

		// MOVE DOWN-LEFT
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)
				&& Keyboard.isKeyDown(Keyboard.KEY_A) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX -= runSpeed;
				player.PlayerY += runSpeed;
			} else {
				player.PlayerX -= moveSpeed;
				player.PlayerY += moveSpeed;
			}
		}

		// MOVE UP
		else if (Keyboard.isKeyDown(Keyboard.KEY_W) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerY -= runSpeed;
			} else {
				player.PlayerY -= moveSpeed;
			}
		}

		// MOVE DOWN
		else if (Keyboard.isKeyDown(Keyboard.KEY_S) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerY += runSpeed;
			} else {
				player.PlayerY += moveSpeed;
			}		}

		// MOVE LEFT
		else if (Keyboard.isKeyDown(Keyboard.KEY_A) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX -= runSpeed;
			} else {
				player.PlayerX -= moveSpeed;
			}
		}

		// MOVE RIGHT
		else if (Keyboard.isKeyDown(Keyboard.KEY_D) && player.canMove) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				player.PlayerX += runSpeed;
			} else {
				player.PlayerX += moveSpeed;
			}
		}

	}

}
