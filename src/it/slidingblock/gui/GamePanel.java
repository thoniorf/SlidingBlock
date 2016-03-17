package it.slidingblock.gui;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import it.slidingblock.core.Matrix;
import it.slidingblock.core.World;
public class GamePanel extends JPanel
{
	private static final long serialVersionUID=1L;
	private MainFrame frame;
	private World world;
	private int curX=0;
	private int curY=0;
	private ModifiedButton dlv;
	private ModifiedButton help;
	private ModifiedButton comeToStart;
	private ModifiedButton close;
	private int bselected;
	public GamePanel(MainFrame frame)
	{
		this.frame=frame;
		this.world=new World();
		this.setSize(frame.getSize());
		this.setLayout(null);
		this.setButtons();
		this.bselected=-1;
		this.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				curX=e.getX()-MainFrame.sumX-Matrix.cellsize;
				curY=e.getY()-MainFrame.sumY-Matrix.cellsize;
			}
			@Override
			public void mouseDragged(MouseEvent e)
			{
				// if (e.getX()<curX)
				// {
				// if (world.getMatrix().sposta(bselected,Direction.LEFT))
				// System.out.println("ok-left");
				// }
				// else if (e.getX()>curX)
				// {
				// if (world.getMatrix().sposta(bselected,Direction.RIGHT))
				// System.out.println("ok-right");
				// }
				// else if (e.getY()<curY)
				// {
				// if (world.getMatrix().sposta(bselected,Direction.UP))
				// System.out.println("ok-up");
				// }
				// else if (e.getY()>curX)
				// {
				// if (world.getMatrix().sposta(bselected,Direction.DOWN))
				// System.out.println("ok-down");
				// }
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				blockSelected();
			}
		});
	}
	private void blockSelected()
	{
		if ((curX>0&&curX<(world.getMatrix().getWidth()-1)*Matrix.cellsize)&&(curY>0&&curY<(world.getMatrix().getHeight()-1)*Matrix.cellsize))
		{
			curX/=50;
			curY/=50;
			bselected=world.getMatrix().getCell(curY,curX);
		}
	}
	private void setButtons()
	{
		this.dlv=new ModifiedButton(ImageProvider.getDlv1(),ImageProvider.getDlv2(),null);
		this.dlv.setBounds((int) (this.getWidth()*0.8),(int) (this.getHeight()*0.15),dlv.getWidth(),dlv.getHeight());
		this.help=new ModifiedButton(ImageProvider.getHelp1(),ImageProvider.getHelp2(),null);
		this.help.setBounds((int) (this.getWidth()*0.8),(int) (this.getHeight()*0.35),help.getWidth(),help.getHeight());
		this.comeToStart=new ModifiedButton(ImageProvider.getCome1(),ImageProvider.getCome2(),e -> frame.switchPanelStart());
		this.comeToStart.setBounds((int) (this.getWidth()*0.05),(int) (this.getHeight()*0.65),comeToStart.getWidth(),comeToStart.getHeight());
		this.close=new ModifiedButton(ImageProvider.getClosePlayPanel1(),ImageProvider.getClosePlayPanel2(),e -> frame.confirmExit());
		this.close.setBounds((int) (this.getWidth()*0.05),(int) (this.getHeight()*0.80),close.getWidth(),close.getHeight());
		this.add(dlv);
		this.add(help);
		this.add(comeToStart);
		this.add(close);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(ImageProvider.getGamePanel(),0,0,this.getWidth(),this.getHeight(),null);
		world.paint(g);
	}
	public int getCurX()
	{
		return curX;
	}
	public int getCurY()
	{
		return curY;
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public int getBselected()
	{
		return bselected;
	}
}
