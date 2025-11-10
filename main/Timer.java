package main;

import java.awt.Canvas;

import window.Window;

public class Timer extends Canvas implements Runnable{
	private final static int pWIDTH = 400;
	private final static int pHEIGHT = 400;
	private final static String title = "Timer";
	
	private boolean running = false;
	
	//Create the Time object
	int currentSecond = 0;
	int currentMinute = 0;
	int currentHour = 0;
	Time time;
	
	Thread thread;
	
	public void start() {
		if(!running) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void stop() throws InterruptedException {
		if(running) {
			running = false;
			thread.join();
		}
	}
	
	//Update timer
	public void tick() {
		
	}
	
	//Render Timer
	public void render() {
		
	}
	
	public void run() {
		
		long beforeTime, timeDiff, sleepTime, tempTime;
		beforeTime = System.currentTimeMillis();
		tempTime = System.currentTimeMillis();
		
		time = new Time(currentSecond, currentMinute, currentHour);
		
		while(running) {
			long currentTime = System.currentTimeMillis();
			timeDiff = currentTime- beforeTime;
			sleepTime = (1000/60) - timeDiff;
				
			if(sleepTime >= 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			beforeTime = System.currentTimeMillis();
			
			if(currentTime - tempTime >= 1000) {
				time.startTimer();
				
				tempTime = System.currentTimeMillis();
				System.out.println("Seconds: "+time.getSeconds());
				System.out.println("Minutes: "+time.getMinutes());
				System.out.println("Hours: "+time.getHours());
			}
		}
	}
	
	public static void main(String[] args) {
		Window w = new Window(pWIDTH, pHEIGHT, title, new Timer());
	}
}
