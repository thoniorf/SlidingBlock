package it.slidingblock.gui;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class ImageProvider
{
	private static Image redBlock1x1;
	private static Image yellowBlock1x1;
	private static Image redBlock2x1;
	private static Image yellowBlock2x1;
	private static Image redBlock1x2;
	private static Image yellowBlock1x2;
	private static Image redBlock2x2;
	private static Image yellowBlock2x2;
	private static Image startPanel;
	private static ImageIcon play1;
	private static ImageIcon play2;
	private static ImageIcon close2;
	private static ImageIcon close1;
	static
	{
		try
		{
			startPanel=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/startPanel.png"));
			redBlock1x1=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/redBlock1x1.png"));
			redBlock1x2=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/redBlock1x2.png"));
			redBlock2x1=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/redBlock2x1.png"));
			redBlock2x2=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/redBlock2x2.png"));
			yellowBlock1x1=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yellowBlock1x1.png"));
			yellowBlock1x2=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yellowBlock1x2.png"));
			yellowBlock2x1=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yellowBlock2x1.png"));
			yellowBlock2x2=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yellowBlock2x2.png"));
			play1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/play1.png")));
			play2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/play2.png")));
			close1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/close1.png")));
			close2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/close2.png")));
		}
		catch (final IOException e)
		{
			System.out.println("Cannot read Image");
		}
	}
	public static ImageIcon getPlay1()
	{
		return play1;
	}
	public static ImageIcon getPlay2()
	{
		return play2;
	}
	public static Image getRedBlock1x1()
	{
		return redBlock1x1;
	}
	public static Image getRedBlock1x2()
	{
		return redBlock1x2;
	}
	public static Image getRedBlock2x1()
	{
		return redBlock2x1;
	}
	public static Image getRedBlock2x2()
	{
		return redBlock2x2;
	}
	public static Image getStartPanel()
	{
		return startPanel;
	}
	public static Image getYellowBlock1x1()
	{
		return yellowBlock1x1;
	}
	public static Image getYellowBlock1x2()
	{
		return yellowBlock1x2;
	}
	public static Image getYellowBlock2x1()
	{
		return yellowBlock2x1;
	}
	public static Image getYellowBlock2x2()
	{
		return yellowBlock2x2;
	}
	public static ImageIcon getClose1()
	{
		return close1;
	}
	public static ImageIcon getClose2()
	{
		return close2;
	}
}
