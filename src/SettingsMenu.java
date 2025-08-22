public class SettingsMenu {
    private Settings settings;

    public enum SettingOperation {
        INCREASE,
        DECREASE
    }

    private Settings.PossibleSettings currentSetting = Settings.PossibleSettings.FRAME_RATE;

    public SettingsMenu(Settings settings) {
        this.settings = settings;
    }

    public void moveUp() {
        switch (currentSetting) {
            case FRAME_RATE:
                currentSetting = Settings.PossibleSettings.EPILEPSY_MODE;
                break;
            case LOGIC_RATE:
                currentSetting = Settings.PossibleSettings.FRAME_RATE;
                break;
            case EPILEPSY_MODE:
                currentSetting = Settings.PossibleSettings.LOGIC_RATE;
                break;
            default:
                break;
        }
    }

    public void moveDown() {
        switch (currentSetting) {
            case FRAME_RATE:
                currentSetting = Settings.PossibleSettings.LOGIC_RATE;
                break;
            case LOGIC_RATE:
                currentSetting = Settings.PossibleSettings.EPILEPSY_MODE;
                break;
            case EPILEPSY_MODE:
                currentSetting = Settings.PossibleSettings.FRAME_RATE;
                break;
            default:
                break;
        }
    }

    public void moveLeft() {
        changeSetting(SettingOperation.DECREASE);
    }

    public void moveRight() {
        changeSetting(SettingOperation.INCREASE);
    }

    private void changeSetting(SettingOperation dir) {
        switch (currentSetting) {
            case EPILEPSY_MODE:
                settings.setEpilepsyMode(!settings.isEpilepsyMode());
                break;
            case FRAME_RATE:
                switch (dir) {
                    case DECREASE:
                        if (settings.getFrameRendersPerSecond() > 0)
                            settings.setFrameRendersPerSecond(settings.getFrameRendersPerSecond() - 1.0);
                        break;
                    case INCREASE:
                        settings.setFrameRendersPerSecond(settings.getFrameRendersPerSecond() + 1.0);
                        break;
                    default:
                        break;
                }
                break;
            case LOGIC_RATE:
                switch (dir) {
                    case DECREASE:
                        if (settings.getSnakeMovementsPerSecond() > 0)
                            settings.setSnakeMovementsPerSecond(settings.getSnakeMovementsPerSecond() - 1.0);
                        break;
                    case INCREASE:
                        settings.setSnakeMovementsPerSecond(settings.getSnakeMovementsPerSecond() + 1.0);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public Settings.PossibleSettings getCurrentSetting() {
        return currentSetting;
    }

    
}
