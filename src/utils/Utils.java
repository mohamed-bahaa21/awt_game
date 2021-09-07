package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	
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
