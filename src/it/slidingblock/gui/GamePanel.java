package it.slidingblock.gui;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import it.slidingblock.core.World;
public class GamePanel extends JPanel
{
	private static final long serialVersionUID=1L;
	private MainFrame frame;
	private World world;
	private ModifiedButton dlv;
	private ModifiedButton help;
	private ModifiedButton comeToStart;
	private ModifiedButton close;
	public GamePanel(MainFrame frame)
	{
		this.frame=frame;
		this.world=new World();
		this.setSize(frame.getSize());
		this.setLayout(null);
		this.setButtons();
	}
	private void setButtons()
	{
		this.dlv=new ModifiedButton(ImageProvider.getDlv1(),ImageProvider.getDlv2(),null);
		this.dlv.setBounds((int) (this.getWidth()*0.8),(int) (this.getHeight()*0.15),dlv.getWidth(),dlv.getHeight());
		this.help=new ModifiedButton(ImageProvider.getHelp1(),ImageProvider.getHelp2(),null);
		this.help.setBounds((int) (this.getWidth()*0.8),(int) (this.getHeight()*0.35),help.getWidth(),help.getHeight());
		this.comeToStart=new ModifiedButton(ImageProvider.getCome1(),ImageProvider.getCome2(),e -> frame.switchPanelStart());
		this.comeToStart.setBounds((int) (this.getWidth()*0.05),(int) (this.getHeight()*0.65),comeToStart.getWidth(),comeToStart.getHeight());
		this.close=new ModifiedButton(ImageProvider.getClosePlayPanel1(),ImageProvider.getClosePlayPanel2(),e -> frame.confirmExit());
		this.close.setBounds((int) (this.getWidth()*0.05),(int) (this.getHeight()*0.80),close.getWidth(),close.getHeight());
		this.add(dlv);
		this.add(help);
		this.add(comeToStart);
		this.add(close);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(ImageProvider.getGamePanel(),0,0,this.getWidth(),this.getHeight(),null);
		world.paint(g);
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
}
