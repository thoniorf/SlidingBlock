package it.slidingblock.core;

import java.awt.Point;
import java.util.ArrayList;

import it.slidingblock.core.block.Block;

public class Matrix
{
	private int width;
	private int height;
	private int[][] matrix;

	public Matrix(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.matrix = new int[height][width];
		for (int a = 0; a < height; a++)
			for (int b = 0; b < width; b++)
				matrix[a][b] = 0;
	}

	public boolean sposta(int id, Direction d)
	{
		// TODO da modificare
		ArrayList<Point> temp = getPosition(id);
		for (Point point : temp)
		{
			matrix[(int) point.getX()][(int) point.getY()] = 0;
		}
		switch (d)
		{
			case UP:
				for (Point point : temp)
				{
					if (point.getY() > 0)
						matrix[((int) point.getX()) - 1][(int) point.getY()] = 1;
					else
						return false;
				}
				break;
			case DOWN:
				for (Point point : temp)
				{
					if (point.getX() < height)
						matrix[((int) point.getX()) + 1][(int) point.getY()] = 1;
					else
						return false;
				}
				break;
			case RIGHT:
				for (Point point : temp)
				{
					if (point.getX() < width)
						matrix[(int) point.getX()][((int) point.getY()) + 1] = 1;
					else
						return false;
				}
				break;
			case LEFT:
				for (Point point : temp)
				{
					if (point.getY() > 0)
						matrix[(int) point.getX()][((int) point.getY()) - 1] = 1;
					else
						return false;
				}
				break;
		}
		return true;
	}

	public ArrayList<Point> getPosition(int id)
	{
		ArrayList<Point> temp = new ArrayList<>();
		for (int a = 0; a < height; a++)
			for (int b = 0; b < width; b++)
				if (matrix[a][b] == id)
					temp.add(new Point(a, b));
		return temp;
	}

	public boolean inserisci(Block b, Point o)
	{
		for (int i = o.y; i < o.y + b.getHeigth(); i++)
		{
			for (int j = o.x; j < o.x + b.getWidth(); j++)
			{
				if (matrix[i][j] != 0)
				{
					return false;
				}
				matrix[i][j] = b.getId();

			}
		}
		return true;
	}
}
