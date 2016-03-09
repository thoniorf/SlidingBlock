package it.slidingblock.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private StartPanel startPanel;

	public MainFrame()
	{
		this.setSize(1366, 768);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Sliding Block");
		this.setDefaultCloseOperation(0);
		this.startPanel = new StartPanel(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(startPanel);
		this.setVisible(true);
	}
}
