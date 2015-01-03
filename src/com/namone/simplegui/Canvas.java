package com.namone.simplegui;

import com.namone.gameStateManager.GameStateManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by David on 1/3/2015.
 */
public class Canvas {
    float width,height;
    GameStateManager gsm;

    List<Component> components = new LinkedList<Component>();

    public Canvas(GameStateManager gsm) {
        this.gsm = gsm;
        this.width = (float)gsm.appGameContainer.getWidth();
        this.height = (float)gsm.appGameContainer.getHeight();
    }

    public void add(Component c) {
        components.add(c);
    }

    public void draw() {
        for( Component c : components ) {
            c.draw();
        }
    }

    public void update() {

        float mouseX = Mouse.getX();
        float mouseY = Mouse.getY();

        float screenWidth = Display.getWidth();
        float screenHeight = Display.getHeight();

        if (Mouse.isButtonDown(0)) {
            System.out.println("mousedown " + mouseX + "," + mouseY + "    screen: " + screenWidth + "," + screenHeight);

            // figure out which control is being clicked on
            for (Component c : components) {
                if (mouseX > c.locx && mouseX < (c.locx + c.width) &&
                    mouseY > c.locy && mouseY < (c.locy + c.height)) {
                    // we hit the component
                    System.out.println("component hit! " + c);
                    c.mouseDown();
                }

            }
        }
    }
}
