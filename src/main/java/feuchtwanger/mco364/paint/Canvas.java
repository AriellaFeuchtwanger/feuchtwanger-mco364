package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private int lastX;
	private int lastY;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {
				
			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				lastX = event.getX();
				lastY = event.getY();
				Graphics g = buffer.getGraphics();
				g.setColor(Color.PINK);
				g.drawLine(lastX, lastY, event.getX(), event.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				Graphics g = buffer.getGraphics();
				g.drawLine(lastX, lastY, event.getX(), event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				
				Graphics g = buffer.getGraphics();
				g.setColor(Color.PINK);
				g.drawLine(lastX, lastY, event.getX(), event.getY());
				lastX = event.getX();
				lastY = event.getY();
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

	}
}
