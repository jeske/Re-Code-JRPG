package com.jrpg.worldGeneration;

import java.util.Random;
import com.jrpg.blocks.Block;

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
	
	// 2D array to hold blocks generated to game-screen
	private Block[][] blocks = new Block[ScreenWidthBlocks][ScreenHeightBlocks];
	
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
				id = random.nextInt(2);
				blockX = i * 32;
				blockY = j * 32;

				// If the block selected is not filled -> fill it
				if(blocks[i][j] == null){
					blocks[i][j] = selectBlock.createBlock(id, blockX, blockY); // Which will take an id, x, & y	
				
				// If the block selected is filled -> assign it to itself (keep it the same)
				} else {
					Block block = blocks[i][j];
					blocks[i][j] = selectBlock.createBlock(block.getID(), block.getX(), block.getY());
					
				}
				
			}
		}
	}

}
