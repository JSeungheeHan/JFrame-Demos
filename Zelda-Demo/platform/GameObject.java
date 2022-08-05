package platform;

import java.awt.Graphics2D;

public interface GameObject {
	
	public static int WIDTH = 800;
	public static int Height = 600;
	public static int FPS = 30;
	
	public void update();
	public void draw(Graphics2D paint);

}
