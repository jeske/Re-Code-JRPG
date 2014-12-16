package com.namone.worldLoad;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class LoadWorld {

	private TiledMap map;

	public LoadWorld() {
		init();
	}

	// LOAD IN THE MAP
	public void init() {
		try {
			map = new TiledMap("resources/map/JRPGMap 1.0.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	// DRAW THE MAP
	public void drawMap() {
		map.render(0, 0);
	}

}
