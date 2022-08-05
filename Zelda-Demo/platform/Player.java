package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Player extends Rectangle{
	Color col = Color.WHITE;
	double xspeed;
	double yspeed;
	int direction = 5;
	int facing = 5;
	public Player(int x, int y) {
		super(x, y, 20, 20);
	}
	Color currentColor = Color.WHITE;
	boolean touch = false;
	//	static fields
	static int WIDTH = 20;
	static int HEIGHT = 20;
	int count = 0;
	int lives = 3;
	public void update() {
		if(direction == 0)
		{
			xspeed = 2;
			yspeed = 0;
		}
		if(direction == 1)
		{
			xspeed = 0;
			yspeed = 2;
		}
		if(direction == 2)
		{
			yspeed = 0;
			xspeed = -2;
		}
		if(direction == 3)
		{
			xspeed = 0;
			yspeed = -2;
		}
		if(direction == 4)
		{
			xspeed = 0;
			yspeed = 0;
		}
		this.translate((int)xspeed, (int)yspeed);
	}
	
	public void draw(Graphics2D win)
	{
		win.setColor(this.currentColor);
		win.fill(this);
		win.setColor(Color.WHITE);
		win.draw(this);
	}
}


