package com.namone.player;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;

public class Clev extends Player{
	
	// IMAGE FOR PLAYER 'CLEV'
	private Image Clev;
	
	public Clev() {
		// SET PLAYER SPRITE FOR 'JOHN'
		Clev = spriteSheet.getSubImage(0, 0);
	}
	
	// DRAW JOHN
	public void drawPlayer(){
		
		// DRAW		
		Clev.draw(PlayerX, PlayerY, 32, 32);
		
		Clev.bind();
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
	
	public void updatePlayer() {
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			Clev = spriteSheet.getSubImage(0, 1);
			
		}

	}
	
}
