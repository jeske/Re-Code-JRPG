package com.namone.player;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

import com.namone.textureLoad.LoadTextures;

public class Player {
	
	// PLAYER X & Y
	public int PlayerX =     100;
	public int PlayerY =     100;
	
	private Image              textureAtlas;
	protected SpriteSheet      spriteSheet;
	
	public Player(){	
		// SET UP PLAYER SPRITE-SHEET
		try {
			textureAtlas = new Image("resources/playerSpritesheet.png");
			System.out.println("- PLAYER SPRITE-SHEET LOADED -");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spriteSheet = new SpriteSheet(textureAtlas, 32, 32, 0, 0);

	}
	
	// DRAW THE PLAYER - DONE IN INDIVIDUAL PLAYER'S CLASS
	public void drawPlayer() {}
	
	// PLAYER ATTACK 
	public void playerAttack(ArrayList enemies) {
		// IF THE KEY IS DOWN AND THE ARRAY ISN'T EMPTY - REMOVE
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !enemies.isEmpty()){
			enemies.remove(0);
		} 
						
	}
	
	// UPDATE THE PLAYER
	public void updatePlayer(){
		isAlive();		
	}
	
	public void isAlive() {
		// TODO CHECK IF PLAYER IS ALIVE
	}

}
