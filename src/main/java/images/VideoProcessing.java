package images;

import java.awt.Image;
import java.io.File;
import java.util.LinkedList;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.FrameGrabber.Exception;

public class VideoProcessing {

	public LinkedList<Image> getFrame(File vf) throws Exception {
		LinkedList<Image> frames = new LinkedList<Image>();
		FFmpegFrameGrabber f = new FFmpegFrameGrabber(vf);
		f.start();
		for (int i = 0; i < 3; i++) {
			Java2DFrameConverter conv = new Java2DFrameConverter();
			Image img = conv.getBufferedImage(f.grabImage());
			frames.add(img);
		}
		f.stop();
		f.close();
		return frames;
	}

}
