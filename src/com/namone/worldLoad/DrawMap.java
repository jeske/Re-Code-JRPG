package com.namone.worldLoad;

import org.lwjgl.opengl.Display;

public class DrawMap extends LoadWorld{
	
	public DrawMap() {

	}
	
	public void drawMap() {
		map.render(Display.getWidth() / 2 - 160, Display.getHeight() / 2 - 160);
		
		/*
		 *  TILE ID'S FUNCTION OFF OF CELL POSITIONS.
		 *  EACH TILE IS AUTOMATICALLY ASSIGNED AN ID
		 *  WHEN USING THE 'TILED' MAP EDITOR. 
		 *  
		 *  FIRST TILE LOADED INTO 'TILED' BECOMES
		 *  ID: 1
		 *  
		 *  SECOND LOADED IN ID: 2
		 *  
		 *  THIRD LOADED IN ID: 3
		 *  
		 *  ETC.
		 */
		
		// TESTING PURPOSES... IF IT IS A CERTAIN TYPE OF GRASS
		// AT CERTAIN CELL -> CHANGE IT TO BRICK (ID 4)
		if(map.getTileId(0, 0, 0) == 3) {
			map.setTileId(0, 0, 0, 4);
		}

	}
	
	

}
