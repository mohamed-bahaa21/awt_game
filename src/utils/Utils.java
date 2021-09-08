package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	
//	Load Font
	public static Font loadFont(String path, float size){
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
//	Draw String
	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font){
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(center){
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}
	
//	Load Image 
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Utils.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
//	Load Files As String
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while((line = br.readLine()) != null) {
//				System.out.println("SB: " + builder);
//				System.out.println("FR: " + fr);
//				System.out.println("BR: " + br);
//				System.out.println("Line: " + line);
				
				builder.append(line + "\n");
			}
			
			br.close();
		} catch (IOException e) {e.printStackTrace(); }
		
		return builder.toString();
	}
	
//	Parse Integer 
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}
