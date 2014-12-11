package com.namone.enemies;

import org.newdawn.slick.opengl.Texture;

import com.namone.player.Player;

public class Enemy {
	
	// EVERY ENEMY WILL HAVE HEALTH, AN ID, AN IMAGE SPRITE, etc 
	protected int health;
	protected int enemyX;
	protected int enemyY;
	protected int movementSpeed;
	protected int viewRadius;
	protected boolean inRange;
	protected DistanceDetect distanceDetect;
	protected int ID; 
	protected Texture enemyTexture;
	
	public Enemy() {

	}
	
	public void drawEnemy() {
		
	}
	
	public void updateEnemy(Player player) {

	}
	
	// EVERY ENEMY WILL ATTACK
	public void attack() {
		
	}
	


}
