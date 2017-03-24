package dummies;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rob {

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		
		Robot r=new Robot();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRect=new Rectangle(d);
		BufferedImage a = r.createScreenCapture(screenRect);
		ImageIO.write(a, "png", new File("d:/desktop.png"));
	}

}
