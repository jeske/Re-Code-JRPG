package com.namone.collision;
 
import java.util.ArrayList;
 

import org.newdawn.slick.geom.Rectangle;
 
import org.newdawn.slick.geom.Vector2f;

import com.namone.player.Player;
 
public class WorldCollision {  
 
        private boolean  isCollide;
        private Vector2f hitboxLocation;
        private Vector2f blockLocation;
        private int      boxX;
        private int      boxY;
       
        
        /*
         *  TODO -
         *  
         *  THIS WHOLE THING IS PRETTY SCREWY... NOT SURE ENITRELY WHAT'S GOING ON
         *  THE LOGIC.. TO ME.. MAKES SENSE. HOWEVER, AS YOU WILL SEE IT DOES NOT WORK
         *  I WILL WORK ON IT SOME MORE TOMORROW 
         *  
         *  - NAMONE (ALEX)
         */
        public boolean checkCollision(Player player, ArrayList<Rectangle> collisionBlocks) {
               
                // FOR EVERY RECTANGLE IN ARRAYLIST COLLISIONBLOCKS...
                isCollide = false; // RESET            
         	    hitboxLocation = player.hitbox.getLocation(); 
                for(Rectangle blocks : collisionBlocks) { 
                	   blockLocation = blocks.getLocation();
                       // TODO - FINISH COLLISION
                        if (player.hitbox.intersects (blocks) || blocks.contains (player.hitbox)) {
                                isCollide = true; // PLAYER IS NOW COLLIDING                    
                                
                                // IF THE RIGHT SIDE OF PLAYER HITBOX IS EQUAL TO
                                // LEFT SIDE OF BLOCK HITBOX
                                if(hitboxLocation.getX() + 32 == blockLocation.getX()) {
                                	// BUMP THE PLAYER OUT OF COLLISION
                                	boxX = (int) hitboxLocation.getX() - 1;
                                	// TESTING
                                	System.out.println("HIT");
                                	// SET THE PLAYER'S POSITION EQUAL TO THE 
                                	// NEW HITBOXLOCATION
                                	player.PlayerX = boxX;    
                                } 
                                
                                // IF LEFT SIDE OF PLAYER HITBOX IS EQUAL TO 
                                // RIGHT SIDE OF BLOCK HTIBOX
                                else if (hitboxLocation.getX() == blockLocation.getX() + 32) {
                                	// SAME AS ABOVE
                                	boxX = (int) hitboxLocation.getX() + 1;
                                	System.out.println("HIT 2");
                                	player.PlayerX = boxX;    
                                }
                                
                            	player.PlayerX = boxX; 
                                                          
                        }
                        
                        // TESTING PURPOSES
                        System.out.println(hitboxLocation);
                        System.out.println(" BLOCK - " + blockLocation);

                       
                }

                return isCollide;
               
 
        }

}