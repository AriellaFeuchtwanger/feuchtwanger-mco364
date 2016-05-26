package feuchtwanger.mco364.paint;

import com.google.inject.Inject;

public class CanvasRepaintManager {
	private Canvas canvas;
	
	@Inject
	public CanvasRepaintManager(Canvas canvas){
		this.canvas = canvas;
	}
	
	public void repaint(int x1, int y1, int x2, int y2){
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		
		canvas.repaint(x, y, width, height);
	}
}
