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
		blocks=new ArrayList<Block>();
		makeLevel();
	}
	public ArrayList<Block> getBlocks()
	{
		return blocks;
	}
	public Matrix getMatrix()
	{
		return matrix;
	}
	public void makeLevel()
	{
		Point exit=new Point(2,0);
		matrix=new Matrix(3,3,exit,1);
		// other block
		for (int i=1;i<7;i++)
			blocks.add(new Block(i,1,1));
		// insert
		matrix.insert(blocks.get(0),new Point(0,0));
		matrix.insert(blocks.get(1),new Point(1,1));
		matrix.insert(blocks.get(2),new Point(1,2));
		matrix.insert(blocks.get(3),new Point(2,1));
		matrix.insert(blocks.get(4),new Point(2,2));
		matrix.insert(blocks.get(5),new Point(0,2));
		// key block
		blocks.add(new KeyBlock(7,1,1));
		matrix.insert(blocks.get(6),new Point(0,1));
	}
	public void paint(Graphics g)
	{
		matrix.paint(g);
		for (Block block:blocks)
		{
			Point p=matrix.getFirstPoint(block.getId());
			block.paint(g,p);
		}
	}
}
