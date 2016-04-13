package it.slidingblock.gui;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JPanel;
import it.slidingblock.core.Direction;
import it.slidingblock.core.Matrix;
import it.slidingblock.core.World;
import it.slidingblock.dlv.Interface;
import it.slidingblock.dlv.Spostamenti;
public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int bselected;
	private int changeX;
	private int changeY;
	private ModifiedButton close;
	private ModifiedButton comeToStart;
	private int curX;
	private int curY;
	private ModifiedButton dlv;
	private MainFrame frame;
	private ModifiedButton help;
	private World world;
	public GamePanel(MainFrame frame)
	{
		this.frame = frame;
		this.world = new World();
		this.setSize(frame.getSize());
		this.setLayout(null);
		this.setButtons();
		this.bselected = -1;
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				blockSelected();
				dragged(e);
				bselected = -1;
				repaint();
			}
			public void mouseMoved(MouseEvent e)
			{
				curX = e.getX() - MainFrame.sumX - Matrix.cellsize;
				curY = e.getY() - MainFrame.sumY - Matrix.cellsize;
			}
		});
	}
	private void blockSelected()
	{
		if ((curX > 0 && curX < (world.getMatrix().getWidth())
				* Matrix.cellsize)
				&& (curY > 0 && curY < (world.getMatrix().getHeight())
						* Matrix.cellsize))
		{
			changeX = curX;
			changeY = curY;
			curX /= 50;
			curY /= 50;
			bselected = world.getMatrix().getCell(curY, curX);
		}
	}
	private void dragged(MouseEvent e)
	{
		if (bselected > 0)
		{
			int moveY = e.getY() - MainFrame.sumY - Matrix.cellsize;
			int moveX = e.getX() - MainFrame.sumX - Matrix.cellsize;
			if (Math.abs(moveY - changeY) > Math.abs(moveX - changeX))
			{
				if (changeY < e.getY() - MainFrame.sumY - Matrix.cellsize)
					world.getMatrix().move(bselected, Direction.DOWN);
				else if (changeY > e.getY() - MainFrame.sumY - Matrix.cellsize)
					world.getMatrix().move(bselected, Direction.UP);
			} else
			{
				if (changeX > e.getX() - MainFrame.sumX - Matrix.cellsize)
					world.getMatrix().move(bselected, Direction.LEFT);
				else if (changeX < e.getX() - MainFrame.sumX - Matrix.cellsize)
					world.getMatrix().move(bselected, Direction.RIGHT);
			}
		}
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(ImageProvider.getGamePanel(), 0, 0, this.getWidth(),
				this.getHeight(), null);
		world.paint(g);
	}
	private void setButtons()
	{
		this.dlv = new ModifiedButton(ImageProvider.getDlv1(),
				ImageProvider.getDlv2());
		this.dlv.setBounds((int) (this.getWidth() * 0.8),
				(int) (this.getHeight() * 0.15), dlv.getWidth(),
				dlv.getHeight());
		this.dlv.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface dlv = new Interface(world.getMatrix().getWidth());
				ArrayList<Spostamenti> spostamenti = dlv.compute(world);
				spostamenti.sort(null);
				for (Spostamenti s : spostamenti)
				{
					int diffX = s.arrivoriga - s.partenzariga;
					int diffY = s.arrivocolonna - s.partenzacolonna;
					if (diffX < 0)
						world.getMatrix().move(s.blocco, Direction.UP);
					else if (diffX > 0)
						world.getMatrix().move(s.blocco, Direction.DOWN);
					else if (diffY < 0)
						world.getMatrix().move(s.blocco, Direction.LEFT);
					else if (diffY > 0)
						world.getMatrix().move(s.blocco, Direction.RIGHT);
					frame.getGamePanel().paintImmediately(
							new Rectangle(MainFrame.sumX, MainFrame.sumY,
									MainFrame.sumX * 5, MainFrame.sumY * 5));
					try
					{
						Thread.sleep(1200);
					} catch (InterruptedException e1)
					{
					}
				}
			}
		});
		this.help = new ModifiedButton(ImageProvider.getHelp1(),
				ImageProvider.getHelp2());
		this.help.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface dlv = new Interface(world.getMatrix().getWidth());
				ArrayList<Spostamenti> spostamenti = dlv.compute(world);
				spostamenti.sort(null);
				int diffX = spostamenti.get(0).arrivoriga
						- spostamenti.get(0).partenzariga;
				int diffY = spostamenti.get(0).arrivocolonna
						- spostamenti.get(0).partenzacolonna;
				if (diffX < 0)
					world.getMatrix().move(spostamenti.get(0).blocco,
							Direction.UP);
				else if (diffX > 0)
					world.getMatrix().move(spostamenti.get(0).blocco,
							Direction.DOWN);
				else if (diffY < 0)
					world.getMatrix().move(spostamenti.get(0).blocco,
							Direction.LEFT);
				else if (diffY > 0)
					world.getMatrix().move(spostamenti.get(0).blocco,
							Direction.RIGHT);
				frame.getGamePanel().paintImmediately(
						new Rectangle(MainFrame.sumX, MainFrame.sumY,
								MainFrame.sumX * 5, MainFrame.sumY * 5));
				try
				{
					Thread.sleep(1200);
				} catch (InterruptedException e1)
				{
				}
			}
		});
		this.help.setBounds((int) (this.getWidth() * 0.8),
				(int) (this.getHeight() * 0.35), help.getWidth(),
				help.getHeight());
		this.comeToStart = new ModifiedButton(ImageProvider.getCome1(),
				ImageProvider.getCome2());
		this.comeToStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.switchPanelStart();
			}
		});
		this.comeToStart.setBounds((int) (this.getWidth() * 0.05),
				(int) (this.getHeight() * 0.65), comeToStart.getWidth(),
				comeToStart.getHeight());
		this.close = new ModifiedButton(ImageProvider.getClosePlayPanel1(),
				ImageProvider.getClosePlayPanel2());
		this.close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.confirmExit();
			}
		});
		this.close.setBounds((int) (this.getWidth() * 0.05),
				(int) (this.getHeight() * 0.80), close.getWidth(),
				close.getHeight());
		this.add(dlv);
		this.add(help);
		this.add(comeToStart);
		this.add(close);
	}
}
