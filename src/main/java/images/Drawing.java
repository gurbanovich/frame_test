package images;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class Drawing extends JLabel {

	private static final long serialVersionUID = 1L;
	private Image img;
	private float alpha;

	public Drawing(Image img, float alpha) {
		this.img = img;
		this.alpha = alpha;
		setImageSize();
	}

	private void setImageSize() {

		int h = img.getHeight(this);
		int w = img.getWidth(this);
		setPreferredSize(new Dimension(w, h));
	}

	private void drawingImage(float alpha, Image img, Graphics g) throws IOException, InterruptedException {

		Graphics2D g2d = (Graphics2D) g.create();
		AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(acomp);
		g2d.drawImage(img, 0, 0, null);
		g2d.dispose();

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		try {
			drawingImage(alpha, img, g);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
