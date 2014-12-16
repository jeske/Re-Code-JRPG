package com.namone.enemies;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

import com.namone.checkDistance.DistanceDetect;
import com.namone.player.Player;

public class Enemy {
	
	// EVERY ENEMY WILL HAVE HEALTH, AN ID, AN IMAGE SPRITE, etc 
	protected int      health;
	public int         enemyX;
	public int         enemyY;
	public int         viewRadius;
	protected float    movementSpeed;
	protected boolean  inRange;
	protected boolean  canMove; // DETECTS COLLISION
	protected Random   random = new Random();
	protected int      wayPointX;
	protected int      wayPointY;
	
	protected DistanceDetect distanceDetect;
	protected int            ID; 
	protected Texture        enemyTexture;
	
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
