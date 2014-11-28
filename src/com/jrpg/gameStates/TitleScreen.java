package com.jrpg.gameStates;

import java.awt.Color;
import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import com.jrpg.engine.GameStateManager;
import com.jrpg.engine.GameStates;
import com.jrpg.player.Player;

import static org.lwjgl.opengl.GL11.*;

public class TitleScreen extends GameStates {

	String title = "Title in Progress \n\n Click to Play";
	private Player Player;
	
	public void init() {	

	}
	
	public void init(Player player){
		Player = player;
	}

	public void update(GameStateManager gsm) {		
		if(Mouse.isButtonDown(0)){
			gsm.setCurrentState(1);
			gsm.init(Player);
		}

	}


	public void draw(Graphics graphicsContext, Graphics graphics) {	

		graphicsContext.drawString(title, Display.getWidth() / 2 - 80
				, Display.getHeight() / 2 - 80);

		

		

	}

}
