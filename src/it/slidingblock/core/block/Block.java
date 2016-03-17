package it.slidingblock.core.block;
import java.awt.Graphics;
import java.awt.Point;
import it.slidingblock.core.Matrix;
import it.slidingblock.gui.ImageProvider;
import it.slidingblock.gui.MainFrame;
public class Block
{
	private int id;
	private int width;
	private int heigth;
	protected Point p;
	public Block(int id,int width,int heigth)
	{
		this.id=id;
		this.width=width;
		this.heigth=heigth;
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
	public void setPoint(Point p)
	{
		this.p=p;
	}
	public void paint(Graphics g)
	{
		g.drawImage(ImageProvider.getBlocks().get("yellowBlock"+this.getHeigth()+"x"+this.getWidth()),(p.x*Matrix.cellsize)+Matrix.cellsize+MainFrame.sumX,
				(p.y*Matrix.cellsize)+Matrix.cellsize+MainFrame.sumY,null);
	}
	public Point getPoint()
	{
		return p;
	}
}
