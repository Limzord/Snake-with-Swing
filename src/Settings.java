import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.GraphicsEnvironment;

public class Settings implements Serializable{
    public enum PossibleSettings {
        LOGIC_RATE ("Logic Rate"),
        FRAME_RATE ("Framerate"),
        EPILEPSY_MODE("Epilepsy Mode");

        private final String text;

        PossibleSettings(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    };

    private double snakeMovementsPerSecond;
	private double frameRendersPerSecond;

    private int screenWidth;
    private int screenHeight;

	private boolean epilepsyMode;

    private Settings() {
        this.initDefaultSettings();
    }

    private void initDefaultSettings() {
        snakeMovementsPerSecond = 10.0;
        frameRendersPerSecond = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getRefreshRate();
        epilepsyMode = false;
        screenWidth = 600;
        screenHeight = 600;
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
    
    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void save() throws IOException {
        try {
            File file;
            file = new File("./settings.sav");
            if (file.exists()) {
                File rename;
                rename = new File("./settings.sav.bak");
                if (rename.exists()) {
                    rename.delete();
                }
                file.renameTo(rename);
            }
            file.createNewFile();
        } catch (IOException e) {
            throw new IOException("unable to create save file");
        }
        try {
            FileOutputStream saveFile = new FileOutputStream("./settings.sav");
            ObjectOutputStream saveData = new ObjectOutputStream(saveFile);
            saveData.writeObject(this);
            saveData.close();
        } catch (FileNotFoundException e) {
            throw new IOException("save file was deleted after creation and couldn't be recreated");
        } catch (IOException e) {
            throw new IOException("writing data to save file failed");
        }
    }

    public static Settings load() {
        FileInputStream saveFile;
        try {
            saveFile = new FileInputStream("./settings.sav");
        } catch (FileNotFoundException e) {
            return new Settings();
        }
        try {
            ObjectInputStream saveData = new ObjectInputStream(saveFile);
            Settings saveToReturn = (Settings)saveData.readObject();
            saveData.close();
            return saveToReturn;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println ("Save data corrupt: deleting...");
            File file;
            File rename;
            file = new File("./settings.sav");
            rename = new File("./settings.sav.bak");
            if (rename.exists()) {
                rename.delete();
            }
            file.renameTo(rename);
            return new Settings();
        }
    }
}
