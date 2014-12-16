package com.namone.player;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.*;
import com.namone.checkDistance.DistanceDetect;
import com.namone.enemies.Enemy;

public class Player {

	// PLAYER X & Y, HEIGHT, RANG, ETC
	public float playerRange = 32.5f;
	private DistanceDetect distanceDetect = new DistanceDetect();
	// IS THE ENEMY IN RANGE
	protected boolean inRange = true;
	public boolean canMove = true; // IS THE PLAYER COLLIDING?
	public int PlayerX = 100;
	public int PlayerY = 100;
	protected final int PLAYER_W = 32;
	protected final int PLAYER_H = 32;
	public Shape hitbox;

	// FOR ANIMATIONS - TODO
	protected int frame = 0;

	private Image textureAtlas;
	protected SpriteSheet spriteSheet;

	public Player() {
		// SET UP PLAYER SPRITE-SHEET
		try {
			textureAtlas = new Image("resources/playerSpritesheet.png");
			System.out.println("- PLAYER SPRITE-SHEET LOADED -");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spriteSheet = new SpriteSheet(textureAtlas, PLAYER_W, PLAYER_H, 0, 0);

	}

	// DRAW THE PLAYER - DONE IN INDIVIDUAL PLAYER'S CLASS
	public void drawPlayer() {
	}

	// PLAYER ATTACK

	// IF THE ENEMY IS IN RANGE... THEN THE PLAYER WILL ATTACK
	public void playerAttack(ArrayList<Enemy> enemies, int maxEnemy) {

		// CONTROLS RANGE DETECTION
		inRange = distanceDetect
				.checkPlayerAttackRange(this, enemies, maxEnemy);

		// IF THE KEY IS DOWN AND THE ARRAY ISN'T EMPTY - REMOVE
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !enemies.isEmpty()
				&& inRange) {
			System.out.println("Attack!");

			// TODO - FIX THIS

		}

	}

	// UPDATE THE PLAYER
	public void updatePlayer() {
		// OVERRIDDEN BY INDIVIDUAL PLAYER SUB-CLASSES
		// NO NEED TO PUT ANYTHING IN HERE

	}

}
