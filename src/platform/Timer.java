package platform;

import Snakerer.GameObject;

public class Timer {
	
	int tick;
	double delay; //in seconds
	boolean isTiming = false;
	
	public Timer(double delay) {
		
		this.delay = delay;
		
	}
	
	public void start() {
		this.isTiming=true;
	}
	
	public void stop() {
		this.isTiming=false;
	}
	
	public void restart() {
		this.tick=0;
		this.start();
	}
	
	public boolean update() {
		
		if(this.isTiming) {
			
			if(this.tick >= this.delay * GameObject.FPS) {
				
				this.tick=0;
				
				return true;
				
			} else {
				
				this.tick++;
				
			}
		}
		
		return false;
		
		
		
	}

}
