package platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Til extends Rectangle{
	Color col = Color.GRAY;
	public Til(int x, int y) {
		super(x, y, 24, 24);
	}
	public void update() {
		// rotate
	}
	public void draw(Graphics2D win)
	{
		win.setColor(col);
		win.fill((Shape) this);
	}
}