package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {
	private int lastX;
	private int lastY;
	int x;
	int y;

	public void mousePressed(Graphics g, int x, int y, Color color) {
		lastX = x;
		lastY = y;
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
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

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g, Color color) {
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
