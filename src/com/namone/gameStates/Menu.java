package com.namone.gameStates;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Player;

import com.namone.simplegui.*;

public class Menu extends GameState {

	Font font;
	TrueTypeFont ttFont;
	private Graphics g = new Graphics(); // GRAPHICS CONTEXT
	private Color color = Color.transparent;
	private int mouseX;
	private int mouseY;

    private Canvas canvas;

    private GameStateManager gameStateManager;

	public Menu(GameStateManager gsm) {
        this.gameStateManager = gsm;
        canvas = new Canvas(gsm);

		try {
			font = new AngelCodeFont(
					"org/newdawn/slick/data/defaultfont.fnt",
					"org/newdawn/slick/data/defaultfont.png");
			g.setFont(font);
		} catch (SlickException e) {
			System.out.println("ERROR: Font not found");
		}
		
		try{
			canvas.add(new Button(new Image("resources/Menu/gameTitle.png"),100,100, null));
            canvas.add(new Button(new Image("resources/Menu/startButton.png"),100,400, new Button.ButtonAction() {
                public void onClick() {
                    gameStateManager.setGameState(1);
                }
            }
            ));

            canvas.add(new Button(new Image("resources/Menu/exitButton.png"),100,500, new Button.ButtonAction() {
                public void onClick() {
                    System.exit(0);   // Exits normally
                    System.out.println("EXIT Game!");
                }
            }));

        } catch (Exception e) {
			System.out.println("ERROR: Image not found!");
		}
		
	}

	public void draw(Player player) {
        canvas.draw();
	}

	public void update(Player player) {
        canvas.update();
	}

}
