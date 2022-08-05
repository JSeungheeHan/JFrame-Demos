package platform;



import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Snake {
	int direction = 1;
	ArrayList<SnakePart> ar = new ArrayList<SnakePart>();
	public Snake(int x, int y) {
		for(int i = 0; i < 8; i++)
		{
			ar.add(new SnakePart(x, y + (24*i)));
		}
	}
	
	public void update() {
		ar.get(0).col = Color.BLUE;

		for(int i = ar.size() - 1; i > 0; i--)
		{
			ar.get(i).x = ar.get(i-1).x;
			ar.get(i).y = ar.get(i-1).y;
//			if(ar.get(i-1).direction == 1 && ar.get(i-1).y % 24 != 22)
//			{
//				ar.get(i).translate(0, -4);
//			}
//			if(ar.get(i-1).direction == 2)
//			{
//				ar.get(i).translate(4, 0);
//			}
			ar.get(i).direction = ar.get(i-1).direction;
			
		}
		if(this.direction == 0)
		{
			ar.get(0).translate(0, -24);
			ar.get(0).direction = 1;
		}
		if(this.direction == 1)
		{
			ar.get(0).translate(24, 0);
			ar.get(0).direction = 0;
		}
		if(this.direction == 2)
		{
			ar.get(0).translate(0, 24);
			ar.get(0).direction = 1;
		}
		if(this.direction == 3)
		{
			ar.get(0).translate(-24, 0);
			ar.get(0).direction = 0;
		}
	}
	
	public void draw(Graphics2D win) {
		for(SnakePart e : ar)
		{
			if(e != null)
			{
				e.draw(win);
			}
		}
	}
	
}