package com.jrpg.blocks;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;
import com.jrpg.textureLoader.LoadTexture;

public class Block {
	
	// Block width & height
	protected final int BLOCK_W = 32;
	protected final int BLOCK_H = 32;
	protected int blockID;
	protected int blockX, blockY;
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
	
	public void destroyBlock(){
		
	}
	
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
