package it.slidingblock.gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class SelectLevel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	private MainFrame frame;
	ModifiedButton level1;
	ModifiedButton level2;
	ModifiedButton level3;
	public SelectLevel(final MainFrame frame)
	{
		this.frame=frame;
		this.dialog=new JDialog(this.frame);
		this.dialog.setSize(300,350);
		this.setBorder(new LineBorder(Color.BLUE.darker().darker(),5));
		this.requestFocus();
		this.setSize(this.dialog.getWidth(),this.dialog.getHeight());
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setBackground(Color.BLUE);
		this.level1=new ModifiedButton(ImageProvider.getLevel1(), ImageProvider.getLevel1over());
		this.level2=new ModifiedButton(ImageProvider.getLevel2(), ImageProvider.getLevel2over());
		this.level3=new ModifiedButton(ImageProvider.getLevel3(), ImageProvider.getLevel3over());
		this.level1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.switchPanelPlay("level1");
				dialog.dispose();
			}
		});
		this.level2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.switchPanelPlay("level2");
				dialog.dispose();
			}
		});
		this.level3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.switchPanelPlay("level3");
				dialog.dispose();
			}
		});
		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.setVisible(true);
		this.dialog.setUndecorated(true);
		this.dialog.setContentPane(this);
		this.dialog.setLocationRelativeTo(this.frame);
		this.dialog.setCursor(this.frame.getCursor());
		this.dialog.setVisible(true);
	}
}

