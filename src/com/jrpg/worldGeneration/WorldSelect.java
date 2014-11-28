package com.jrpg.worldGeneration;

import com.jrpg.blocks.*;

public class WorldSelect {
	
	/*
	 * Based on id & x/y values create a block
	 */
	
	public Block createBlock(int id, int x, int y){
				
		switch(id){
		
		case 0:
			Dirt dirt = new Dirt(x, y);
			return dirt;
		
		case 1:
			Grass grass = new Grass(x, y);
			return grass;
			
		case 2:
			new Stone();
			break;
			
		default:
			return null;

		}
		
		return null;	
		
	}

}
