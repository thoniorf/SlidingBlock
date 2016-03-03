package it.slidingblock.gui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
	private static final long serialVersionUID=1L;
	private StartPanel startPanel;
	public MainFrame()
	{
		this.setSize(1366,768);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Sliding Block");
		this.setDefaultCloseOperation(0);
		this.startPanel=new StartPanel(this);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.setContentPane(startPanel);
		this.setVisible(true);
	}
}
