package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool extends Tool {

	private static final Logger LOG = Logger
			.getLogger(LineTool.class.getName());

	public LineTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
		// TODO Auto-generated constructor stub
	}

	private int x1, y1;
	private int x2, y2;

	public void mousePressed(Graphics2D g, int x, int y, Color color) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y, Color color) {
		g.setColor(color);
		g.drawLine(x1, y1, x, y);
	}

	public void mouseDragged(Graphics2D g, int x, int y, Color color) {
		x2 = x;
		y2 = y;
	}

	public void drawPreview(Graphics2D g, Color color) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}

}
