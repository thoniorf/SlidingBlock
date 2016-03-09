package it.slidingblock.core.block;

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

}
