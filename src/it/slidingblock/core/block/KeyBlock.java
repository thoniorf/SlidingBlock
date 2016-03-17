package it.slidingblock.core.block;
import java.awt.Graphics;
import java.awt.Point;
import it.slidingblock.core.Matrix;
import it.slidingblock.gui.ImageProvider;
import it.slidingblock.gui.MainFrame;
public class KeyBlock extends Block
{
	public KeyBlock(int id,int width,int heigth)
	{
		super(id,width,heigth);
	}
	@Override
	public void setPoint(Point p)
	{
		super.setPoint(p);
	}
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(ImageProvider.getBlocks().get("redBlock"+this.getHeigth()+"x"+this.getWidth()),p.x*Matrix.cellsize+Matrix.cellsize+MainFrame.sumX,p.y*Matrix.cellsize+Matrix.cellsize+MainFrame.sumY,
				null);
	}
}
