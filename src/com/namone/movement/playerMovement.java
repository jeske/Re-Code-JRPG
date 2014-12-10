package com.namone.movement;
import org.lwjgl.input.Keyboard;

import com.namone.player.Player;

public class playerMovement {
	
	private int moveSpeed = 3;
	
	public void movePlayer(Player player){
		
		// MOVE UP-LEFT
		if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.PlayerX -= moveSpeed;
			player.PlayerY -= moveSpeed;
		}	
		
		// MOVE UP-RIGHT
		else if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.PlayerX += moveSpeed;
			player.PlayerY -= moveSpeed;
		}
		
		// MOVE DOWN-RIGHT
		else if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.PlayerX += moveSpeed;
			player.PlayerY += moveSpeed;
		}
		
		// MOVE DOWN-LEFT
		else if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.PlayerX -= moveSpeed;
			player.PlayerY += moveSpeed;
		}		
		
		// MOVE UP
		else if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			player.PlayerY -= moveSpeed;
		}		
		
		// MOVE DOWN
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			player.PlayerY += moveSpeed;
		}

		
		// MOVE LEFT
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.PlayerX -= moveSpeed;
		}
		
		
		// MOVE RIGHT
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.PlayerX += moveSpeed;
		}

	}

}
