package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 11, height = 7;
	
	public static BufferedImage player,enemy,playbut;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_px.png")); 
				
		player = sheet.crop(0, 0, width, height);
		enemy = sheet.crop(width, 0, width, height);
		playbut = sheet.crop(2*width, 0, width, height);
	}
}
