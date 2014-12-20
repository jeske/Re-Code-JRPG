package com.namone.worldLoad;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.geom.Rectangle;


public class DrawMap extends LoadWorld{
	
	public Random random = new Random();
	private boolean isClicked = false;
	
	// KEEP TRACK OF WHICH BLOCKS COLLIDE
	private boolean blocked[][] = new boolean[map.getWidth()][map.getHeight()];
	private int tileID;
	private int layerIndex = 1; 
	private int tileSize = 32;
	private String collide; // HOLDS PROPERTIES OF BLOCK TO CHECK
	// TO CHECK AGAINST
	private ArrayList<Rectangle> collisionBlocks = new ArrayList<Rectangle>();
	
	/*
	 * @BASED FROM SLICK2D DOCUMENTATION@
	 * 
	 * THIS SHOULD NOT BE USED IN GAME-LOOP AS 
	 * 'getTileProperty(tileID, property, defaultProperty)' 
	 * IS IN-EFFECIENT. MAP IS DRAWN IN 'draw()' AND COLLISION
	 * IS DETECTED THERE
	 */
	public DrawMap() {

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
		
		// MOVE THROUGH THE MAP
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				
				tileID = map.getTileId(i, j, layerIndex);
				// TESTING
				System.out.println(tileID);
				
				// !IMPORTANT! PROPERTIES ARE DEFINED IN TILED MAP EDITOR ITSELF
				collide = map.getTileProperty(tileID, "blocked", "false");
				
				if(collide.equals("true")) {
					
					// THIS DOESN'T REALLY DO ANYTHING - JUST TO HELP FOR POTENTIAL FUTURE
					blocked[i][j] = true; 
					// ADD A NEW COLLISION BLOCK TO CHECK AGAINST IN THE GAME-LOOP
					collisionBlocks.add(new Rectangle((float) i * tileSize, (float) j * tileSize,
							tileSize, tileSize));
					
				}			

			}
			
			
		}

	}
	
	// THIS IS IN GAME-LOOP
	public void draw() {
		map.render(0, 0);		
	}
	
	public ArrayList<Rectangle> getRectList() {
		return collisionBlocks;
	}
	


}
