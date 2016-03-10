package it.slidingblock.gui;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.slidingblock.core.World;

public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private World world;

	public GamePanel(MainFrame frame)
	{
		this.frame = frame;
		this.world = new World();

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		world.paint(g);
	}

	public JFrame getFrame()
	{
		return this.frame;
	}
}
