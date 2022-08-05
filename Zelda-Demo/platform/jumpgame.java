package platform;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import src.Utility.GDV5;
import src.Utility.SoundDriverHo;


public class jumpgame extends src.Utility.GDV5 {
	static src.Utility.SoundDriverHo song;
	Sprite sprite;
	int player = 0;
	Player play = new Player(380, 280);
	int[][] map = new int[40][30];
	ArrayList<Floor> floors = new ArrayList<Floor>();
	boolean hit = false;
	boolean xhit = false;
	String Confirmer = "False";
	Sword sword = new Sword(-100,100);
	Enemy enemy = new Enemy(0,0);
	int timer = 0;
	int xpos = 0;
	int ypos = 0;
	int delay = 19;
	public jumpgame() {	
//		BufferedImage cheet=this.addImage("/src.Images/FInalFruits.png");
//		sprite = new Sprite(cheet, 1,5, 3);
		String[]audio = new String[2];
		audio[0] = "Song.wav";
		audio[1] = "Mario.wav";
		song = new SoundDriverHo(audio, this);
		for(int i = 0; i < 40; i++)
		{
			floors.add(new Floor(20 * i, 0));
			floors.add(new Floor(20 * i, 580));
			map[i][0] = 2;
			map[i][29] = 2;
		}
		for(int i = 0; i < 30; i++)
		{
			floors.add(new Floor(0, 20 * i));
			floors.add(new Floor(780, 20 * i));
			map[0][i] = 2;
			map[39][i] = 2;
		}
		map[19][14] = 1;
	}
	
	public static void main(String[]args) {
		
		jumpgame s1 = new jumpgame();
		s1.start();
		
	}

	public void update() {
		enemyMove(play, enemy);
		for(int i = 0; i < map.length; i++)
		{
			for(int k = 0; k < map[0].length; k++)
			{
				if(map[i][k] == 1)
				{
					xpos = i;
					ypos = k;
				}
			}
		}		
		if(enemy.intersects(sword) && enemy.hitstun > 10)
		{
			enemy.lives--;
			enemy.hitstun = 0;
		}
		enemy.hitstun++;
		timer++;
		if(timer > 9)
		{
			sword.x = -100;
			sword.y = -100;
			playerMove(map);
		}
		play.update();
	}

	public void draw(Graphics2D win) {
		for(Floor i : floors)
		{
			i.draw(win);
		}
		play.draw(win);
		enemy.draw(win);
		sword.draw(win);
	}
	public void enemyMove(Player play, Enemy enemy)
	{
		int x = play.x - enemy.x;
		int y = play.y - enemy.y;
		double b = (x * x) + (y * y);
		b = Math.sqrt(b);
		x = (int) (1.5 * (x / b));
		y = (int) (1.5 * (y / b));
		enemy.xspeed = x;
		enemy.yspeed = y;
		enemy.update();
	}
	public void playerMove(int[][] map)
	{
		if(GDV5.KeysPressed[KeyEvent.VK_S] != GDV5.KeysPressed[KeyEvent.VK_W])
		{
			if(GDV5.KeysPressed[KeyEvent.VK_W])
			{
				if(map[xpos][ypos-1] != 2)
				{
					play.direction = 3;
					map[xpos][ypos] = 0;
					map[xpos][ypos - 1] = 1;
					timer = 0;
					play.facing = 3;
				}
				else
				{
					play.direction = 4;
				}
			}
			else if(GDV5.KeysPressed[KeyEvent.VK_S])
			{
				if(map[xpos][ypos+1] != 2)
				{
					play.direction = 1;
					map[xpos][ypos] = 0;
					map[xpos][ypos + 1] = 1;
					timer = 0;
					play.facing = 1;
				}
				else
				{
					play.direction = 4;
				}
			}
			sword.orientation = 0;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_A] != GDV5.KeysPressed[KeyEvent.VK_D])
		{
				if(GDV5.KeysPressed[KeyEvent.VK_D])
				{
					if(map[xpos+1][ypos] != 2)
					{
						play.direction = 0;
						map[xpos][ypos] = 0;
						map[xpos+1][ypos] = 1;
						timer = 0;
						play.facing = 0;
					}
					else
					{
						play.direction = 4;
					}
				}
				else if(GDV5.KeysPressed[KeyEvent.VK_A])
				{
					if(map[xpos - 1][ypos] != 2)
					{
						play.direction = 2;
						map[xpos][ypos] = 0;
						map[xpos-1][ypos] = 1;
						timer = 0;
						play.facing = 2;
					}
					else
					{
						play.direction = 4;
					}
				}
				sword.orientation = 1;
		}
		else
		{ 
			play.direction = 4;
			if(GDV5.KeysPressed[KeyEvent.VK_SPACE])
			{
				sword.update();
				if(play.facing == 0)
				{
					sword.x = play.x + 20;
					sword.y = play.y + 6;
				}
				if(play.facing == 1)
				{
					sword.x = play.x + 6;
					sword.y = play.y + 20;
				}
				if(play.facing == 2)
				{
					sword.x = play.x - 20;
					sword.y = play.y + 6;
				}
				if(play.facing == 3)
				{
					sword.x = play.x + 6;
					sword.y = play.y - 20;
				}
				timer = 0;
			}
		}
	}

}