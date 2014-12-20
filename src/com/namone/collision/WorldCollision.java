package com.namone.collision;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import com.namone.player.Player;

public class WorldCollision {	

	private boolean isCollide;
	
	public boolean checkCollision(Player player, ArrayList<Rectangle> collisionBlocks) {
		
		// FOR EVERY RECTANGLE IN ARRAYLIST COLLISIONBLOCKS...
		for(Rectangle blocks : collisionBlocks) {	
			
			if(player.hitbox.intersects (blocks) || blocks.contains (player.hitbox)) {
				isCollide = true; // THIS ISN'T TAKING EFFECT FOR SOME REASON?
				player.PlayerX -= 1; // BUT THIS IS TAKING EFFECT?
				System.out.println(isCollide); // THIS IS ALSO PRINTING?
			} 
			
			else {
				isCollide = false;
			}
			
			
			
		}
		return isCollide; 
		

	}

} 
