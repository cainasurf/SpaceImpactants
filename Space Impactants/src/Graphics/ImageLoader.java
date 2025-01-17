package Graphics;
	

	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.imageio.ImageIO;

	/**
	 *
	 * @author Guaiamum
	 */
	public class ImageLoader {
	    
	    public static BufferedImage loadImage(String path){  
	        try {
	            return ImageIO.read(ImageLoader.class.getResource(path)); //returns the buffered image object of loaded image
	        } catch (IOException ex) {
	            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
	            System.exit(1);
	        }
	       return null;
	    }
	}
