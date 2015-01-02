package com.namone.collision;
 
import java.awt.geom.Point2D;
import java.util.ArrayList;
 





import org.lwjgl.input.Keyboard;
import org.newdawn.slick.geom.Rectangle;
 
import org.newdawn.slick.geom.Vector2f;

import com.namone.enemies.Enemy;
import com.namone.movement.playerMovement;
import com.namone.player.Player;
 
public class WorldCollision {  
 
        private boolean  isCollideLeft,
        			     isCollideRight,
        			     isCollideUp,
        			     isCollideDown;
        
        private final int BLOCK_RADIUS = 16;
        
        /*
         *   
         *  IT WORKS!
         */
        
        public boolean checkEnemyCollision(Enemy enemy, ArrayList<Rectangle> collisionBlocks) {
    		
    	    // SET HITBOX LOCATION TO PLAYER LOCATION
        	updateEnemy(enemy);
    		
            // FOR EVERY RECTANGLE IN ARRAYLIST COLLISIONBLOCKS...          
            for(Rectangle blocks : collisionBlocks) {
            	
                // TODO - FINISH COLLISION
                if (enemy.hitbox.intersects (blocks) || blocks.contains (enemy.hitbox)) {
                	
                	
                	if (enemy.hitbox.getCenterX() <= blocks.getCenterX() - BLOCK_RADIUS) {
                		
                		isCollideRight = true; // IS RIGHT
                		isCollideLeft  = false;
                		isCollideUp    = false;
                		isCollideDown  = false;
                		
                		enemy.enemyX -= 1;
                		return isCollideRight;
                	}
                	
                	else if (enemy.hitbox.getCenterX() >= blocks.getCenterX() + BLOCK_RADIUS) {
                		
                		isCollideRight = false; 
                		isCollideLeft  = true; // IS LEFT
                		isCollideUp    = false;
                		isCollideDown  = false;
                		
                		enemy.enemyX += 1;
                		return isCollideLeft;
                	} 
                	
                	else if (enemy.hitbox.getCenterY() <= blocks.getCenterY() - BLOCK_RADIUS) {
                		
                		isCollideRight = false; 
                		isCollideLeft  = false;
                		isCollideUp    = true;  // IS UP
                		isCollideDown  = false;
                		
                		enemy.enemyY -= 1;
                		return isCollideUp;
                	}
                	
                	else if (enemy.hitbox.getCenterY() >= blocks.getCenterY() + BLOCK_RADIUS) {
                		
                		isCollideRight = false; 
                		isCollideLeft  = false;
                		isCollideUp    = false;  
                		isCollideDown  = true; // IS DOWN
                		
                		enemy.enemyY += 1;
                		return isCollideDown;
                	}
                	

                }             

            }
            // IF NOTHING ELSE EVALUATES THEN SET TO FALSE
			return false;

      

    }
        
        public boolean checkPlayerCollision(Player player, ArrayList<Rectangle> collisionBlocks) {
        		
        	    // SET HITBOX LOCATION TO PLAYER LOCATION
        		updatePlayer(player);
        		
                // FOR EVERY RECTANGLE IN ARRAYLIST COLLISIONBLOCKS...          
                for(Rectangle blocks : collisionBlocks) {
                	
                    // TODO - FINISH COLLISION
                    if (player.hitbox.intersects (blocks) || blocks.contains (player.hitbox)) {
                    	
                    	
                    	if (player.hitbox.getCenterX() <= blocks.getCenterX() - BLOCK_RADIUS) {
                    		
                    		isCollideRight = true; // IS RIGHT
                    		isCollideLeft  = false;
                    		isCollideUp    = false;
                    		isCollideDown  = false;
                    		
                    		player.PlayerX -= 1;
                    		return isCollideRight;
                    	}
                    	
                    	else if (player.hitbox.getCenterX() >= blocks.getCenterX() + BLOCK_RADIUS) {
                    		
                    		isCollideRight = false; 
                    		isCollideLeft  = true; // IS LEFT
                    		isCollideUp    = false;
                    		isCollideDown  = false;
                    		
                    		player.PlayerX += 1;
                    		return isCollideLeft;
                    	} 
                    	
                    	else if (player.hitbox.getCenterY() <= blocks.getCenterY() - BLOCK_RADIUS) {
                    		
                    		isCollideRight = false; 
                    		isCollideLeft  = false;
                    		isCollideUp    = true;  // IS UP
                    		isCollideDown  = false;
                    		
                    		player.PlayerY -= 1;
                    		return isCollideUp;
                    	}
                    	
                    	else if (player.hitbox.getCenterY() >= blocks.getCenterY() + BLOCK_RADIUS) {
                    		
                    		isCollideRight = false; 
                    		isCollideLeft  = false;
                    		isCollideUp    = false;  
                    		isCollideDown  = true; // IS DOWN
                    		
                    		player.PlayerY += 1;
                    		return isCollideDown;
                    	}
                    	

                    }             

                }
                // IF NOTHING ELSE EVALUATES THEN SET TO FALSE
				return false;

          
 
        }
        
        public void updateEnemy(Enemy enemy) {   
        	enemy.hitbox.setLocation (enemy.enemyX, enemy.enemyY);
        }
        
        public void updatePlayer(Player player) {   
        	player.hitbox.setLocation (player.PlayerX, player.PlayerY);
        }

}