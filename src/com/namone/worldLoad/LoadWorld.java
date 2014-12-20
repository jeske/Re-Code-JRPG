package com.namone.worldLoad;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class LoadWorld {

	protected TiledMap map;
	// KEEP TRACK OF WHICH BLOCKS COLLIDE
	private boolean blocked[][];
	private int tileID;
	private int layerIndex; 
	private int tileSize;
	private String blockProperty; // HOLDS PROPERTIES OF BLOCK TO CHECK
	// TO CHECK AGAINST
	private ArrayList<Rectangle> collisionBlocks;
	

	public LoadWorld() {
		try {
			map = new TiledMap("resources/map/JRPGMap 1.0.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// LOAD IN THE MAP
	public void init() {

	}

	// DRAW THE MAP
	public void draw() {
		// OVERRIDDEN BY DRAWMAP.JAVA
		
	}
	
	// GETTERS & SETTERS
	public ArrayList<Rectangle> getRectList() {
		return null;
	}



}
