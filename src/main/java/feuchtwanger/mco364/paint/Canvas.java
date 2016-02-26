package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;
	private Stack<BufferedImage> undoStack;
	private Stack<BufferedImage> redoStack;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		setBackground(Color.WHITE);
		undoStack = new Stack<BufferedImage>();
		redoStack = new Stack<BufferedImage>();
		undoStack.push(buffer);
		redoStack.push(buffer);
		
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {
				tool.mouseClicked(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				undoStack.push(buffer);
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY());
				tool.drawPreview(getGraphics());
				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}
	
	public void setTool(Tool tool){
		this.tool = tool;
	}
	
	public void undo(){
		redoStack.push(buffer);
		buffer = undoStack.pop();
		repaint();
	}
	
	public void redo(){
		buffer = redoStack.pop();
		repaint();
	}
}
