package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {
	@Test
	public void testMouseReleased(){
		PaintProperties properties = new PaintProperties();
		LineTool tool = new LineTool(properties);
		
		Graphics g = Mockito.mock(Graphics.class);
		
		tool.mousePressed(g, 5, 5, Color.PINK);
		tool.mouseReleased(g, 10, 10, Color.PINK);
		
		Mockito.verify(g).drawLine(5,  5, 10, 10);
	}
	
	@Test
	public void testDrawPreview(){
		PaintProperties properties = new PaintProperties();
		LineTool tool = new LineTool(properties);
		
		Graphics g = Mockito.mock(Graphics.class);
		
		tool.mousePressed(g, 5, 5, Color.PINK);
		tool.mouseDragged(g, 10, 10, Color.PINK);
		tool.drawPreview(g, Color.PINK);
		Mockito.verify(g).drawLine(5,  5, 10, 10);
	}
	
	@Test
	public void testPencilTool(){
		PaintProperties properties = new PaintProperties();
		PencilTool tool = new PencilTool(properties);
		
		Graphics g = Mockito.mock(Graphics.class);
		
		tool.mousePressed(g, 7, 7, Color.PINK);
		Mockito.verify(g).drawOval(7, 7, 1, 1);
	}
}
