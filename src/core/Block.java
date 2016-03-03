package core;
public class Block
{
	private int id;
	protected int getId()
	{
		return id;
	}
	private int width;
	private int heigth;
	boolean keyBlock;
	public Block(int id,int width,int heigth,boolean keyBlock)
	{
		this.id=id;
		this.width=width;
		this.heigth=heigth;
		this.keyBlock=keyBlock;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeigth()
	{
		return heigth;
	}
	public boolean getKeyBlock()
	{
		return keyBlock;
	}
}
