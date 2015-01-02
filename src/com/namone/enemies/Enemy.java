package com.namone.enemies;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.Texture;

import com.namone.checkDistance.DistanceDetect;
import com.namone.collision.WorldCollision;
import com.namone.player.Player;

public class Enemy {

	// EVERY ENEMY WILL HAVE HEALTH, AN ID, AN IMAGE SPRITE, etc
	public int enemyX;
	public int enemyY;
	public int viewRadius;
	public Shape hitbox;
	
	protected int wayPointX;
	protected int wayPointY;
	protected int ID;
	protected int health;
	protected int switchNum;
	protected int prevSwitchNum;
	protected boolean checkColl;
	protected boolean inRange;
	protected boolean canMove; // DETECTS COLLISION
	protected ArrayList<Rectangle> rectList;
	protected DistanceDetect distanceDetect;
	protected WorldCollision collision;
	protected Random random = new Random();
	protected Texture enemyTexture;
	protected float movementSpeed;

	public Enemy() {

	}

	public void drawEnemy() {

	}

	public void updateEnemy(Player player, ArrayList<Rectangle> rectList) {

	}

	// EVERY ENEMY WILL ATTACK
	public void attack() {

	}

}
