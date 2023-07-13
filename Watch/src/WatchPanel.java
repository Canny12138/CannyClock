import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class WatchPanel extends JPanel
{
	private JPanel panel;
	private JButton currentTimeButton;
	private JLabel time, currentTime;
	DecimalFormat df = new DecimalFormat("#00");

	public WatchPanel()
	{
		Timer timer = new Timer(1000, new TimechangeListener());

		time = new JLabel("00:00:00", JLabel.CENTER);
		time.setFont(new Font(null, Font.PLAIN, 20));
		time.setPreferredSize(new Dimension(230, 40));

		currentTime = new JLabel("00:00:00", JLabel.CENTER);
		currentTime.setFont(new Font(null, Font.PLAIN, 20));
		currentTime.setPreferredSize(new Dimension(230, 40));

		currentTimeButton = new JButton("Current Time:");
		currentTimeButton.setFont(new Font(null, Font.PLAIN, 16));
		currentTimeButton.setPreferredSize(new Dimension(130, 30));
		currentTimeButton.addActionListener(new ButtonListener());

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 150));
		// panel.setBackground(Color.red);
		panel.add(time);
		panel.add(currentTimeButton);
		panel.add(currentTime);
		add(panel);
		timer.start();
	}

	private class TimechangeListener implements ActionListener
	{
		private int seconds;
		private int minutes;
		private int hours;

		public void actionPerformed(ActionEvent event)
		{
			Calendar cal = new GregorianCalendar();
			seconds = cal.get(Calendar.SECOND);
			minutes = cal.get(Calendar.MINUTE);
			hours = cal.get(Calendar.HOUR);
			time.setText(df.format(hours) + ":" + df.format(minutes) + ":"
					+ df.format(seconds));
		}
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			currentTime.setText(time.getText());
		}
	}
}
