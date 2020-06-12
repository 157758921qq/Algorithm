package com.teng.snake.v2;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
	public static BufferedImage food;
	public static BufferedImage headLeft, headUp, headRight, headDown;
	public static BufferedImage body;

	static {
		try {
			food = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("snakeimgs/food.png"));
			headLeft = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("snakeimgs/left.png"));
            headUp = ImageUtil.rotateImage(headLeft, 90);
            headRight = ImageUtil.rotateImage(headLeft, 180);
            headDown = ImageUtil.rotateImage(headLeft, -90);
			body = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("snakeimgs/body.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
