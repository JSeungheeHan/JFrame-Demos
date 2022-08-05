package platform;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite implements GameObject{
	
	BufferedImage[] sprites;
	int position = 0;
	int positionx = 0;
	int positiony = 0;
	Timer time;
	
	public Sprite(BufferedImage cheet, int rows, int cols, double delay) {
		
		time = new Timer(delay);
		time.start();
		sprites = new BufferedImage[rows * cols];
		
		int width = cheet.getWidth() / cols;
		int height = cheet.getHeight() / rows;
		
		int count = 0;
		
		for(int i =0; i<rows; i++) {
			
			for(int j =0; j<cols; j++) {
				
				BufferedImage subImage = cheet.getSubimage(j*width, i*height, width, height);
				this.sprites[count] = subImage;
				count++;
				
			}
			
			
			
		}
		

		
	}
	

	
	public void update() {
		
		if(time.update()) {
			this.position++;
			this.position%=this.sprites.length;
		}
		
	}

	
	public void draw(Graphics2D paint) {
		
		paint.drawImage(this.sprites[this.position], null, positionx, positiony);
		
	}

}
