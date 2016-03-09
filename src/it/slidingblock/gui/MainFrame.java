package it.slidingblock.gui;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
	private static final long serialVersionUID=1L;
	public MainFrame()
	{
		this.setSize(1366,768);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Sliding Block");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new StartPanel(this));
		this.setVisible(true);
	}
	public void switchPanelPlay()
	{
		this.setContentPane(new GamePanel(this));
		this.revalidate();
	}
}
