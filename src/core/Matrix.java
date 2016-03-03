package core;
import java.awt.Point;
import java.util.ArrayList;
public class Matrix
{
	private int width;
	private int heigth;
	private int[][] matrix;
	public Matrix(int width,int heigth)
	{
		this.width=width;
		this.heigth=heigth;
		this.matrix=new int[width][heigth];
		for (int a=0;a<width;a++)
			for (int b=0;b<heigth;b++)
				matrix[a][b]=0;
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
						matrix[((int) point.getX())-1][(int) point.getY()]=1;
					else
						return false;
				}
				break;
			case DOWN:
				for (Point point:temp)
				{
					if (point.getX()<heigth)
						matrix[((int) point.getX())+1][(int) point.getY()]=1;
					else
						return false;
				}
				break;
			case RIGHT:
				for (Point point:temp)
				{
					if (point.getX()<width)
						matrix[(int) point.getX()][((int) point.getY())+1]=1;
					else
						return false;
				}
				break;
			case LEFT:
				for (Point point:temp)
				{
					if (point.getY()>0)
						matrix[(int) point.getX()][((int) point.getY())-1]=1;
					else
						return false;
				}
				break;
		}
		return true;
	}
	public ArrayList<Point> getPosition(int id)
	{
		ArrayList<Point> temp=new ArrayList<>();
		for (int a=0;a<width;a++)
			for (int b=0;b<heigth;b++)
				if (matrix[a][b]==id)
					temp.add(new Point(a,b));
		return temp;
	}
}
