import java.awt.event.*;

public class InputHandler implements KeyListener {

	private static char inputBuffer;

	private static boolean inputSet;
	private static boolean inputBuffered;

	InputHandler() {
	}

	public static void inputNotify() {
		if (inputBuffered) {
			switch (inputBuffer) {
			case KeyEvent.VK_UP:
				if (Snake.getFacingDirection() != Position.SOUTH)
					Snake.setFacingDirection(Position.NORTH);
				break;
			case KeyEvent.VK_RIGHT:
				if (Snake.getFacingDirection() != Position.WEST)
					Snake.setFacingDirection(Position.EAST);
				break;
			case KeyEvent.VK_DOWN:
				if (Snake.getFacingDirection() != Position.NORTH)
					Snake.setFacingDirection(Position.SOUTH);
				break;
			case KeyEvent.VK_LEFT:
				if (Snake.getFacingDirection() != Position.EAST)
					Snake.setFacingDirection(Position.WEST);
				break;
			}
			inputBuffered = false;
		}
		inputSet = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (!inputSet) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (Snake.getFacingDirection() != Position.SOUTH) {
					Snake.setFacingDirection(Position.NORTH);
					inputSet = true;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (Snake.getFacingDirection() != Position.WEST) {
					Snake.setFacingDirection(Position.EAST);
					inputSet = true;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (Snake.getFacingDirection() != Position.NORTH) {
					Snake.setFacingDirection(Position.SOUTH);
					inputSet = true;
				}
				break;
			case KeyEvent.VK_LEFT:
				if (Snake.getFacingDirection() != Position.EAST) {
					Snake.setFacingDirection(Position.WEST);
					inputSet = true;
				}
				break;
			case KeyEvent.VK_ESCAPE:
				Main.running = false;
				break;
			case KeyEvent.VK_ENTER:
				Main.paused = !Main.paused;
				break;
			}
		} else {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				inputBuffer = KeyEvent.VK_UP;
				inputBuffered = true;
				break;
			case KeyEvent.VK_RIGHT:
				inputBuffer = KeyEvent.VK_RIGHT;
				inputBuffered = true;
				break;
			case KeyEvent.VK_DOWN:
				inputBuffer = KeyEvent.VK_DOWN;
				inputBuffered = true;
				break;
			case KeyEvent.VK_LEFT:
				inputBuffer = KeyEvent.VK_LEFT;
				inputBuffered = true;
				break;
			case KeyEvent.VK_ESCAPE:
				Main.running = false;
				break;
			case KeyEvent.VK_ENTER:
				Main.paused = !Main.paused;
				break;
			}
		}

	}

	public void keyReleased(KeyEvent e) {}
	
	public void keyTyped(KeyEvent e) {}

}
