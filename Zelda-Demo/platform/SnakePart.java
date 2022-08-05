package platform;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class SnakePart extends Rectangle{
	Color col = Color.CYAN;
	Rectangle[] sides = new Rectangle[4];
	Boolean[] visible = new Boolean[4];
	int direction = 0;
	public SnakePart(int x, int y) {
		super(x, y, 24, 24);
		for(int i = 0; i < sides.length - 2; i++)
		{
			this.sides[i] = new Rectangle();
			this.sides[i].height = 2;
			this.sides[i].width = 24;
		}
		for(int i = 2; i < sides.length; i++)
		{
			this.sides[i] = new Rectangle();
			this.sides[i].height = 24;
			this.sides[i].width = 2;
		}
		for(int i = 0; i < visible.length; i++)
		{
			this.visible[i] = true;
		}
	}
	public void update() {
		this.sides[0].x = this.x;
		this.sides[0].y = this.y;
		this.sides[2].x = this.x;
		this.sides[2].y = this.y;
		this.sides[1].x = this.x;
		this.sides[1].y = this.y + 22;
		this.sides[3].x = this.x + 22;
		this.sides[3].y = this.y;
		// rotate
	}
	public void draw(Graphics2D win)
	{
		win.setColor(this.col);
		win.fill((Shape) this);
		win.draw((Shape) this);
		win.setColor(Color.GREEN);
		for(int i = 0; i < this.sides.length; i++)
		{
			if(this.visible[i])
			{
				win.fill(this.sides[i]);
			}
		}
	}
}