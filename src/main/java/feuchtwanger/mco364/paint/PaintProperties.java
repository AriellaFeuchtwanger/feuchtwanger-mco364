package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {
	private Color color;
	private int weight;
	private boolean fill;
	private int width;
	private int height;
	private BufferedImage buffer;
	
	
	public PaintProperties(){
		this.width = 800;
		this.height = 600;
		this.color = Color.BLACK;
		this.weight = 200;
		buffer = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public PaintProperties(int WIDTH, int HEIGHT,
			Color color) {
		this.width = WIDTH;
		this.height = HEIGHT;
		this.color = color;
		this.weight = 200;
		
	}

	public BufferedImage getBuffer(){
		return buffer;
	}
	
	public void setImage(BufferedImage image){
		buffer = image;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
