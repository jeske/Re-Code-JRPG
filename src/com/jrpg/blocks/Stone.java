package com.jrpg.blocks;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.Image;

public class Stone extends Block{
private Image stone;
	
	public Stone(int x, int y){
		
		// (2, 0) represents a cell - not a coordinate
		stone = spriteSheet.getSubImage(2, 0);
		
		blockID = 2;
		blockX = x;
		blockY = y;
		// Draw block with x & y specified
		stone.draw(x, y);

	}
	
	public void update(){}
	
	public void draw(int x, int y){
		
		//dirt.drawEmbedded is more efficient - it re-uses previous loads
		stone.drawEmbedded(x, y, BLOCK_W, BLOCK_H);
		// Bind the texture to the square
		stone.bind();
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
