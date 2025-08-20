import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class VideoOutput extends Thread {

	Rendering window;
	private long previousFrameTime = System.currentTimeMillis();

	VideoOutput() {
		window = new Rendering();
		window.setTitle("snek");
		window.setSize(250, 250);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		while (SnakeDriver.running) {
			if (TimeKeeping.calculateDeltaTime(previousFrameTime) > 1000.0 / SnakeDriver.frameRendersPerSecond) {
				previousFrameTime = System.currentTimeMillis();
				window.render(GameLogic.getSnake(), GameLogic.getPellet());
			}
		}
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}

}
