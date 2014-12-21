package com.namone.collision;
 
import java.awt.geom.Point2D;
import java.util.ArrayList;
 




import org.lwjgl.input.Keyboard;
import org.newdawn.slick.geom.Rectangle;
 
import org.newdawn.slick.geom.Vector2f;

import com.namone.movement.playerMovement;
import com.namone.player.Player;
 
public class WorldCollision {  
 
        private boolean  isCollide;
        
        private Point2D topLeftBlockPoint,
        				topRightBlockPoint,
        				lowerLeftBlockPoint,
        				lowerRightBlockPoint,
        				
        				topLeftPlayerPoint,
        				topRightPlayerPoint,
        				lowerLeftPlayerPoint,
        				lowerRightPlayerPoint;
        
        private playerMovement move = new playerMovement();
        
        private float blockDeltaX;
        private float blockDeltaY;
        
        /*
         *  TODO -
         *  
         *  NOT WORKING YET. IT IS A LOT BETTER THAN IT WAS. HOWEVER, WHEN Y VALUES ARE ADDED
         *  (COLLISION FOR TOPS AND BOTTOMS OF BLOCKS) IT MESSES THINGS UP
         *  
         *  NOTE: I ADDED AN EXTRA 2PX WIDTH (IN LOADMAP.JAVA I THINK) TO THE BLOCKS COLLISION BOX 
         *  FOR EASIER DETECTION
         *  
         *  - NAMONE (ALEX)
         */
        
        public boolean checkCollision(Player player, ArrayList<Rectangle> collisionBlocks) {
        		
        	    // SET HITBOX LOCATION TO PLAYER LOCATION
        		update(player);
        		
                // FOR EVERY RECTANGLE IN ARRAYLIST COLLISIONBLOCKS...
                isCollide = false; // RESET            
                for(Rectangle blocks : collisionBlocks) { 
                	
                	// POINTS OF BLOCKS
                	topLeftBlockPoint = new Point2D.Double(blocks.getX(), blocks.getY());
                	topRightBlockPoint = new Point2D.Double(blocks.getX() + 32, blocks.getY());
                	lowerLeftBlockPoint = new Point2D.Double(blocks.getX(), blocks.getY() + 32);
                	lowerRightBlockPoint = new Point2D.Double(blocks.getX() + 32, blocks.getY() + 32);
                	
                	// POINTS OF PLAYER HITBOX
                	topLeftPlayerPoint = new Point2D.Double(player.hitbox.getX(), player.hitbox.getY());
                	topRightPlayerPoint = new Point2D.Double(player.hitbox.getX() + 32, player.hitbox.getY());
                	lowerLeftPlayerPoint = new Point2D.Double(player.hitbox.getX(), player.hitbox.getY() + 32);
                	lowerRightPlayerPoint = new Point2D.Double(player.hitbox.getX() + 32, player.hitbox.getY() + 32);
                	
                	blockDeltaX = (int) blocks.getX() - player.hitbox.getX();
                	
                    // TODO - FINISH COLLISION
                    if (player.hitbox.intersects (blocks) || blocks.contains (player.hitbox)) {
                    	isCollide = true; // PLAYER IS NOW COLLIDING
                    	
                    	if (topRightPlayerPoint.getX() <= topRightBlockPoint.getX()
                    			&& lowerRightPlayerPoint.getX() <= lowerRightBlockPoint.getX()
                    			&& topRightPlayerPoint.getY() >= topRightBlockPoint.getY()
                    			&& topLeftPlayerPoint.getY() >= topLeftBlockPoint.getY()) {
                    		player.PlayerX -= 1;
                    	}
                    	
                    	else if (topLeftPlayerPoint.getX() >= topLeftBlockPoint.getX()
                    			&& lowerLeftPlayerPoint.getX() >= lowerLeftBlockPoint.getX()
                    			&& topRightPlayerPoint.getY() >= topRightBlockPoint.getY()
                    			&& topLeftPlayerPoint.getY() >= topLeftBlockPoint.getY()) {
                    		player.PlayerX += 1;
                    	}
                    	
                    	else if (lowerRightPlayerPoint.getY() <= lowerRightBlockPoint.getY()
                    			&& lowerLeftPlayerPoint.getY() <= lowerLeftBlockPoint.getY()
                    			&& lowerRightPlayerPoint.getX() <= lowerRightBlockPoint.getX()
                    			&& lowerLeftPlayerPoint.getX() >= lowerLeftBlockPoint.getX()) {
                    		player.PlayerY -= 1;
                    	}  
                    	
                    	else if (topRightPlayerPoint.getY() >= topRightBlockPoint.getY()
                    			&& topLeftPlayerPoint.getY() >= topLeftBlockPoint.getY()
                    			&& topRightPlayerPoint.getX() <= topRightBlockPoint.getX()
                    			&& topLeftPlayerPoint.getX() >= topLeftBlockPoint.getX()) {
                    		player.PlayerY += 1;
                    	}  

                    }             

                }

                return isCollide;              
 
        }
        
        public void update(Player player) {   
        	player.hitbox.setLocation (player.PlayerX, player.PlayerY);
        }

}