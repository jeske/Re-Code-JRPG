package com.jrpg.worldGeneration;

import org.newdawn.slick.SlickException;
import com.jrpg.blocks.*;

public class WorldSelect {
	
	private int ID; // ID of block
	
	/*
	 * Based on id & x/y values create a block
	 */
	
	public Block createBlock(int id, int x, int y){
		
		ID = id;
				
		switch(id){ // Begin switch
		
		case 0:
			Dirt dirt = new Dirt(x, y);
			return dirt;
		
		case 1:
			Grass grass = new Grass(x, y);
			return grass;
			
		case 2:
			Stone stone = new Stone(x, y);
			return stone;
			
		default:
			try{
				throw new SlickException(">> ERROR << TEXTURE LOAD FAILED");
			} catch (SlickException e){
				e.printStackTrace();
			}

		} // End switch
		
		return null;	
		
	}
	
	// Get ID of block
	public int getID(){
		return ID;
	}

}
