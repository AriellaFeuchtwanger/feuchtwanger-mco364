package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public class OvalTool extends Tool {
	public OvalTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	private int lastX;
	private int lastY;
	int x;
	int y;

	public void mousePressed(Graphics2D g, int x, int y, Color color) {
		lastX = x;
		lastY = y;
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y, Color color) {
		int width;
		int height;
		int originX;
		int originY;
		
		if (x > lastX) {
			width = x - lastX;
			originX = lastX;
		} else {
			width = lastX - x;
			originX = x;
		}

		if (y > lastY) {
			height = y - lastY;
			originY = lastY;
		} else {
			height = lastY - y;
			originY = y;
		}

		g.setColor(color);
		g.drawOval(originX, originY, width, height);
	}

	public void mouseDragged(Graphics2D g, int x, int y, Color color) {
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics2D g, Color color) {
		int width;
		int height;
		int originX;
		int originY;
		
		if (x > lastX) {
			width = x - lastX;
			originX = lastX;
		} else {
			width = lastX - x;
			originX = x;
		}

		if (y > lastY) {
			height = y - lastY;
			originY = lastY;
		} else {
			height = lastY - y;
			originY = y;
		}

		g.setColor(color);
		g.drawOval(originX, originY, width, height);
	}
}
