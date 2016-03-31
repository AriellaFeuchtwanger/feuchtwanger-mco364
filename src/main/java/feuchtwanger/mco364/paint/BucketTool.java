package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {

	private BufferedImage buffer;
	private Canvas canvas;

	public BucketTool(Canvas canvas, PaintProperties properties) {
		super(properties);
		this.canvas = canvas;
		buffer = this.canvas.getBufferedImage();
	}

	public void mousePressed(Graphics2D g, int x, int y, Color color) {
		g.setColor(Color.PINK);
		// fill(new Point(x, y), buffer.getRGB(x, y), Color.PINK.getRGB());
		fill(new Point(x, y), buffer.getRGB(x, y), color.getRGB());
	}

	public void mouseReleased(Graphics2D g, int x, int y, Color color) {

	}

	public void mouseDragged(Graphics2D g, int x, int y, Color color) {

	}

	private void fill(Point p, int src, int target) {
		if (src == target) {
			return;
		}
		Queue<Point> points = new LinkedList<Point>();
		points.add(p);

		while (!points.isEmpty()) {
			p = points.remove();
			int currX = p.getX();
			int currY = p.getY();

			if (currX < 0 || currY < 0 || currX > buffer.getWidth()
					|| currY > buffer.getHeight()) {
				continue;
			}
			int left = currX;
			int right = currX;
			int leftColor = buffer.getRGB(left, currY);
			int rightColor = buffer.getRGB(right, currY);

			do {
				left--;
				if (left > 0)
					leftColor = buffer.getRGB(left, currY);
				else
					break;
			} while (leftColor == src);

			do {
				right++;
				if (right < buffer.getWidth())
					rightColor = buffer.getRGB(right, currY);
				else
					break;
			} while (rightColor == src);

			for (int i = left; i < right; i++) {
				buffer.setRGB(i, currY, target);
			}

			if (currY + 1 < buffer.getHeight()) {
				if (buffer.getRGB(currX, currY + 1) == src) {
					points.add(new Point(currX, currY + 1));
				}
			}

			if (currY - 1 > 0) {
				if (buffer.getRGB(currX, currY - 1) == src) {
					points.add(new Point(currX, currY - 1));
				}
			}
			buffer.setRGB(p.getX(), p.getY(), target);
		}
		canvas.setBufferedImage(buffer);
	}

	public void drawPreview(Graphics2D g, Color color) {
		// TODO Auto-generated method stub

	}
}
