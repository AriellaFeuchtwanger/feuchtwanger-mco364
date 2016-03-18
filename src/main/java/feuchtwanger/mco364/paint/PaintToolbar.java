package feuchtwanger.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@Singleton
public class PaintToolbar extends Container{

	private Canvas canvas;
	private PaintProperties properties;
	private JColorChooser colors;
	
	@Inject
	public PaintToolbar(Canvas canvasA, PaintProperties propertiesA){
		this.canvas = canvasA;
		this.properties = propertiesA;
		setLayout(new FlowLayout());
		ToolButton[] tools = new ToolButton[] {
				new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new OvalTool(properties), "/circle.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new BoxTool(properties), "/square.png"),
				new ToolButton(new BucketTool(canvas, properties),
						"/bucket.png") };

		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				Tool tool = button.getTool();
				canvas.setTool(tool);
			}

		};

		for(ToolButton button : tools){
			add(button);
			button.addActionListener(listener);
		}
		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
				canvas.repaint();
				// repaint();
			}

		});

		JButton redo = new JButton("Redo");
		redo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
				canvas.repaint();
				// repaint();
			}

		});

		add(undo);
		add(redo);

		//add(colors);
	}
}
