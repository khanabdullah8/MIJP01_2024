package visual.cryptography.technique.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;

public class GenerateImage {
	public static BufferedImage getRandomizedImage(int width, int height){
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[width];
        for(int y = 0; y < height; y++){
            for(int i = 0; i < width; i++){
                if(new Random().nextBoolean()){
                    pixels[i] = 255;
                }
                else{
                    pixels[i] = 0;
                }
            }
            raster.setPixels(0, y, width, 1, pixels);
        }
        return result;
    }
	
	public static BufferedImage getExcludedImage(BufferedImage first, BufferedImage second,BufferedImage third,BufferedImage simage, boolean isEven){
        int width = simage.getWidth();
        System.out.println("width--1--->"+width);
        int height = simage.getHeight();
        System.out.println("height--1--->"+height);
        BufferedImage result = new BufferedImage(first.getWidth(), first.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        //BufferedImage result = new BufferedImage(simage.getWidth(), simage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        WritableRaster raster = result.getRaster();
        WritableRaster firstRaster = first.getRaster();
        WritableRaster secondRaster = second.getRaster();
        WritableRaster thirdRaster = third.getRaster();
        WritableRaster simageRaster = simage.getRaster();
        int[] pixels1 = new int[width];        
        int[] pixels2 = new int[width];
        int[] pixels = new int[width];
        
        System.out.println("pixle1--->"+pixels1.length);
        System.out.println("pixle2--->"+pixels2.length);
        System.out.println("pixle--->"+pixels.length);

        if(isEven){

            for(int y = 0; y < height; y++){
                firstRaster.getPixels(0, y, width, 1, pixels1);
                secondRaster.getPixels(0, y, width, 1, pixels2);
                thirdRaster.getPixels(0, y, width, 1, pixels2);
                simageRaster.getPixels(0, y, width, 1, pixels2);
                for(int i = 0; i < width; i++){
                    if(pixels1[i] == pixels2[i]){
                        pixels[i] = 255;
                    }
                    else {
                        pixels[i] = 0;
                    }
                }
                raster.setPixels(0, y, width, 1, pixels);
            }
        }
        else{
            for(int y = 0; y < height; y++){
                firstRaster.getPixels(0, y, width, 1, pixels1);
                secondRaster.getPixels(0, y, width, 1, pixels2);
                thirdRaster.getPixels(0, y, width, 1, pixels2);
                simageRaster.getPixels(0, y, width, 1, pixels2);
                for(int i = 0; i < width; i++){
                    if(pixels1[i] == pixels2[i]){
                        pixels[i] = 0;
                    }
                    else {
                        pixels[i] = 255;
                    }
                }
                raster.setPixels(0, y, width, 1, pixels);
            }
        }
        return result;
    }
	
	public static BufferedImage thresholdImage(BufferedImage image, int threshold) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        result.getGraphics().drawImage(image, 0, 0, null);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            raster.getPixels(0, y, image.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) pixels[i] = 0;
                else pixels[i] = 255;
            }
            raster.setPixels(0, y, image.getWidth(), 1, pixels);
        }
        return result;
    }
	
	public static BufferedImage secretImage(BufferedImage sharedimage1,BufferedImage sharedimage2,BufferedImage sharedimage3,BufferedImage secimage) {
		
		int w = Math.max(secimage.getWidth(), sharedimage1.getWidth())+Math.max(sharedimage2.getWidth(), sharedimage3.getWidth());
		int h = Math.max(secimage.getHeight(), sharedimage1.getHeight())+Math.max(sharedimage2.getHeight(), sharedimage3.getHeight());
		
		BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = newImage.createGraphics();
	    Color oldColor = g2.getColor();
	    g2.setPaint(Color.BLACK);
	    g2.fillRect(0, 0, w, h);
	    g2.setColor(oldColor);
	    g2.drawImage(sharedimage1, null, 0, 0);
	    g2.drawImage(sharedimage2, null, sharedimage1.getWidth() + sharedimage3.getWidth(), 0);
	    g2.dispose();
	    return newImage;
	}
}