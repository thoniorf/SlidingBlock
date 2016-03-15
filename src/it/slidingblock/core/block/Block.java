package it.slidingblock.core.block;

import java.awt.Graphics;

import it.slidingblock.core.Matrix;
import it.slidingblock.gui.ImageProvider;

public class Block
{
	private int id;
	private int width;
	private int heigth;

	public Block(int id, int width, int heigth)
	{
		this.id = id;
		this.width = width;
		this.heigth = heigth;
	}

	public int getId()
	{
		return id;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeigth()
	{
		return heigth;
	}
	
	public void paint(Graphics g,Point p){
		g.drawImage(ImageProvider.getBlocks().get("yellowBlock" + block.getHeigth() + "x" + block.getWidth()),
				p.x * Matrix.cellsize, p.y * Matrix.cellsize, null);
	}

}
