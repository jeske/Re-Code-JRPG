package com.jrpg.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Graphics;

import com.jrpg.player.Player;

public class Application {
	
	// Height and width of game screen
	private int ScreenWidth = 800, ScreenHeight = 600;
	private GameStateManager gsm = new GameStateManager();
	private Graphics graphics, graphicsContext;
	
	// Create the new player
	private Player player;
	
	public void run(){
		System.out.println("RUN");
		init();
	}
	
	public void init(){
		
		// Create the display
		try {
			Display.setDisplayMode(new DisplayMode(ScreenWidth, ScreenHeight));
			Display.setTitle("Revolutionary War Something Something. I'm terrible at making up names");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}	
		
		// New graphics object
		graphics = new Graphics();
		// New graphics context
		graphicsContext = new Graphics(ScreenWidth, ScreenHeight); 
		// Initialize the player (not drawn yet)
		player = new Player("Tom", "res/playerSprites/testsprite.png");
		gsm.init(player);
		// Time to loop!
		initGL();
		gameLoop();
		
		
	}	
	
	public void gameLoop(){
		
		// While the game is not being told to close...
		while(!Display.isCloseRequested()){			
			
			// Clear the colors
			glClear(GL_COLOR_BUFFER_BIT);
			// Update the game (positions, etc)
			update(gsm);
			// Draw the game
			draw(graphicsContext, graphics);
			// Sync screen (not sure if necessary)
			Display.update();
			Display.sync(60);
			
		}
	}	
	
	public void initGL(){
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); // Allows alpha on textures/images
		glEnable(GL_TEXTURE_2D); // Enables 2D texture drawing
		glMatrixMode(GL_PROJECTION);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST); // Since it's a 2D game
	}
	
	public void update(GameStateManager gsm){
		
		glLoadIdentity(); // Reset/wipe clean
		glOrtho(0, 800, 600, 0, 1, -1); // Will be changed
		// Update current game-state
		gsm.update(gsm);
		
	}
	
	public void draw(Graphics graphicsContext, Graphics graphics){
		
		// Draw current game-state
		gsm.draw(graphicsContext, graphics);
	}

}
