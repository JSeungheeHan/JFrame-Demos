package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Floor extends Rectangle{
	Color col = Color.ORANGE;
	double xspeed;
	double yspeed;
	int type = 1;
	public Floor(int x, int y) {
		super(x, y, 20, 20);
	}
	Color currentColor = Color.ORANGE;
	boolean touch = false;
	//	static fields
	static int WIDTH = 12;
	static int HEIGHT = 12;
	int count = 0;
	
	public void update() {
	}
	
	public void draw(Graphics2D win)
	{
		win.setColor(Color.ORANGE);
		win.fill(this);
	}
}