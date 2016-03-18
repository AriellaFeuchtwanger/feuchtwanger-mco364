package feuchtwanger.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JColorChooser colors;
	private Canvas canvas;
	
	@Inject
	public PaintFrame(PaintToolbar toolbar, Canvas canvas1) {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.canvas = canvas1;
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		colors = new JColorChooser(Color.MAGENTA);
		colors.setPreviewPanel(new JPanel());
		colors.getSelectionModel().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {
				Color newColor = colors.getColor();
				canvas.setCurrColor(newColor);
				setForeground(newColor);
			}

		});

		container.add(colors, BorderLayout.SOUTH);
		container.add(toolbar, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);
		
		setVisible(true);
		//container.revalidate();
	}

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
	}
}
