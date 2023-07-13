import java.awt.*;

public class Clock
{
	private static final int SECONDS_L = 40;
	private static final int MINUTES_L = 30;
	private static final int HOURS_L = 20;
	private static final int CLOCK_O_X = 142;
	private static final int CLOCK_O_Y = 117;// Ô²ÐÄÎª140,115
	public int seconds, minutes, hours;
	public double s_x, s_y;
	public double m_x, m_y;
	public double h_x, h_y;

	public Clock()
	{
		seconds = minutes = hours = 0;
		s_x = CLOCK_O_X + Math.sin(2 * Math.PI * seconds / 60) * SECONDS_L;
		m_x = CLOCK_O_X + Math.sin(2 * Math.PI * minutes / 60) * MINUTES_L;
		h_x = CLOCK_O_X + Math
				.sin(2 * Math.PI
						* ((double) hours / 12 + (double) minutes / 60 / 12))
				* HOURS_L;

		s_y = CLOCK_O_Y - Math.cos(2 * Math.PI * seconds / 60) * SECONDS_L;
		m_y = CLOCK_O_Y - Math.cos(2 * Math.PI * minutes / 60) * MINUTES_L;
		h_y = CLOCK_O_Y - Math
				.cos(2 * Math.PI
						* ((double) hours / 12 + (double) minutes / 60 / 12))
				* HOURS_L;
	}

	public void changeTime()
	{
		s_x = CLOCK_O_X + Math.sin(2 * Math.PI * seconds / 60) * SECONDS_L;
		m_x = CLOCK_O_X + Math.sin(2 * Math.PI * minutes / 60) * MINUTES_L;
		h_x = CLOCK_O_X + Math
				.sin(2 * Math.PI
						* ((double) hours / 12 + (double) minutes / 60 / 12))
				* HOURS_L;

		s_y = CLOCK_O_Y - Math.cos(2 * Math.PI * seconds / 60) * SECONDS_L;
		m_y = CLOCK_O_Y - Math.cos(2 * Math.PI * minutes / 60) * MINUTES_L;
		h_y = CLOCK_O_Y - Math
				.cos(2 * Math.PI
						* ((double) hours / 12 + (double) minutes / 60 / 12))
				* HOURS_L;
	}

	public void draw(Graphics page)
	{
		Graphics2D g2 = (Graphics2D) page;
		page.setColor(Color.BLACK);
		page.setFont(new Font(null, Font.BOLD, 20));
		page.drawOval(65, 40, 150, 150);
		page.drawString("12", 130, 60);
		page.drawString("6", 137, 185);
		page.drawString("9", 70, 125);
		page.drawString("3", 200, 125);
		page.fillOval(140, 115, 5, 5);
		g2.setStroke(new BasicStroke(1.0f));
		page.drawLine(CLOCK_O_X, CLOCK_O_Y, (int) s_x, (int) s_y);
		g2.setStroke(new BasicStroke(2.0f));
		page.drawLine(CLOCK_O_X, CLOCK_O_Y, (int) m_x, (int) m_y);
		g2.setStroke(new BasicStroke(3.0f));
		page.drawLine(CLOCK_O_X, CLOCK_O_Y, (int) h_x, (int) h_y);

	}
}
