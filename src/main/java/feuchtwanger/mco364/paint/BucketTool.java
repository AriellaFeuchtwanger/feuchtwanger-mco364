package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool{

	
	public void mousePressed(Graphics g, int x, int y) {
		
	}

	public void mouseReleased(Graphics g, int x, int y) {
		
	}

	public void mouseDragged(Graphics g, int x, int y) {
		
	}

	public void drawPreview(Graphics g) {
		
	}

	public void mouseClicked(Graphics g, int x, int y) {
		g.setColor(Color.PINK);
		Queue<Point> points = new LinkedList<Point>();
		
		points.add(new Point(x, y));
		Point p;
		
		while(!points.isEmpty()){
			p = points.peek();
			
			
		}
	}

	private void fill(){
		
	}
}
