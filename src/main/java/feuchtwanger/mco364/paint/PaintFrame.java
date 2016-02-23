package feuchtwanger.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil, oval, box, line, bucket;
	private Canvas canvas;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();
		canvas.setTool(new PencilTool());

		add(canvas, BorderLayout.CENTER);

		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.X_AXIS));

		JButton pencil = new JButton("Pencil");
		pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new PencilTool());
			}

		});
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new OvalTool());
			}

		});
		JButton line = new JButton("Line");
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new LineTool());
			}

		});
		JButton box = new JButton("Box");
		box.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new BoxTool());
			}

		});
		JButton bucket = new JButton("Bucket");
		bucket.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new BucketTool());
			}
			
		});
		toolPanel.add(pencil);
		toolPanel.add(line);
		toolPanel.add(box);
		toolPanel.add(oval);
		toolPanel.add(bucket);

		add(toolPanel, BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
