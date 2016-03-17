package it.slidingblock.core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import it.slidingblock.core.block.Block;
import it.slidingblock.gui.MainFrame;
public class Matrix
{
	public static final int cellsize=50;
	public int exitsize;
	private int width;
	private int height;
	private int[][] matrix;
	public Matrix(int width,int height,int exitsize)
	{
		this.width=width;
		this.height=height;
		this.exitsize=exitsize;
		this.matrix=new int[height][width];
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				matrix[i][j]=0;
	}
	public int getHeight()
	{
		return height;
	}
	public int[][] getMatrix()
	{
		return matrix;
	}
	public ArrayList<Point> getPosition(int id)
	{
		ArrayList<Point> temp=new ArrayList<>();
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				if (matrix[i][j]==id)
					temp.add(new Point(j,i));
		return temp;
	}
	public Point getFirstPoint(int id)
	{
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				if (matrix[i][j]==id)
					return new Point(j,i);
		return null;
	}
	public int getWidth()
	{
		return width;
	}
	public int getCell(int i,int j)
	{
		return matrix[i][j];
	}
	public boolean inserisci(Block b,Point o)
	{
		b.setPoint(o);
		for (int i=o.y;i<o.y+b.getHeigth();i++)
		{
			for (int j=o.x;j<o.x+b.getWidth();j++)
			{
				if (matrix[i][j]!=0)
				{
					return false;
				}
				matrix[i][j]=b.getId();
			}
		}
		return true;
	}
	public boolean sposta(int id,Direction d)
	{
		ArrayList<Point> temp=getPosition(id);
		for (Point point:temp)
		{
			matrix[(int) point.getX()][(int) point.getY()]=0;
		}
		switch (d)
		{
			case UP:
				for (Point point:temp)
				{
					if (point.getY()>0)
						matrix[((int) point.getY())-1][(int) point.getX()]=id;
					else
						return false;
				}
				break;
			case DOWN:
				for (Point point:temp)
				{
					if (point.getX()<height-1)
						matrix[((int) point.getY())+1][(int) point.getX()]=id;
					else
						return false;
				}
				break;
			case RIGHT:
				for (Point point:temp)
				{
					if (point.getX()<width-1)
						matrix[(int) point.getY()][((int) point.getX())+1]=id;
					else
						return false;
				}
				break;
			case LEFT:
				for (Point point:temp)
				{
					if (point.getY()>0)
						matrix[(int) point.getY()][((int) point.getX())-1]=id;
					else
						return false;
				}
				break;
		}
		return true;
	}
	public void paint(Graphics g)
	{
		// matrix border paint
		for (int i=0;i<=height;i++)
		{
			for (int j=0;j<=width;j++)
			{
				if (i==0||i==height||(i>0&&(j==0||j==width)))
				{
					if (!(i>=height-exitsize&&i<height&&j==0))
					{
						g.setColor(Color.DARK_GRAY);
					}
					else
					{
						g.setColor(Color.LIGHT_GRAY);
					}
				}
				else
				{
					g.setColor(Color.LIGHT_GRAY);
				}
				g.fillRect((j*Matrix.cellsize)+MainFrame.sumX,(i*Matrix.cellsize)+MainFrame.sumY,Matrix.cellsize,Matrix.cellsize);
			}
		}
	}
}
