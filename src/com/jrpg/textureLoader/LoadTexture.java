package com.jrpg.textureLoader;

import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class LoadTexture {
	
	public Texture loadedTexture;
	
	// Load texture for player
		public Texture loadTexture(String PATH){
			try {			
				// Get resources
				loadedTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(PATH));
				// Tell us they're loaded
				System.out.println("Texture Loaded >> " + PATH);
				// Return loaded texture
				return loadedTexture; 
			} catch (IOException e) {				
				e.printStackTrace();
			}
			return null;
		}

}
