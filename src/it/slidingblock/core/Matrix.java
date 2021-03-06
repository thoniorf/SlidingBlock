package it.slidingblock.core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;
import it.slidingblock.dlv.Adiacenze;
import it.slidingblock.gui.MainFrame;
public class Matrix
{
	public static final int cellsize = 50;
	private Point exitCell;
	private int height;
	private int width;
	private int key;
	private int[][] matrix;
	private Set<Adiacenze> right = new HashSet<Adiacenze>();
	private Set<Adiacenze> up = new HashSet<Adiacenze>();
	private Set<Adiacenze> down = new HashSet<Adiacenze>();
	private Set<Adiacenze> left = new HashSet<Adiacenze>();
	private Set<Adiacenze> adiacenze = new HashSet<Adiacenze>();
	public Point getExitCell()
	{
		return exitCell;
	}
	public Matrix(int width, int height, Point exitCell)
	{
		this.key=0;
		this.width = width;
		this.height = height;
		this.exitCell = exitCell;
		this.matrix = new int[height][width];
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if ((i + 1) < height)
				{
					down.add(new Adiacenze(i, j, i + 1, j));
					adiacenze.add(new Adiacenze(i, j, i + 1, j));
				}
				if ((i - 1) >= 0)
				{
					up.add(new Adiacenze(i, j, i - 1, j));
					adiacenze.add(new Adiacenze(i, j, i - 1, j));
				}
				if ((j + 1) < width)
				{
					right.add(new Adiacenze(i, j, i, j + 1));
					adiacenze.add(new Adiacenze(i, j, i, j + 1));
				}
				if ((j - 1) >= 0)
				{
					left.add(new Adiacenze(i, j, i, j - 1));
					adiacenze.add(new Adiacenze(i, j, i, j - 1));
				}
			}
		}
	}
	public Set<Adiacenze> getRight()
	{
		return right;
	}
	public Set<Adiacenze> getUp()
	{
		return up;
	}
	public Set<Adiacenze> getDown()
	{
		return down;
	}
	public Set<Adiacenze> getLeft()
	{
		return left;
	}
	public Set<Adiacenze> getAdiacenze()
	{
		return adiacenze;
	}
	private boolean canMove(ArrayList<Point> temp, Direction d, int id)
	{
		boolean move = true;
		for (Point point : temp)
		{
			if (d == Direction.UP)
			{
				if (point.getX() == 0)
				{
					move = false;
				}
				if (move
						&& (matrix[((int) point.getX()) - 1][(int) point.getY()] != 0)
						&& (matrix[((int) point.getX()) - 1][(int) point.getY()] != id))
				{
					move = false;
				}
			} else if (d == Direction.DOWN)
			{
				if (point.getX() == height - 1)
				{
					move = false;
				}
				if (move
						&& (matrix[((int) point.getX()) + 1][(int) point.getY()] != 0)
						&& (matrix[((int) point.getX()) + 1][(int) point.getY()] != id))
				{
					move = false;
				}
			} else if (d == Direction.RIGHT)
			{
				if (point.getY() == width - 1)
				{
					move = false;
				}
				if (move
						&& (matrix[(int) point.getX()][((int) point.getY()) + 1] != 0)
						&& (matrix[(int) point.getX()][((int) point.getY()) + 1] != id))
				{
					move = false;
				}
			} else if (d == Direction.LEFT)
			{
				if (point.getY() == 0)
				{
					move = false;
				}
				if (move
						&& (matrix[(int) point.getX()][((int) point.getY()) - 1] != 0)
						&& (matrix[(int) point.getX()][((int) point.getY()) - 1] != id))
				{
					move = false;
				}
			}
		}
		return move;
	}
	public int getCell(int i, int j)
	{
		return matrix[i][j];
	}
	public Point getFirstPoint(int id)
	{
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (matrix[i][j] == id)
				{
					return new Point(j, i);
				}
			}
		}
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
		ArrayList<Point> temp = new ArrayList<Point>();
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (matrix[i][j] == id)
				{
					temp.add(new Point(i, j));
				}
			}
		}
		return temp;
	}
	public ArrayList<Point> getEmpty()
	{
		ArrayList<Point> temp = new ArrayList<Point>();
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (matrix[i][j] == 0)
				{
					temp.add(new Point(i, j));
				}
			}
		}
		return temp;
	}
	public int getWidth()
	{
		return width;
	}
	public boolean insert(Block b, Point o)
	{
		if (b instanceof KeyBlock)
			key=b.getId();
		for (int i = o.y; i < o.y + b.getWidth(); i++)
		{
			for (int j = o.x; j < o.x + b.getHeigth(); j++)
			{
				if (matrix[j][i] != 0)
				{
					return false;
				}
				matrix[j][i] = b.getId();
			}
		}
		return true;
	}
	public int getKey()
	{
		return key;
	}
	public boolean move(int id, Direction d)
	{
		ArrayList<Point> temp = getPosition(id);
		if (canMove(temp, d, id))
		{
			for (Point point : temp)
			{
				matrix[(int) point.getX()][(int) point.getY()] = 0;
			}
			switch (d)
			{
			case UP:
				for (Point point : temp)
				{
					matrix[((int) point.getX()) - 1][(int) point.getY()] = id;
				}
				break;
			case DOWN:
				for (Point point : temp)
				{
					matrix[((int) point.getX()) + 1][(int) point.getY()] = id;
				}
				break;
			case RIGHT:
				for (Point point : temp)
				{
					matrix[(int) point.getX()][((int) point.getY()) + 1] = id;
				}
				break;
			case LEFT:
				for (Point point : temp)
				{
					matrix[(int) point.getX()][((int) point.getY()) - 1] = id;
				}
				break;
			}
			return true;
		} else
		{
			return false;
		}
	}
	public void paint(Graphics g)
	{
		for (int i = 0; i <= height + 1; i++)
		{
			for (int j = 0; j <= width + 1; j++)
			{
				g.setColor(Color.DARK_GRAY);
				if (exitCell.x == i - 1 && exitCell.y == j)
				{
					g.setColor(Color.LIGHT_GRAY);
				}
				g.fillRect((j * Matrix.cellsize) - Matrix.cellsize
						+ MainFrame.sumX, (i * Matrix.cellsize)
						- Matrix.cellsize + MainFrame.sumY, Matrix.cellsize,
						Matrix.cellsize);
			}
		}
		// matrix paint
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect((j * Matrix.cellsize) + MainFrame.sumX,
						(i * Matrix.cellsize) + MainFrame.sumY,
						Matrix.cellsize, Matrix.cellsize);
			}
		}
	}
}
