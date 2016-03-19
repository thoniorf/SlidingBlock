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
		blocks=new ArrayList<>();
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
		matrix=new Matrix(3,3,1);
		// other block
		for (int i=1;i<6;i++)
			blocks.add(new Block(i,1,1));
		// insert
		matrix.insert(blocks.get(0),new Point(0,0));
		matrix.insert(blocks.get(1),new Point(1,1));
		matrix.insert(blocks.get(2),new Point(1,2));
		matrix.insert(blocks.get(3),new Point(2,1));
		matrix.insert(blocks.get(4),new Point(2,2));
		// key block
		blocks.add(new KeyBlock(6,2,1));
		matrix.insert(blocks.get(5),new Point(1,0));
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
