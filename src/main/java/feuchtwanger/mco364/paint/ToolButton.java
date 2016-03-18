package feuchtwanger.mco364.paint;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton{

	private Tool tool;
	
	public ToolButton(Tool tool, String iconName){
		this.tool = tool;
		this.setIcon(new ImageIcon(getClass().getResource(iconName)));
		this.setPreferredSize(new Dimension(50, 50));
	}
	
	public Tool getTool(){
		return tool;
	}
}
