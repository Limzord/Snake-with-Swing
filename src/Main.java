// possible args:
// -fr or --framerate to set rendering framerate
// -lr or --logicrate to set logic calculation / snake movement rate
//
// controls:
// arrow keys: movement
// Escape key: exit game
// Enter / Return key: pause game
//
// good to know:
// a higher framerate comes at a higher performance cost
// but has a visible impact on lag when collecting pellets
// (optimal framerate is screen's refresh rate)

public class Main {

	// game settings
	public static double snakeMovementsPerSecond = 10.0;
	public static double frameRendersPerSecond = 60.0;

	public static boolean paused = false;

	public static boolean running = true;

	public static void main(String[] args) {
		
		ArgHandler.handleArgs(args);

		GameLogic logic = new GameLogic();
		VideoOutput video = new VideoOutput();

		logic.start();
		video.start();
	}

}
