import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class ClockPanel extends JPanel
{
	private JLabel time;
	private Clock clock;
	DecimalFormat df = new DecimalFormat("#00");

	public ClockPanel()
	{
		setLayout(null);
		Timer timer = new Timer(1000, new TimechangeListener());

		time = new JLabel("00:00:00");
		time.setFont(new Font(null, Font.PLAIN, 20));
		time.setBounds(105, 200, 100, 50);

		add(time);
		clock = new Clock();
		timer.start();
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		clock.draw(page);
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
			clock.seconds = seconds;
			clock.minutes = minutes;
			clock.hours = hours;
			clock.changeTime();
			repaint();
		}
	}
}
