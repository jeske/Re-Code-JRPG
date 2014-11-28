package com.jrpg.input;

import org.lwjgl.input.Keyboard;

import com.jrpg.player.Player;

public class KeyboardListener {
	
	/*
	 * Player control/movement
	 * 
	 * @ May need to be refined in the future for smoother movement @
	 * 
	 */
	private int moveSpeed = 2;
	
	public void KeyboardListener(Player player){
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.playerY -= moveSpeed;
			player.playerX += moveSpeed;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.playerY -= moveSpeed;
			player.playerX -= moveSpeed;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.playerY += moveSpeed;
			player.playerX += moveSpeed;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.playerY += moveSpeed;
			player.playerX -= moveSpeed;
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			player.playerY -= moveSpeed;
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			player.playerY += moveSpeed;
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.playerX += moveSpeed;
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.playerX -= moveSpeed;
		}
		
		
		
		
	}

}
