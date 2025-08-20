import java.io.Serializable;

public class Settings implements Serializable{
    private double snakeMovementsPerSecond;
	private double frameRendersPerSecond;

	private boolean epilepsyMode;

    public Settings() {
        this.initDefaultSettings();
    }

    public void initDefaultSettings() {
        snakeMovementsPerSecond = 10.0;
        frameRendersPerSecond = 60.0;
        epilepsyMode = false;
    }

    public double getSnakeMovementsPerSecond() {
        return snakeMovementsPerSecond;
    }

    public double getFrameRendersPerSecond() {
        return frameRendersPerSecond;
    }

    public boolean isEpilepsyMode() {
        return epilepsyMode;
    }

    public void setSnakeMovementsPerSecond(double snakeMovementsPerSecond) {
        this.snakeMovementsPerSecond = snakeMovementsPerSecond;
    }

    public void setFrameRendersPerSecond(double frameRendersPerSecond) {
        this.frameRendersPerSecond = frameRendersPerSecond;
    }

    public void setEpilepsyMode(boolean epilepsyMode) {
        this.epilepsyMode = epilepsyMode;
    }
    
}
