package it.slidingblock.core;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;
public class World
{
	public Matrix getMatrix()
	{
		return matrix;
	}
	private Matrix matrix;
	private ArrayList<Block> blocks;
	public ArrayList<Block> getBlocks()
	{
		return blocks;
	}
	public World()
	{
		blocks=new ArrayList<>();
		makeLevel();
	}
	public void makeLevel()
	{
		matrix=new Matrix(4,4,1);
		// other block
		for (int i=1;i<6;i++)
		{
			Block b=new Block(i,1,1);
			blocks.add(b);
		}
		// insert
		matrix.inserisci(blocks.get(0),new Point(0,0));
		matrix.inserisci(blocks.get(1),new Point(1,1));
		matrix.inserisci(blocks.get(2),new Point(1,2));
		matrix.inserisci(blocks.get(3),new Point(2,1));
		matrix.inserisci(blocks.get(4),new Point(2,2));
		// key block
		blocks.add(new KeyBlock(6,2,1));
		matrix.inserisci(blocks.get(5),new Point(1,0));
	}
	public void paint(Graphics g)
	{
		// matrix paint
		matrix.paint(g);
		// blocks paint
		for (Block block:blocks)
		{
			block.paint(g);
		}
	}
}
