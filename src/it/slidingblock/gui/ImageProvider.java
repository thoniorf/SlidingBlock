package it.slidingblock.gui;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class ImageProvider
{
	private static HashMap<String, Image> blocks = new HashMap<String, Image>();
	private static ImageIcon close1;
	private static ImageIcon close2;
	private static ImageIcon closePlayPanel1;
	private static ImageIcon closePlayPanel2;
	private static ImageIcon come1;
	private static ImageIcon come2;
	private static ImageIcon dlv1;
	private static ImageIcon dlv2;
	private static ImageIcon ok2;
	private static ImageIcon ok1;
	private static Image gamePanel;
	private static ImageIcon help1;
	private static ImageIcon help2;
	private static ImageIcon no1;
	private static ImageIcon no2;
	private static ImageIcon play1;
	private static ImageIcon play2;
	private static Image startPanel;
	private static ImageIcon yes1;
	private static ImageIcon yes2;
	static
	{
		try
		{
			startPanel = ImageIO.read(ImageProvider.class.getClassLoader()
					.getResource("it/slidingblock/assets/startPanel.png"));
			gamePanel = ImageIO.read(ImageProvider.class.getClassLoader()
					.getResource("it/slidingblock/assets/gamePanel.png"));
			play1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/play1.png")));
			play2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/play2.png")));
			close1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/close1.png")));
			close2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/close2.png")));
			come1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/come1.png")));
			come2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/come2.png")));
			help1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/help1.png")));
			help2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/help2.png")));
			dlv1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/dlv1.png")));
			dlv2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/dlv2.png")));
			ok1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/ok1.png")));
			ok2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/ok2.png")));
			yes1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/yes1.png")));
			yes2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/yes2.png")));
			no1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/no1.png")));
			no2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/no2.png")));
			closePlayPanel1 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/closePlayPanel1.png")));
			closePlayPanel2 = new ImageIcon(ImageIO.read(ImageProvider.class
					.getClassLoader().getResource(
							"it/slidingblock/assets/closePlayPanel2.png")));
			for (int a = 1; a < 3; a++)
			{
				for (int b = 1; b < 3; b++)
				{
					loadBlocks("redBlock" + a + "x" + b);
					loadBlocks("yellowBlock" + a + "x" + b);
				}
			}
		} catch (final IOException e)
		{
			System.out.println("Cannot read Image");
		}
	}
	public static ImageIcon getOk2()
	{
		return ok2;
	}
	public static ImageIcon getOk1()
	{
		return ok1;
	}
	public static HashMap<String, Image> getBlocks()
	{
		return blocks;
	}
	public static ImageIcon getClose1()
	{
		return close1;
	}
	public static ImageIcon getClose2()
	{
		return close2;
	}
	public static ImageIcon getClosePlayPanel1()
	{
		return closePlayPanel1;
	}
	public static ImageIcon getClosePlayPanel2()
	{
		return closePlayPanel2;
	}
	public static ImageIcon getCome1()
	{
		return come1;
	}
	public static ImageIcon getCome2()
	{
		return come2;
	}
	public static ImageIcon getDlv1()
	{
		return dlv1;
	}
	public static ImageIcon getDlv2()
	{
		return dlv2;
	}
	public static Image getGamePanel()
	{
		return gamePanel;
	}
	public static ImageIcon getHelp1()
	{
		return help1;
	}
	public static ImageIcon getHelp2()
	{
		return help2;
	}
	public static ImageIcon getNo1()
	{
		return no1;
	}
	public static ImageIcon getNo2()
	{
		return no2;
	}
	public static ImageIcon getPlay1()
	{
		return play1;
	}
	public static ImageIcon getPlay2()
	{
		return play2;
	}
	public static Image getStartPanel()
	{
		return startPanel;
	}
	public static ImageIcon getYes1()
	{
		return yes1;
	}
	public static ImageIcon getYes2()
	{
		return yes2;
	}
	private static void loadBlocks(String block) throws IOException
	{
		blocks.put(
				block,
				ImageIO.read(ImageProvider.class.getClassLoader().getResource(
						"it/slidingblock/assets/" + block + ".png")));
	}
}