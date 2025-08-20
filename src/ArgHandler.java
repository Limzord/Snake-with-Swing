
public class ArgHandler {

	public static void handleArgs(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				args[i].toLowerCase();
				switch (args[i]) {
				case "-lr":
					try {
						SnakeDriver.settings.setSnakeMovementsPerSecond(Double.parseDouble(args[i + 1]));
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
						System.out.println("Error: after argument, please input the value you want to set it to");
						System.out.println("continuing execution");
					}
					break;
				case "-fr":
					try {
						SnakeDriver.settings.setFrameRendersPerSecond(Double.parseDouble(args[i + 1]));
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
						System.out.println("Error: after argument, please input the value you want to set it to");
						System.out.println("continuing execution");
					}
					break;
				case "-ee":
					SnakeDriver.settings.setEpilepsyMode(true);
					break;
				case "-ed":
					SnakeDriver.settings.setEpilepsyMode(false);
					break;
				}
			}
			if (args[i].startsWith("--")) {
				args[i].toLowerCase();
				switch (args[i]) {
				case "--logicrate":
					try {
						SnakeDriver.settings.setSnakeMovementsPerSecond(Double.parseDouble(args[i + 1]));
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
						System.out.println("Error: after argument, please input the value you want to set it to");
						System.out.println("continuing execution");
					}
					break;
				case "--framerate":
					try {
						SnakeDriver.settings.setFrameRendersPerSecond(Double.parseDouble(args[i + 1]));
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
						System.out.println("Error: after argument, please input the value you want to set it to");
						System.out.println("continuing execution");
					}
					break;
				case "--epilepsyEnable":
					SnakeDriver.settings.setEpilepsyMode(true);
					break;
				case "-epilepsyDisable":
					SnakeDriver.settings.setEpilepsyMode(false);
					break;
				}
			}
		}
		
	}

}
