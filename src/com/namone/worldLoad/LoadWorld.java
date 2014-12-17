package com.namone.worldLoad;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class LoadWorld {

	protected TiledMap map;

	public LoadWorld() {
		try {
			map = new TiledMap("resources/map/TESTMAP.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// LOAD IN THE MAP
	public void init() {

	}

	// DRAW THE MAP
	public void drawMap() {
		// OVERRIDDEN BY DRAWMAP.JAVA
		
	}

}
