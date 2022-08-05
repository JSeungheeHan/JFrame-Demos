package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Sword extends Rectangle{
	Color col = Color.RED;
	double xspeed;
	double yspeed;
	int orientation = 0;
	public Sword(int x, int y) {
		super(x, y, 20, 20);
	}
	Color currentColor = Color.RED;
	boolean touch = false;
	//	static fields
	static int WIDTH = 20;
	static int HEIGHT = 20;
	int count = 0;
	
	public void update() {
		if(orientation == 0)
		{
			this.height = 20;
			this.width = 8;
		}
		if(orientation == 1)
		{
			this.width = 20;
			this.height = 8;
		}
	}
	
	public void draw(Graphics2D win)
	{
		win.setColor(this.currentColor);
		win.fill(this);
		win.setColor(Color.WHITE);
		win.draw(this);
	}
}


