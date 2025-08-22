public class GameLogic extends Thread {

	static Snake snake = null;
	static Pellet pellet = null;

	private long previousCalcTime = System.currentTimeMillis();

	public GameLogic() {
		snake = new Snake((int) (Math.random() * 25), (int) (Math.random() * 25));
		pellet = new Pellet();
	}

	@Override
	public void run() {
		while (SnakeDriver.running) {
			if (TimeKeeping.calculateDeltaTime(previousCalcTime) > 1000.0 / SnakeDriver.settings.getSnakeMovementsPerSecond()) {
				previousCalcTime = System.currentTimeMillis();
				if (!SnakeDriver.paused) {
					snake.updateHeadPos();
					if (intersects(snake, pellet)) {
						pellet = new Pellet();
						snake.grow();
					} else
						snake.updateTail();

					if (intersects(snake))
						SnakeDriver.running = false;

					InputHandler.inputNotify();
				}
				SnakeDriver.dasHandler.run();
			}
		}
		SnakeDriver.saveWithExceptionHandler();
	}

	public static boolean intersects(Snake snake) {
		for (int i = 1; i < snake.getTail().length; i++)
			if (snake.getTail()[i] != null)
				if (snake.getTail()[i].equals(snake.getHeadPos()))
					return true;
		return false;
	}

	public static boolean intersects(Pellet pellet) {
		if (snake.getHeadPos().equals(pellet.getPos()))
			return true;
		for (Position tailPiece : snake.getTail())
			if (tailPiece != null)
				if (tailPiece.equals(pellet.getPos()))
					return true;
		return false;
	}

	public static boolean intersects(Snake snake, Pellet pellet) {
		if (snake.getHeadPos().equals(pellet.getPos()))
			return true;
		return false;
	}

	public static boolean intersects(Pellet pellet, Snake snake) {
		if (snake.getHeadPos().equals(pellet.getPos()))
			return true;
		return false;
	}

	public static Snake getSnake() {
		return snake;
	}

	public static Pellet getPellet() {
		return pellet;
	}

}
