package window;

import java.awt.Dimension;

import javax.swing.JFrame;

import main.Timer;


public class Window {
	public Window(int w, int h, String t, Timer timer) {
		JFrame frame = new JFrame();
		
		frame.setMaximumSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(t);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(timer);
		timer.start();
	
	}
}
