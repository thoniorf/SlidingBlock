package it.slidingblock.dlv;
public class BKey
{
	public int id, x, y, t;
	public BKey(int id, int x, int y, int t)
	{
		this.id = id;
		this.x = x;
		this.y = y;
		this.t = t;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getT()
	{
		return t;
	}
	public void setT(int t)
	{
		this.t = t;
	}
}