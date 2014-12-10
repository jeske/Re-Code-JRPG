package com.namone.player;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;
import com.namone.textureLoad.LoadTextures;

public class Player {
	
	private LoadTextures textureLoad = new LoadTextures();
	private Texture      playerTexture;
	
	// PLAYER X & Y
	public int PlayerX =     100;
	public int PlayerY =     100;
	
	
	public Player(){
		playerTexture = textureLoad.LoadTexture("resources/tempPlayer.png");
		
	}
	
	// DRAW THE PLAYER
	public void drawPlayer(){
		
		playerTexture.bind();
		glBegin(GL_QUADS);
		{
				glTexCoord2f(0, 0);
			glVertex2f(PlayerX, PlayerY);
				glTexCoord2f(0, 1);
			glVertex2f(PlayerX, PlayerY + 32);
				glTexCoord2f(1, 1);
			glVertex2f(PlayerX + 32, PlayerY + 32);
				glTexCoord2f(1, 0);
			glVertex2f(PlayerX + 32, PlayerY);
		}
		glEnd();
		

	}
	
	// UPDATE THE PLAYER
	public void updatePlayer(){
		// TODO PLAYER UPDATE CODE (COULD PUT KEYBOARD INPUT HERE. IT'S BETTER
		// IN SEPERATE CLASS)
		
	}

}
