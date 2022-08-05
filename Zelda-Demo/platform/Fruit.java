package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Fruit extends Rectangle{
	Color col = Color.WHITE;
	public Fruit(int x, int y) {
		super(x, y, 12, 12);
	}
	Color currentColor = Color.WHITE;
	boolean touch = false;
	//	static fields
	static int WIDTH = 12;
	static int HEIGHT = 12;
	int count = 0;
	
	public void update() {
		if(this.count == 75)
		{
			this.currentColor = Color.RED;
		}
		if(this.count == 150)
		{
			this.currentColor = Color.WHITE;
			this.count = 0;
		}
		this.count++;
	}
	
	public void draw(Graphics2D win)
	{
		win.setColor(this.currentColor);
		win.fill(this);
		win.setColor(Color.WHITE);
		win.draw(this);
	}
}


