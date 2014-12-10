package com.namone.textureLoad;

import java.io.IOException;

import org.newdawn.slick.opengl.*;
import org.newdawn.slick.util.ResourceLoader;

public class LoadTextures {
	
	private Texture loadedTexture;
	
	// LOAD TEXTURE PASSED IN
	public Texture LoadTexture(String PATH){
		
		try {
			loadedTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("PLAYER TEXTURE LOADED: " + PATH);
		
		return loadedTexture;
		
		
	}
	

}
