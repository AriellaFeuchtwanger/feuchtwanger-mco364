package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool extends Tool {

	public PencilTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	private int lastX;
	private int lastY;

	public void mousePressed(Graphics g, int x, int y, Color color) {
		lastX = x;
		lastY = y;
		g.setColor(color);
		g.fillOval(x, y, 1, 1);
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		g.setColor(color);
		g.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub
		
	}
}
