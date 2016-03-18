package it.slidingblock.gui;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
public class ModifiedButton extends JButton
{
	private static final long serialVersionUID=1;
	private MouseAdapter passOn;
	int differenceHeight;
	int differenceWidth;
	public ModifiedButton(Icon icon1,Icon icon2,ActionListener a)
	{
		super(icon1);
		differenceWidth=(icon2.getIconWidth()-icon1.getIconWidth())/2;
		differenceHeight=(icon2.getIconHeight()-icon1.getIconHeight())/2;
		this.passOn=new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				setBounds(getX()-differenceWidth,getY()-differenceHeight,icon2.getIconWidth(),icon2.getIconHeight());
				setIcon(icon2);
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				setBounds(getX()+differenceWidth,getY()+differenceHeight,icon1.getIconWidth(),icon1.getIconHeight());
				setIcon(icon1);
			}
		};
		this.addActionListener(a);
		this.setSize(new Dimension(icon1.getIconWidth(),icon1.getIconHeight()));
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setIcon(icon1);
		this.setFocusPainted(false);
		this.addMouseListener(this.passOn);
	}
}
