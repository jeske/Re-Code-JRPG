package com.jrpg.blocks;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Block {
	
	// Block width & height
	protected final int BLOCK_W = 32;
	protected final int BLOCK_H = 32;
	
	// ID & X/Y position of block
	protected int blockID;
	protected int blockX, blockY;
	
	// The texture atlas image
	private Image textureAtlas;
	protected SpriteSheet spriteSheet;	
	
	public Block(){
		try {
			textureAtlas = new Image("res/atlas.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		spriteSheet = new SpriteSheet(textureAtlas, BLOCK_W, BLOCK_H, 2, 2);

	}
	
	public void destroyBlock(){}
	
	public int getID() {
		return blockID;
		
	}
	
	public int getX() {
		return blockX;
	}
	
	public int getY() {
		return blockY;
	}
	

}
