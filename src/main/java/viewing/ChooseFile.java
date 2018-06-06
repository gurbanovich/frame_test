package viewing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseFile extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChooseFile() {
		super("Nine test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(Box.createVerticalGlue());
		JButton button = new JButton("Choose the video");
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int ret = fc.showDialog(null, "Open file");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					new ResultDisplay(file);
				}
			}
		});

		jp.add(button);
		jp.add(Box.createVerticalGlue());
		getContentPane().add(jp);
		setPreferredSize(new Dimension(260, 100));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
