package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {
	private int lastX;
	private int lastY;
	int x;
	int y;

	public void mousePressed(Graphics g, int x, int y) {
		lastX = x;
		lastY = y;
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		int width;
		int height;
		
		if(x > lastX){
			width = x - lastX;
		} else{
			width = lastX - x;
		}
		
		if(y > lastY){
			height = y - lastY;
		} else{
			height = lastY - y;
		}
		
		g.setColor(Color.PINK);
		g.drawOval(lastX, lastY, width, height);
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
		int width;
		int height;
		
		if(x > lastX){
			width = x - lastX;
		} else{
			width = lastX - x;
		}
		
		if(y > lastY){
			height = y - lastY;
		} else{
			height = lastY - y;
		}
		
		g.setColor(Color.PINK);
		g.drawOval(lastX, lastY, width, height);
	}
}
