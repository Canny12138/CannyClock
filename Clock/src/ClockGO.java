import javax.swing.*;

public class ClockGO
{
	final static int WIDTH = 300;
	final static int HEIGHT = 350;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("π“÷”");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ClockPanel());
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
