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
	private int height;
	private int[][] matrix;
	private int width;
	public int exitsize;
	public Matrix(int width,int height,int exitsize)
	{
		this.width=width;
		this.height=height;
		this.exitsize=exitsize;
		this.matrix=new int[width][height];
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				matrix[i][j]=0;
	}
	public int getCell(int i,int j)
	{
		return matrix[i][j];
	}
	public Point getFirstPoint(int id)
	{
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				if (matrix[i][j]==id)
					return new Point(j,i);
		return null;
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
		for (int i=0;i<width;i++)
			for (int j=0;j<height;j++)
				if (matrix[i][j]==id)
					temp.add(new Point(i,j));
		return temp;
	}
	public int getWidth()
	{
		return width;
	}
	public boolean insert(Block b,Point o)
	{
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
	public void paint(Graphics g)
	{
		// matrix border paint
		for (int i=0;i<=height+1;i++)
		{
			for (int j=0;j<=width+1;j++)
			{
				if (i==0||i==height+1||(i>0&&(j==0||j==width+1)))
				{
					if (!(i>=(height+1)-exitsize&&i<(height+1)&&j==0))
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
	public boolean move(int id,Direction d)
	{
		boolean canMove=true;
		ArrayList<Point> temp=getPosition(id);
		for (Point point:temp)
		{
			if (d==Direction.UP&&point.getX()==0)
				canMove=false;
			else if (d==Direction.DOWN&&point.getX()==height-1)
				canMove=false;
			else if (d==Direction.RIGHT&&point.getY()==width-1)
				canMove=false;
			else if (d==Direction.LEFT&&point.getY()==0)
				canMove=false;
		}
		if (canMove)
		{
			for (Point point:temp)
			{
				matrix[(int) point.getX()][(int) point.getY()]=0;
			}
			switch (d)
			{
				case UP:
					for (Point point:temp)
					{
						matrix[((int) point.getX())-1][(int) point.getY()]=id;
					}
					break;
				case DOWN:
					for (Point point:temp)
					{
						matrix[((int) point.getX())+1][(int) point.getY()]=id;
					}
					break;
				case RIGHT:
					for (Point point:temp)
					{
						matrix[(int) point.getX()][((int) point.getY())+1]=id;
					}
					break;
				case LEFT:
					for (Point point:temp)
					{
						matrix[(int) point.getX()][((int) point.getY())-1]=id;
					}
					break;
			}
			return true;
		}
		else
			return false;
	}
}
