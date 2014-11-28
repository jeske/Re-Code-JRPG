package com.jrpg.blocks;

import org.newdawn.slick.Image;

import static org.lwjgl.opengl.GL11.*;

public class Dirt extends Block {
	
	private Image dirt;
	
	public Dirt(int x, int y){
		
		// (0, 0) represents a cell - not a coordinate
		dirt = spriteSheet.getSubImage(0, 0);
		
		blockID = 0;
		blockX = x;
		blockY = y;
		// Draw block with x & y specified
		draw(x, y);

	}
	
	public void update(){}
	
	public void draw(int x, int y){
		
		//dirt.drawEmbedded is more efficient - it re-uses previous loads
		dirt.drawEmbedded(x, y, BLOCK_W, BLOCK_H);
		// Bind the texture to the square
		dirt.bind();
		glBegin(GL_QUADS);
		{

			glVertex2f(x, y);		
			glVertex2f(x, y + 32);			
			glVertex2f(x + 32, y + 32);				
			glVertex2f(x + 32, y);
		}
		glEnd();
	}

}
