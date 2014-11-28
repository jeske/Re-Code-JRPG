package com.jrpg.gameStates;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Graphics;

import com.jrpg.engine.GameStateManager;
import com.jrpg.engine.GameStates;
import com.jrpg.input.KeyboardListener;
import com.jrpg.player.Player;
import com.jrpg.worldGeneration.WorldGen;

public class Game extends GameStates {
	
	private WorldGen generate;
	private Player Player;
	KeyboardListener keyboard;
	
	public void init(){}
	
	public void init(Player player) {		
		//TODO World generation...load player...set everything up
		System.out.println("INITIALIZING GAME...");
		Player = player;
		
		// Get keyboard input to update player position
	    keyboard = new KeyboardListener();

	}

	public void update(GameStateManager gsm) {		
		//TODO Update world...update player...update everything	
		
		// Update player position
		keyboard.KeyboardListener(Player);
		
	}


	public void draw(Graphics graphicsContext, Graphics graphics) {	
		glClearColor(0, 0, 0, 1);
		
		// Generate the world
		generate = new WorldGen();
		Player.draw();
		
	}

}
