package com.namone.worldLoad;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class LoadWorld {

	private TiledMap map;
	private DrawMap drawMap;

	public LoadWorld() {
		init();
	}

	// LOAD IN THE MAP
	public void init() {

	}

	// DRAW THE MAP
	public void drawMap() {
		drawMap = new DrawMap();
	}

}
