package feuchtwanger.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PencilTool extends Tool {

	public PencilTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
		this.manager = manager;
		// TODO Auto-generated constructor stub
	}

	private int lastX;
	private int lastY;
	private CanvasRepaintManager manager;

	public void mousePressed(Graphics2D g, int x, int y, Color color) {
		lastX = x;
		lastY = y;
		g.setColor(color);
		g.setStroke(properties.getStroke());
		manager.repaint(x, y, x+1, y+1);
	}

	public void mouseReleased(Graphics2D g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics2D g, int x, int y, Color color) {
		g.setColor(color);
		g.drawLine(lastX, lastY, x, y);
		g.setStroke(properties.getStroke());
		manager.repaint(x, y, lastX, lastY);
		lastX = x;
		lastY = y;
	}

	public void drawPreview(Graphics2D g, Color color) {
		// TODO Auto-generated method stub
		
	}
}
