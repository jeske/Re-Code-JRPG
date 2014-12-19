package com.namone.gameStates;

import static org.lwjgl.opengl.GL11.glClearColor;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;

public class Menu extends GameState {

	Font font;
	TrueTypeFont ttFont;
	private Graphics g = new Graphics(); // GRAPHICS CONTEXT
	private Image imageTitle;
	private Image imageExit;
	private Image imagePlay;
	private Color color = Color.transparent;
	private int mouseX;
	private int mouseY;
	

	public Menu(GameStateManager gsm) {

		gameStates = gsm;
		
		try {
			font = new AngelCodeFont(
					"org/newdawn/slick/data/defaultfont.fnt",
					"org/newdawn/slick/data/defaultfont.png");
			g.setFont(font);
		} catch (SlickException e) {
			System.out.println("ERROR: Font not found");
		}
		
		try{
			imageTitle = new Image("resources/Menu/tempGameTitle.png");
			imageExit  = new Image("resources/Menu/tempExitButton.png");
			imagePlay  = new Image("resources/Menu/tempPlayButton.png");
		} catch (Exception e) {
			System.out.println("ERROR: Image not found!");
		}
		
	}

	public void draw(Player player) {		
		imageTitle.draw((Display.getWidth()/2)-150, (Display.getHeight()/2)-150);
		imagePlay.draw((Display.getWidth()/2)-110, (Display.getHeight()/2));
		imageExit.draw((Display.getWidth()/2)+10, (Display.getHeight()/2));
	}

	public void update(Player player) {
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		
		if(((mouseX > (Display.getWidth()/2)-110) && (mouseX < (Display.getWidth()/2)-10)) && ((mouseY > (Display.getHeight()/2)) && (mouseY < ((Display.getHeight()/2)+35)))){
			if(Mouse.isButtonDown(0)){
				gameStates.setGameState(1);
				System.out.println("SETTING: currentState to 1");
			}
		}
		
		if(((mouseX > (Display.getWidth()/2)+10) && (mouseX < (Display.getWidth()/2)+110)) && ((mouseY > ((Display.getHeight()/2))) && (mouseY < ((Display.getHeight()/2)+35)))){
			if(Mouse.isButtonDown(0)){
				System.exit(0);   // Exits normaly
				System.out.println("EXIT Game!");
 			}
		}
	}

}
