package it.slidingblock.gui;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class ImageProvider
{
	private static HashMap<String,Image> blocks=new HashMap<>();
	private static Image startPanel;
	private static ImageIcon play1;
	private static ImageIcon play2;
	private static ImageIcon yes1;
	private static ImageIcon yes2;
	private static ImageIcon no1;
	private static ImageIcon no2;
	private static ImageIcon close2;
	private static ImageIcon close1;
	static
	{
		try
		{
			startPanel=ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/startPanel.png"));
			play1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/play1.png")));
			play2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/play2.png")));
			close1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/close1.png")));
			close2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/close2.png")));
			yes1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yes1.png")));
			yes2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/yes2.png")));
			no1=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/no1.png")));
			no2=new ImageIcon(ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/no2.png")));
			for (int a=1;a<3;a++)
			{
				for (int b=1;b<3;b++)
				{
					loadBlocks("redBlock"+a+"x"+b);
					loadBlocks("yellowBlock"+a+"x"+b);
				}
			}
		}
		catch (final IOException e)
		{
			System.out.println("Cannot read Image");
		}
	}
	private static void loadBlocks(String block) throws IOException
	{
		blocks.put(block,ImageIO.read(ImageProvider.class.getClassLoader().getResource("it/slidingblock/assets/"+block+".png")));
	}
	public static HashMap<String,Image> getBlocks()
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
}