package it.slidingblock.core;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;
public class World
{
	private ArrayList<Block> blocks;
	private Matrix matrix;
	public World()
	{
		//exception a manetta
		blocks = new ArrayList<Block>();
		makeLevel();
		//makeLevel2();
		//makeLevel3();
	}
	public ArrayList<Block> getBlocks()
	{
		return blocks;
	}
	public Matrix getMatrix()
	{
		return matrix;
	}
	public void makeLevel2()
	{
		Point exit2 = new Point(2, 0);
		matrix = new Matrix(3, 4, exit2, 1);
		blocks.add(new Block(1, 1, 2));
		blocks.add(new Block(2, 2, 1));
		matrix.insert(blocks.get(0), new Point(0, 1));
		matrix.insert(blocks.get(1), new Point(2, 0));
		for (int i = 3; i < 7; i++)
			blocks.add(new Block(i, 1, 1));
		matrix.insert(blocks.get(2), new Point(1, 2));
		matrix.insert(blocks.get(3), new Point(2, 2));
		matrix.insert(blocks.get(4), new Point(1, 3));
		matrix.insert(blocks.get(5), new Point(2, 3));
		blocks.add(new KeyBlock(7, 2, 1));
		matrix.insert(blocks.get(6), new Point(0, 2));
	}
	public void makeLevel3()
	{
		//non funziona il paint component sul blocco chiave
		Point exit2 = new Point(2, 0);
		matrix = new Matrix(4, 4, exit2, 1);
		for (int i = 1; i < 7; i++)
			blocks.add(new Block(i, 1, 1));
		blocks.add(new Block(6, 1, 2));
		blocks.add(new Block(7, 2, 1));
		matrix.insert(blocks.get(4), new Point(0, 0));
		matrix.insert(blocks.get(1), new Point(1, 0));
		matrix.insert(blocks.get(2), new Point(2, 1));
		matrix.insert(blocks.get(3), new Point(3, 0));
		matrix.insert(blocks.get(0), new Point(3, 2));
		matrix.insert(blocks.get(5), new Point(3, 3));
		matrix.insert(blocks.get(6), new Point(0, 1));
		matrix.insert(blocks.get(7), new Point(2, 2));
		blocks.add(new KeyBlock(6, 2, 2));
		matrix.insert(blocks.get(8), new Point(0, 2));
	}
	public void makeLevel()
	{
		Point exit = new Point(2, 0);
		matrix = new Matrix(3, 3, exit, 1);
		// other block
		for (int i = 1; i < 6; i++)
			blocks.add(new Block(i, 1, 1));
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
	public void paint(Graphics g)
	{
		matrix.paint(g);
		for (Block block : blocks)
		{
			Point p = matrix.getFirstPoint(block.getId());
			block.paint(g, p);
		}
	}
}
