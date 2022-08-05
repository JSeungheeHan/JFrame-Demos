package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Enemy extends Rectangle{
	Color col = Color.WHITE;
	int lives = 3;
	public Enemy(int x, int y) {
		super(x, y, 12, 12);
	}
	Color currentColor = Color.WHITE;
	boolean touch = false;
	//	static fields
	static int WIDTH = 12;
	static int HEIGHT = 12;
	int count = 0;
	int xspeed = 0;
	int yspeed = 0;
	int hitstun = 0;
	public void update() {
		if(this.count == 75)
		{
			if(this.lives == 3)
			{
				this.currentColor = Color.RED;
			}
			if(this.lives == 2)
			{
				this.currentColor = Color.ORANGE;
			}
			if(this.lives == 1)
			{
				this.currentColor = Color.YELLOW;
			}
		}
		if(this.count == 150)
		{
			this.currentColor = Color.WHITE;
			this.count = 0;
		}
		if(this.lives == 0)
		{
			this.height = 0;
			this.width = 0;
		}
		this.count++;
		this.translate(xspeed, yspeed);
	}
	
	public void draw(Graphics2D win)
	{
		win.setColor(this.currentColor);
		win.fill(this);
		win.setColor(Color.YELLOW);
		win.draw(this);
	}
}

