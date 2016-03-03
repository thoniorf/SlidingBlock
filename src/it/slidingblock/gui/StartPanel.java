package it.slidingblock.gui;
import java.awt.Graphics;
import javax.swing.JPanel;
public class StartPanel extends JPanel
{
	private static final long serialVersionUID=1;
	public StartPanel(MainFrame frame)
	{
		this.setSize(frame.getSize());
		System.out.println(this.getSize());
		this.setLayout(null);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		g.drawImage(ImageProvider.getStartPanel(),0,0,ImageProvider.getStartPanel().getWidth(null),ImageProvider.getStartPanel().getHeight(null),null);
	}
}
