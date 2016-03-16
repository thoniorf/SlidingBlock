package it.slidingblock.gui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
	public static final int sumX=500;
	public static final int sumY=100;
	private static final long serialVersionUID=1L;
	public MainFrame()
	{
		this.setSize(1366,768);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Sliding Block");
		this.setDefaultCloseOperation(0);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				MainFrame.this.confirmExit();
			}
		});
		this.setContentPane(new StartPanel(this));
		this.setVisible(true);
	}
	public void confirmExit()
	{
		new RequestPanel(this,1);
	}
	public void switchPanelPlay()
	{
		this.setContentPane(new GamePanel(this));
		this.revalidate();
	}
	public void switchPanelStart()
	{
		this.setContentPane(new StartPanel(this));
		this.revalidate();
	}
}
