package com.namone.gameStates;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Font;
import org.newdawn.slick.TrueTypeFont;

import com.namone.player.Player;

public class Menu extends GameState {
	
	Font font;
	TrueTypeFont ttFont;
	
	public Menu(){
		// TODO
	}
	
	public void draw(Player player){
		glClearColor(0, 0, 0, 1); // TESTING PURPOSES
		
		// TODO - PRINT OUT TITLE, BUTTONS, EFFECTS, ETC.
	}
	
	public void update(Player player){
		// TODO
	}

}
