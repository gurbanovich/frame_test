package viewing;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.bytedeco.javacv.FrameGrabber.Exception;

import images.Drawing;
import images.VideoProcessing;

public class ResultDisplay extends JFrame {

	private static final long serialVersionUID = 1L;

	public ResultDisplay(final File file) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VideoProcessing videoProcessing = new VideoProcessing();
				LinkedList<Image> list = null;
				try {
					list = videoProcessing.getFrame(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				initUI(list, 1f);
			}
		});
	}

	public void initUI(LinkedList<Image> list, float alpha) {

		JPanel jp = new JPanel();
		add(jp);
		jp.setLayout(new FlowLayout());

		Iterator<Image> imgIter = list.iterator();
		while (imgIter.hasNext()) {
			JLabel label = new JLabel();
			label = new Drawing(imgIter.next(), alpha);
			alpha -= 0.2f;
			jp.add(label);

		}

		pack();
		setTitle("Fade out");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
