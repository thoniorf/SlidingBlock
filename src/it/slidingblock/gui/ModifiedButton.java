package it.slidingblock.gui;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JButton;
public class ModifiedButton extends JButton
{
	private static final long serialVersionUID=1;
	private MouseListener passOn;
	int differenceWidth;
	int differenceHeight;
	public ModifiedButton(Icon icon1,Icon icon2,ActionListener a)
	{
		super(icon1);
		differenceWidth=icon2.getIconWidth()-icon1.getIconWidth();
		differenceHeight=icon2.getIconHeight()-icon1.getIconHeight();
		this.passOn=new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{}
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				setBounds(getX()-differenceWidth,getY()-differenceHeight,icon2.getIconWidth(),icon2.getIconHeight());
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				setBounds(getX()+differenceWidth,getY()+differenceHeight,icon1.getIconWidth(),icon1.getIconHeight());
			}
			@Override
			public void mousePressed(MouseEvent e)
			{}
			@Override
			public void mouseReleased(MouseEvent e)
			{}
		};
		this.addActionListener(a);
		this.setSize(new Dimension(icon1.getIconWidth(),icon1.getIconHeight()));
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setRolloverIcon(icon2);
		this.addMouseListener(this.passOn);
	}
}
