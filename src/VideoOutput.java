import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class VideoOutput extends Thread {

	RenderingHelper window;
	private long previousFrameTime = System.currentTimeMillis();

	VideoOutput() {
		window = new RenderingHelper();
		window.setTitle("snek");
		window.setSize(SnakeDriver.settings.getScreenWidth(), SnakeDriver.settings.getScreenHeight());
		window.setVisible(true);
		window.setMinimumSize(new Dimension(25,25));
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void run() {
		window.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				SnakeDriver.settings.setScreenHeight(window.getHeight());
				SnakeDriver.settings.setScreenWidth(window.getWidth());
			}
		});
		window.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				SnakeDriver.running = false;
            	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			@Override
			public void windowClosed(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowClosed'");  }

			@Override
			public void windowOpened(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowOpened'"); }

			@Override
			public void windowIconified(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowIconified'"); }

			@Override
			public void windowDeiconified(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowDeiconified'"); }

			@Override
			public void windowActivated(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowActivated'"); }

			@Override
			public void windowDeactivated(WindowEvent e) { throw new UnsupportedOperationException("Unimplemented method 'windowDeactivated'"); }
			
		});
		while (SnakeDriver.running) {
			if (TimeKeeping.calculateDeltaTime(previousFrameTime) > 1000.0 / SnakeDriver.settings.getFrameRendersPerSecond()) {
				previousFrameTime = System.currentTimeMillis();
				window.render(GameLogic.getSnake(), GameLogic.getPellet());
			}
		}
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}

}
