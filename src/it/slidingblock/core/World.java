package it.slidingblock.core;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;

public class World {
	private ArrayList<Block> blocks;
	private Matrix matrix;
	public World(String level) 
	{
		// exception a manetta
		blocks = new ArrayList<Block>();
		switch(level)
		{
			case "level1":
				makeLevel();
				break;
			case "level2":
				makeLevel2();
				break;
			case "level3":
				makeLevel3();
				break;
			default:
				break;
		}
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void makeLevel() {
		System.out.println("level1");
		Point exit = new Point(2, 0);
		matrix = new Matrix(3, 3, exit, 1);
		// other block
		for (int i = 1; i < 6; i++) {
			blocks.add(new Block(i, 1, 1));
		}
		// insert
		matrix.insert(blocks.get(0), new Point(0, 0));
		matrix.insert(blocks.get(1), new Point(1, 1));
		matrix.insert(blocks.get(2), new Point(1, 2));
		matrix.insert(blocks.get(3), new Point(2, 1));
		matrix.insert(blocks.get(4), new Point(2, 2));
		// key block
		blocks.add(new KeyBlock(6, 2, 1));
		matrix.insert(blocks.get(5), new Point(0, 1));
	}

	public void makeLevel2() {
		System.out.println("level2");
		Point exit2 = new Point(2, 0);
		matrix = new Matrix(3, 4, exit2, 1);
		// other block
		for (int i = 1; i < 6; i++) {
			blocks.add(new Block(i, 1, 1));
		}
		// insert
		matrix.insert(blocks.get(0), new Point(0, 0));
		matrix.insert(blocks.get(1), new Point(1, 1));
		matrix.insert(blocks.get(2), new Point(1, 2));
		matrix.insert(blocks.get(3), new Point(2, 1));
		matrix.insert(blocks.get(4), new Point(2, 2));
		// key block
		blocks.add(new KeyBlock(6, 2, 1));
		matrix.insert(blocks.get(5), new Point(0, 1));
	}

	public void makeLevel3() {
		System.out.println("level3");
		// non funziona il paint component sul blocco chiave
		Point exit2 = new Point(2, 0);
		matrix = new Matrix(4, 4, exit2, 1);
		for (int i = 1; i < 6; i++) {
			blocks.add(new Block(i, 1, 1));
		}
		// insert
		matrix.insert(blocks.get(0), new Point(0, 0));
		matrix.insert(blocks.get(1), new Point(1, 1));
		matrix.insert(blocks.get(2), new Point(1, 2));
		matrix.insert(blocks.get(3), new Point(2, 1));
		matrix.insert(blocks.get(4), new Point(2, 2));
		// key block
		blocks.add(new KeyBlock(6, 2, 1));
		matrix.insert(blocks.get(5), new Point(0, 1));
	}

	public void paint(Graphics g) {
		matrix.paint(g);
		for (Block block : blocks) {
			Point p = matrix.getFirstPoint(block.getId());
			block.paint(g, p);
		}
	}
}
