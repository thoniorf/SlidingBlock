package it.slidingblock.gui;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
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
		}
		catch (final IOException e)
		{
			System.out.println("Cannot read Image");
		}
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
	public static Image getStartPanel()
	{
		return startPanel;
	}
}
