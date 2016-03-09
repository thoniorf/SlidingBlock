package it.slidingblock.core;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;
import it.slidingblock.gui.ImageProvider;

public class World
{
	private Matrix matrix;

	private ArrayList<Block> blocks;

	public World()
	{
		matrix = new Matrix(5, 5);
		blocks = new ArrayList<>();
		makeLevel();
	}

	public void makeLevel()
	{
		// key block
		blocks.add(new KeyBlock(1, 1, 1));
		matrix.inserisci(blocks.get(0), new Point(0, 0));
		// other block
		blocks.add(new Block(2, 1, 2));
		matrix.inserisci(blocks.get(1), new Point(1, 1));
		blocks.add(new Block(3, 1, 2));
		matrix.inserisci(blocks.get(2), new Point(0, 1));
	}

	public Matrix getMatrix()
	{
		return this.matrix;
	}

	public void update()
	{

	}

	public void paint(Graphics g)
	{
		for (Block block : blocks)
		{
			Point p = matrix.getFirstPoint(block.getId());
			if (block instanceof KeyBlock)
			{
				g.drawImage(ImageProvider.getBlocks().get("redBlock" + block.getHeigth() + "x" + block.getWidth()),
						p.x * 32, p.y * 32, null);
			} else
			{
				g.drawImage(ImageProvider.getBlocks().get("yellowBlock" + block.getHeigth() + "x" + block.getWidth()),
						p.x * 32, p.y * 32, null);
			}

		}
	}
}
