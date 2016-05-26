package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Tool {

	protected PaintProperties properties;
	
	public Tool(CanvasRepaintManager manager, PaintProperties properties){
		this.properties = properties;
	}
	
	abstract void mousePressed(Graphics2D g, int x, int y, Color color);
	abstract void mouseReleased(Graphics2D g, int x, int y, Color color);
	abstract void mouseDragged(Graphics2D g, int x, int y, Color color);
	abstract void drawPreview(Graphics2D g, Color color);
}
