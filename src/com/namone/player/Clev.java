package com.namone.player;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;

public class Clev extends Player{
	
	// IMAGE FOR PLAYER 'CLEV'
	private Image Clev;
	
	public Clev() {
		// SET PLAYER SPRITE FOR 'CLEV' 
		Clev = spriteSheet.getSubImage(0, 0);
	}
	
	// DRAW JOHN
	public void drawPlayer(){
		
		// DRAW		
		Clev.draw(PlayerX, PlayerY, 32, 32);
		Clev.bind();
		glBegin(GL_QUADS);
		{			
			glVertex2f(PlayerX, PlayerY);			
			glVertex2f(PlayerX, PlayerY + 32);				
			glVertex2f(PlayerX + 32, PlayerY + 32);				
			glVertex2f(PlayerX + 32, PlayerY);
		}
		glEnd();
		

	}
	
	// NOTE: .GETSUBIMAGE(INT X, INT Y) WORKS OFF OF CELLS, NOT COORDINATES
	public void updatePlayer() {
		// MOVE UP
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			Clev = spriteSheet.getSubImage(0, 3);

		}
		// MOVE DOWN
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			Clev = spriteSheet.getSubImage(0, 0);
			
		}
		// MOVE LEFT
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			Clev = spriteSheet.getSubImage(0, 1);
			
		}
		// MOVE RIGHT
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			Clev = spriteSheet.getSubImage(0, 2);
			
		}

	}
	
}
