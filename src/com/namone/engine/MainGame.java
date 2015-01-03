package com.namone.engine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Clev;
import com.namone.player.Player;
import com.namone.textureLoad.LoadTextures;

public class MainGame extends BasicGame {

    private LoadTextures loadTexture;
    private GameStateManager gameStates;
    private Player player;
    private Graphics graphics; // GRAPHICS OBJECT TO DRAW, ETC
    private Graphics g; // GRAPHICS CONTEXT
    public static AppGameContainer app;

    public static void main(String[] arguments)
    {
        try
        {
            app = new AppGameContainer(new MainGame());
            app.setDisplayMode(800, 600, false);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    // START THE GAME
    public MainGame() {
        super("Namone RPG");
    }


    @Override
    public void init(GameContainer container) throws SlickException {
        // CLEV IS THE DEFAULT PLAYER
        // CREATE THE PLAYER (DON'T DRAW YET)
        player = new Clev();
        // INITIALIZE OPENGL

        // SET EVERYTHING UP
        gameStates = new GameStateManager(app);
        loadTexture = new LoadTextures(); // SO I CAN LOAD MY TEXTURES

        // START GAME-STATES
        gameStates.GameState(gameStates);

        // TELL US WHAT'S GOING ON
        System.out.println("Application Initialized...");
        System.out.println("Display size : " + Display.getWidth() + "," + Display.getHeight());
        System.out.println("agc size : " + app.getWidth() + "," + app.getHeight());
    }

    // UPDATE GAME - PLAYER POSITION, ETC.
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        gameStates.update(player); // UPDATE THE SELECTED GAME STATE
    }

    // DRAW THE GAME SPRITES/GRAPHICS
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        gameStates.draw(player); // DRAW THE SELECTED GAME STATE
    }
}