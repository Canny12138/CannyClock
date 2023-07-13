import javax.swing.*;

public class Watch
{
	final static int WIDTH = 260;
	final static int HEIGHT = 200;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("√Î±Ì");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new WatchPanel());
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
}
