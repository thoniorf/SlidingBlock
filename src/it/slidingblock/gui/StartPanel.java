package it.slidingblock.gui;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
public class StartPanel extends JPanel
{
	private static final long serialVersionUID=1;
	ModifiedButton close;
	ModifiedButton play;
	public StartPanel(final MainFrame frame)
	{
		this.setSize(frame.getSize());
		this.setLayout(null);
		this.play=new ModifiedButton(ImageProvider.getPlay1(),ImageProvider.getPlay2());
		this.play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.switchPanelPlay();
			}
		});
		this.play.setBounds((int) (this.getWidth()*0.1),(int) (this.getHeight()*0.60),play.getWidth(),play.getHeight());
		this.close=new ModifiedButton(ImageProvider.getClose1(),ImageProvider.getClose2());
		this.close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.confirmExit();
			}
		});
		this.close.setBounds((int) (this.getWidth()*0.1),(int) (this.getHeight()*0.80),close.getWidth(),close.getHeight());
		this.add(play);
		this.add(close);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		g.drawImage(ImageProvider.getStartPanel(),0,0,this.getWidth(),this.getHeight(),null);
	}
}
