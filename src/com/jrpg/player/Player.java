package com.jrpg.player;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;
import com.jrpg.textureLoader.LoadTexture;

public class Player {
	
	public int playerX, playerY;
	private Texture playerTexture;
	private LoadTexture textureLoader = new LoadTexture();
	
	public Player(String pName, String textureLocation){
		playerTexture = textureLoader.loadTexture(textureLocation);
	}

	public void update(){
		
	}
	
	public void draw(){
		
		playerTexture.bind();
		//TODO set binding coordinates of player texture
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
		{
				glTexCoord2f(0, 0); // Texture coordinate
			glVertex2f(playerX, playerY);
				glTexCoord2f(0, 1); // Texture coordinate
			glVertex2f(playerX, playerY + 32);
				glTexCoord2f(1, 1); // Texture coordinate
			glVertex2f(playerX + 32, playerY + 32);
				glTexCoord2f(1, 0); // Texture coordinate
			glVertex2f(playerX + 32, playerY);			
		}
		glEnd();
	}

}
