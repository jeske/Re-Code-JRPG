package com.jrpg.worldGeneration;

import java.util.ArrayList;
import java.util.Random;

import com.jrpg.blocks.*;

public class WorldGen {
	
	// Width & height of game screen
	private final int ScreenWidthPX = 800;
	private final int ScreenHeightPX = 600;
	
	// Divide into equal rows/columns
	private int ScreenWidthBlocks = (ScreenWidthPX / 32) + 1; 
	private int ScreenHeightBlocks = (ScreenHeightPX / 32) + 1; 
	
	// Variables for block generation
	private Random random = new Random();
	private int id;
	private int blockX, blockY;
	
	// To select blocks to draw
	private WorldSelect selectBlock = new WorldSelect();

	// 2D ArrayList to hold blocks generated to game-screen
	private Block[][] gameBlocks = new Block[ScreenWidthBlocks][ScreenHeightBlocks];
	
	public WorldGen(){
		
		/*
		 * For loops to move through the two-dimensional array.
		 * 
		 * i represents across
		 * 
		 * j represents down/vertical
		 * 
		 * # # # # # # # # # # # - i
		 * #
		 * #
		 * #
		 * # - j
		 * #
		 * #
		 * #
		 * #
		 * 
		 */
		for(int i = 0; i < ScreenWidthBlocks; i++){
			for(int j = 0; j < ScreenHeightBlocks; j++){
				
				//Assign values for id, x, & y of each block
				id = random.nextInt(3);
				blockX = i * 32;
				blockY = j * 32;				
				
				// If the block selected is not filled -> fill it
				if(gameBlocks[i][j] == null){
					gameBlocks[i][j] = selectBlock.createBlock(id, blockX, blockY);
					
				// If the block selected is filled -> assign it to itself (keep it the same)
				} else {
					Block block = gameBlocks[i][j];
					gameBlocks[i][j] = selectBlock.createBlock(block.getID(), block.getX(), block.getY());
					
				}
				
			}
		}
	}

}
