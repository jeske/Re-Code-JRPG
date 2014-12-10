package com.namone.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.opengl.Texture;
import com.namone.movement.playerMovement;
import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;
import com.namone.textureLoad.LoadTextures;

import static org.lwjgl.opengl.GL11.*;

public class MainGame {
	
	private LoadTextures     loadTexture;
	private GameStateManager gameStates;
	private Player           player;
	private Graphics         graphics; // GRAPHICS OBJECT TO DRAW, ETC
	private Graphics         g;        // GRAPHICS CONTEXT
	
	// START THE GAME
	public MainGame(){
		initialize();
	}
	
	// INITIALIZE THE GAME
	public void initialize(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setResizable(false);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		
		// TODO ADD GRAPHICS CONTEXT & GRAPHICS OBJECT
		
		
		
		// INITIALIZE OPENGL
		setOpenGL();
		
		// SET EVERYTHING UP
		gameStates = new GameStateManager();
		loadTexture = new LoadTextures(); // SO I CAN LOAD MY TEXTURES
		
		// START GAME-STATES
		gameStates.GameState();
		
		// TELL US WHAT'S GOING ON
		System.out.println("Application Initialized...");
		
		// CREATE THE PLAYER (DON'T DRAW YET)
		player = new Player();
		
		// LOOP THROUGH THE GAME
		gameLoop(); 
		
		// WHEN WE'RE DONE (SHOULD NOT RUN TILL AFTER GAME CLOSES)
		System.out.println("- APPLICATION CLOSED -");
	}
	
	// KEEP THE GAME ALIVE
	public void gameLoop(){
		while(!Display.isCloseRequested()){
			Display.update();
			Display.sync(60);			

			update();
			draw();
		}		
		
	}
	
	// UPDATE GAME - PLAYER POSITION, ETC.
	public void update(){
		gameStates.update(player); // UPDATE THE SELECTED GAME STATE
	}
	
	
	// DRAW THE GAME SPRITES/GRAPHICS
	public void draw(){
		glClear(GL_COLOR_BUFFER_BIT); // CLEAR COLOR
		glClearColor(1, 1, 1, 1); // PAINT COLOR (WILL DELETE IN FUTURE)
		
		gameStates.draw(player); // DRAW THE SELECTED GAME STATE
	}
	
	public void setOpenGL(){
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); 
		glEnable(GL_TEXTURE_2D); 
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);		
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST); 		
		
		System.out.println("OpenGL Initialized...");
	}

}
