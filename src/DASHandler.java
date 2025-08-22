public class DASHandler implements Runnable {

    public enum DASDirection {
        DAS_UP (() -> dasHandler.DASUp()),
        DAS_DOWN (() -> dasHandler.DASDown()),
        DAS_LEFT (() -> dasHandler.DASLeft()),
        DAS_RIGHT (() -> dasHandler.DASRight());

        private final Runnable DASMethod;

        private DASDirection(Runnable DASMethod) {
            this.DASMethod = DASMethod;
        }

        private Runnable getMethod() {
            return DASMethod;
        }
    }

    private static DASHandler dasHandler = null;

    private DASDirection DASDirection = null;

    private int timeHeld = 0;

    private final int dasTimeout;

    private DASHandler(int dasTimeout) {
        this.dasTimeout = dasTimeout;
    }

    public static DASHandler init(int dasTimeout) throws IllegalStateException{
        if (dasHandler == null)
            dasHandler = new DASHandler(dasTimeout);
        throw new IllegalStateException("cannot initialize multiple objects of this class. please use getDasHandler().");
    }

    public static DASHandler getDasHandler() throws IllegalStateException {
        if (dasHandler != null)
            return dasHandler;
        throw new IllegalStateException("class object not yet initialized. please use init(int dasTimeout).");
    }

    public void setMethod(DASDirection DASDirection) {
        if (DASDirection == null)
            timeHeld = 0;
        this.DASDirection = DASDirection;
    }

    private void DASUp() {
        if (timeHeld == 0 | timeHeld >= dasTimeout)
            SnakeDriver.settingsMenu.moveUp();
        timeHeld += 1;
    }

    private void DASDown() {
        if (timeHeld == 0 | timeHeld >= dasTimeout)
            SnakeDriver.settingsMenu.moveDown();
        timeHeld += 1;
    }

    private void DASLeft() {
        if (timeHeld == 0 | timeHeld >= dasTimeout)
            SnakeDriver.settingsMenu.moveLeft();
        timeHeld += 1;
    }

    private void DASRight() {
        if (timeHeld == 0 | timeHeld >= dasTimeout)
            SnakeDriver.settingsMenu.moveRight();
        timeHeld += 1;
    }

    @Override
    public void run() {
        if (DASDirection != null)
            DASDirection.getMethod().run();
    }
}
