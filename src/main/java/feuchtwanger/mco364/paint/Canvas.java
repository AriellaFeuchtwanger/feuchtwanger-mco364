package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;
	private Stack<BufferedImage> undoStack;
	private Stack<BufferedImage> redoStack;
	private Color currColor;
	private static int HEIGHT = 600;
	private static int WIDTH = 800;
	private PaintProperties properties;

	@Inject
	public Canvas(PaintProperties paintProperties) {
		buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		setBackground(Color.WHITE);
		undoStack = new Stack<BufferedImage>();
		redoStack = new Stack<BufferedImage>();
		undoStack.push(deepCopy(buffer));

		this.properties = paintProperties;
		this.properties.setColor(Color.PINK);
		this.properties.setImage(buffer);
		setTool(new PencilTool(this.properties));
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				buffer = deepCopy((BufferedImage) undoStack.peek());
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY(), properties.getColor());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY(), properties.getColor());
				undoStack.push(deepCopy(buffer));
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				buffer = (BufferedImage) undoStack.peek();
				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY(), properties.getColor());
				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage((BufferedImage) undoStack.peek(), 0, 0, null);
		tool.drawPreview(g, properties.getColor());
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void undo() {
		if (undoStack.size() > 1) {
			redoStack.push(deepCopy(buffer));
			buffer = (BufferedImage) undoStack.pop();
			repaint();
		}
	}

	public void redo() {
		if (redoStack.size() > 0) {
			buffer = (BufferedImage) redoStack.pop();
			undoStack.push(deepCopy(buffer));
			repaint();
		}
	}

	public BufferedImage getBufferedImage() {
		return buffer;
	}

	public void setBufferedImage(BufferedImage image) {
		buffer = deepCopy(image);
		undoStack.push(buffer);
		repaint();
	}

	private BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public Color getCurrColor() {
		return currColor;
	}

	public void setCurrColor(Color currColor) {
		//this.currColor = currColor;
		properties.setColor(currColor);
	}

}
