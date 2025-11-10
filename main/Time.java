package main;

public class Time {
	
	static int s;
	static int m;
	static int h;
	
	public Time(int s, int m, int h) {
		setSeconds(s);
		setMinutes(m);
		setHours(h);
	}
	
	//Setters
	private void setSeconds(int s) {
		Time.s = s;
	}
	
	private void setMinutes(int m) {
		Time.m = m;
	}
	
	private void setHours(int h) {
		Time.h = h;
	}
	
	//Getters
	public int getSeconds() {
		return s;
	}
	public int getMinutes() {
		return m;
	}
	public int getHours() {
		return h;
	}
	
	public void runTimer() {	
		s++;
		
		if(s == 60) {
			s = 0;
			m += 1;
		}
		if(m == 60) {
			m = 0;
			h += 1;
		}
	}
}	
