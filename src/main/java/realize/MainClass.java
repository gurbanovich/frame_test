package realize;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import viewing.ChooseFile;

public class MainClass {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
				new ChooseFile();

			}
		});

	}
}
