package it.slidingblock.gui;

import it.slidingblock.combinazioni.SpostamentiC;
import it.slidingblock.core.Direction;
import it.slidingblock.core.Matrix;
import it.slidingblock.core.World;
import it.slidingblock.dlv.Interface;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int bselected;
	private int changeX;
	private int changeY;
	private int curX;
	private int curY;

	private ModifiedButton close;
	private ModifiedButton comeToStart;
	private ModifiedButton dlv;
	private ModifiedButton help;

	private final MainFrame frame;
	private final World world;

	public GamePanel(final MainFrame frame) {
		super(null);
		this.frame = frame;
		this.world = new World();
		this.setSize(frame.getSize());
		this.setButtons();
		this.bselected = -1;
		this.setFocusable(true);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int actualwidth = world.getMatrix().getWidth()
						* Matrix.cellsize;
				int actualheight = world.getMatrix().getHeight()
						* Matrix.cellsize;

				changeX = e.getX() - MainFrame.sumX - Matrix.cellsize;
				changeY = e.getY() - MainFrame.sumY - Matrix.cellsize;

				if ((changeX > 0 && changeX < actualwidth)
						&& (changeY > 0 && changeY < actualheight)) {
					changeX /= Matrix.cellsize;
					changeY /= Matrix.cellsize;
					dragged();
					repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int actualwidth = world.getMatrix().getWidth()
						* Matrix.cellsize;
				int actualheight = world.getMatrix().getHeight()
						* Matrix.cellsize;

				curX = e.getX() - MainFrame.sumX - Matrix.cellsize;
				curY = e.getY() - MainFrame.sumY - Matrix.cellsize;

				if ((curX > 0 && curX < actualwidth)
						&& (curY > 0 && curY < actualheight)) {
					curX /= Matrix.cellsize;
					curY /= Matrix.cellsize;
					bselected = world.getMatrix().getCell(curY, curX);
				}

			}
		});
		this.setVisible(true);
	}

	private void dragged() {
		if (bselected > 0) {
			int dirX = changeX - curX;
			int dirY = changeY - curY;
			if (dirY != 0 && dirX == 0) {
				if (dirY == 1)
					world.getMatrix().move(bselected, Direction.DOWN);
				else
					world.getMatrix().move(bselected, Direction.UP);
			} else if (dirX != 0 && dirY == 0) {
				if (dirX == -1)
					world.getMatrix().move(bselected, Direction.LEFT);
				else
					world.getMatrix().move(bselected, Direction.RIGHT);
			} else {
				return;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getGamePanel(), 0, 0, this.getWidth(),
				this.getHeight(), null);
		world.paint(g);
	}

	private void setButtons() {
		this.dlv = new ModifiedButton(ImageProvider.getDlv1(),
				ImageProvider.getDlv2());
		this.dlv.setBounds((int) (this.getWidth() * 0.8),
				(int) (this.getHeight() * 0.15), dlv.getWidth(),
				dlv.getHeight());
		this.dlv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interface dlv = new Interface(world.getMatrix().getWidth());
				ArrayList<SpostamentiC> spostamenti = dlv.compute(world, 5);
				spostamenti.sort(null);
				for (SpostamentiC s : spostamenti) {
					if ("su".equals(s.getDirezione()))
						world.getMatrix().move(s.blocco, Direction.UP);
					else if ("giu".equals(s.getDirezione()))
						world.getMatrix().move(s.blocco, Direction.DOWN);
					else if ("sinistra".equals(s.getDirezione()))
						world.getMatrix().move(s.blocco, Direction.LEFT);
					else if ("destra".equals(s.getDirezione()))
						world.getMatrix().move(s.blocco, Direction.RIGHT);

					frame.getGamePanel().paintImmediately(
							new Rectangle(MainFrame.sumX, MainFrame.sumY,
									MainFrame.sumX * 5, MainFrame.sumY * 5));
					try {
						Thread.sleep(1200);
					} catch (InterruptedException ex) {
						System.err.println("Thread interruption");
					}
				}
			}
		});
		this.help = new ModifiedButton(ImageProvider.getHelp1(),
				ImageProvider.getHelp2());
		this.help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interface dlv = new Interface(world.getMatrix().getWidth());
				ArrayList<SpostamentiC> spostamenti = dlv.compute(world, 5);
				spostamenti.sort(null);
				SpostamentiC s = spostamenti.get(0);
				if ("su".equals(s.getDirezione()))
					world.getMatrix().move(s.blocco, Direction.UP);
				else if ("giu".equals(s.getDirezione()))
					world.getMatrix().move(s.blocco, Direction.DOWN);
				else if ("sinistra".equals(s.getDirezione()))
					world.getMatrix().move(s.blocco, Direction.LEFT);
				else if ("destra".equals(s.getDirezione()))
					world.getMatrix().move(s.blocco, Direction.RIGHT);

				frame.getGamePanel().paintImmediately(
						new Rectangle(MainFrame.sumX, MainFrame.sumY,
								MainFrame.sumX * 5, MainFrame.sumY * 5));
			}
		});
		this.help.setBounds((int) (this.getWidth() * 0.8),
				(int) (this.getHeight() * 0.35), help.getWidth(),
				help.getHeight());
		this.comeToStart = new ModifiedButton(ImageProvider.getCome1(),
				ImageProvider.getCome2());
		this.comeToStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.switchPanelStart();
			}
		});
		this.comeToStart.setBounds((int) (this.getWidth() * 0.05),
				(int) (this.getHeight() * 0.65), comeToStart.getWidth(),
				comeToStart.getHeight());
		this.close = new ModifiedButton(ImageProvider.getClosePlayPanel1(),
				ImageProvider.getClosePlayPanel2());
		this.close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
