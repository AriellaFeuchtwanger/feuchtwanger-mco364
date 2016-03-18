package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Tool {

	protected PaintProperties properties;
	
	public Tool(PaintProperties properties){
		this.properties = properties;
	}
	
	abstract void mousePressed(Graphics g, int x, int y, Color color);
	abstract void mouseReleased(Graphics g, int x, int y, Color color);
	abstract void mouseDragged(Graphics g, int x, int y, Color color);
	abstract void drawPreview(Graphics g, Color color);
}
