import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Settings implements Serializable{
    private double snakeMovementsPerSecond;
	private double frameRendersPerSecond;

	private boolean epilepsyMode;

    private Settings() {
        this.initDefaultSettings();
    }

    private void initDefaultSettings() {
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
