package it.slidingblock.gui;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class RequestPanel extends JPanel
{
	private static final long serialVersionUID=1;
	private ModifiedButton noButton;
	private ModifiedButton yesButton;
	private JDialog dialog;
	private JLabel write;
	private MainFrame frame;
	public RequestPanel(MainFrame frame,int i)
	{
		this.frame=frame;
		this.dialog=new JDialog(this.frame);
		this.dialog.setSize(366,168);
		this.setBorder(new LineBorder(Color.BLUE.darker().darker(),5));
		this.write=new JLabel();
		this.requestFocus();
		this.setSize(this.dialog.getWidth(),this.dialog.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLUE);
		this.setVisible(true);
		if (i==1)
		{
			this.write.setText("Are you sure to exit?");
			this.write.setFont(new Font("Showcard Gothic",0,(int) (this.dialog.getHeight()*0.17)));
			this.write.setBounds(5,15,this.getWidth(),25);
		}
		this.write.setForeground(Color.WHITE);
		this.write.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.noButton=new ModifiedButton(ImageProvider.getNo1(),ImageProvider.getNo2(),e -> dialog.dispose());
		this.noButton.setBounds(((int) (this.getWidth()*0.7)-noButton.getWidth()),(int) (this.getHeight()*0.8),noButton.getWidth(),noButton.getHeight());
		this.yesButton=new ModifiedButton(ImageProvider.getYes1(),ImageProvider.getYes2(),e -> System.exit(0));
		this.yesButton.setBounds((int) (this.getWidth()*0.3),(int) (this.getHeight()*0.8),yesButton.getWidth(),yesButton.getHeight());
		this.add(this.write);
		this.add(this.noButton);
		this.add(this.yesButton);
		this.dialog.setUndecorated(true);
		this.dialog.setContentPane(this);
		this.dialog.setLocationRelativeTo(this.frame);
		this.dialog.setCursor(this.frame.getCursor());
		this.dialog.setVisible(true);
	}
}
