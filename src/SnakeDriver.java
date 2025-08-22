// possible args:
// -fr or --framerate to set rendering framerate
// -lr or --logicrate to set logic calculation / snake movement rate
// -ee or --epilepsyEnable to enable epilepsy mode
// -ed or --epilepsyDisable to disable epilepsy mode
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

import java.io.IOException;

public class SnakeDriver {

	// paused and running state to be edited and read by other classes willy-nilly
	public static boolean paused = false;
	public static boolean running = true;

	// game settings
	public static Settings settings = Settings.load();
	public static SettingsMenu settingsMenu = new SettingsMenu(settings);

	public static void saveWithExceptionHandler() {
		try {
			settings.save();
		} catch (IOException e) {
			System.out.println("unable to save game settings due to reason: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		ArgHandler.handleArgs(args);

		saveWithExceptionHandler();

		GameLogic logic = new GameLogic();
		VideoOutput video = new VideoOutput();

		logic.start();
		video.start();
	}

}
