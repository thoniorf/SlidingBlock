package it.slidingblock.gui;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
	private boolean win;
	private ModifiedButton close;
	private ModifiedButton comeToStart;
	private ModifiedButton dlv;
	private MainFrame frame;
	private ModifiedButton help;
	private int curX;
	private int curY;
	private World world;
	public GamePanel(final MainFrame frame, String level)
	{
		super(null);
		this.frame = frame;
		this.world = new World(level);
		this.setSize(frame.getSize());
		this.setButtons();
		this.bselected = -1;
		this.setFocusable(true);
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int actualwidth = world.getMatrix().getWidth()
						* Matrix.cellsize;
				int actualheight = world.getMatrix().getHeight()
						* Matrix.cellsize;
				curX = e.getX() - MainFrame.sumX;
				curY = e.getY() - MainFrame.sumY;
				if ((curX > 0 && curX < actualwidth)
						&& (curY > 0 && curY < actualheight))
				{
					curX /= Matrix.cellsize;
					curY /= Matrix.cellsize;
					bselected = world.getMatrix().getCell(curY, curX);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				int actualwidth = world.getMatrix().getWidth()
						* Matrix.cellsize;
				int actualheight = world.getMatrix().getHeight()
						* Matrix.cellsize;
				changeX = e.getX() - MainFrame.sumX;
				changeY = e.getY() - MainFrame.sumY;
				if ((changeX > 0 && changeX < actualwidth)
						&& (changeY > 0 && changeY < actualheight))
				{
					changeX /= Matrix.cellsize;
					changeY /= Matrix.cellsize;
					dragged();
					if (world.getMatrix().getCell(
							world.getMatrix().getExitCell().x,
							world.getMatrix().getExitCell().y) == world
							.getMatrix().getKey())
					{
						win = true;
						paintImmediately(new Rectangle(0, 0, getWidth(),
								getHeight()));
						try
						{
							Thread.sleep(2000);
						} catch (InterruptedException e1)
						{
							e1.printStackTrace();
						}
					}
					repaint();
				}
			}
		});
		this.setVisible(true);
	}
	private void dragged()
	{
		if (bselected > 0)
		{
			int dirX = changeX - curX;
			int dirY = changeY - curY;
			if (dirY != 0 && dirX == 0)
			{
				if (dirY == 1)
				{
					world.getMatrix().move(bselected, Direction.DOWN);
				} else
				{
					world.getMatrix().move(bselected, Direction.UP);
				}
			} else if (dirX != 0 && dirY == 0)
			{
				if (dirX == -1)
				{
					world.getMatrix().move(bselected, Direction.LEFT);
				} else
				{
					world.getMatrix().move(bselected, Direction.RIGHT);
				}
			} else
			{
				return;
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
		if (win)
		{
			g.drawImage(
					ImageProvider.getCongratulition(),
					(this.getWidth() / 2)
							- (ImageProvider.getCongratulition().getWidth(null) / 2),
					(this.getHeight() / 2)
							- (ImageProvider.getCongratulition()
									.getHeight(null) / 2), null);
			frame.switchPanelStart();
		}
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
				Interface dlv = new Interface();
				ArrayList<Spostamenti> spostamenti = dlv.compute(world);
				if (spostamenti.isEmpty())
				{
					new RequestPanel(frame, 2);
				} else
				{
					spostamenti.sort(null);
					for (Spostamenti s : spostamenti)
					{
						int diffX = s.arrivoriga - s.partenzariga;
						int diffY = s.arrivocolonna - s.partenzacolonna;
						if (diffX < 0)
						{
							world.getMatrix().move(s.blocco, Direction.UP);
						} else if (diffX > 0)
						{
							world.getMatrix().move(s.blocco, Direction.DOWN);
						} else if (diffY < 0)
						{
							world.getMatrix().move(s.blocco, Direction.LEFT);
						} else if (diffY > 0)
						{
							world.getMatrix().move(s.blocco, Direction.RIGHT);
						}
						paintImmediately(new Rectangle(0, 0, getWidth(),
								getHeight()));
						if (world.getMatrix().getCell(
								world.getMatrix().getExitCell().x,
								world.getMatrix().getExitCell().y) == world
								.getMatrix().getKey())
							win = true;
						try
						{
							Thread.sleep(1200);
						} catch (InterruptedException e1)
						{
						}
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
				Interface dlv = new Interface();
				ArrayList<Spostamenti> spostamenti = dlv.compute(world);
				if (spostamenti.isEmpty())
				{
					new RequestPanel(frame, 2);
				} else
				{
					spostamenti.sort(null);
					int diffX = spostamenti.get(0).arrivoriga
							- spostamenti.get(0).partenzariga;
					int diffY = spostamenti.get(0).arrivocolonna
							- spostamenti.get(0).partenzacolonna;
					if (diffX < 0)
					{
						world.getMatrix().move(spostamenti.get(0).blocco,
								Direction.UP);
					} else if (diffX > 0)
					{
						world.getMatrix().move(spostamenti.get(0).blocco,
								Direction.DOWN);
					} else if (diffY < 0)
					{
						world.getMatrix().move(spostamenti.get(0).blocco,
								Direction.LEFT);
					} else if (diffY > 0)
					{
						world.getMatrix().move(spostamenti.get(0).blocco,
								Direction.RIGHT);
					}
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
