import java.awt.*;

import javax.swing.*;

public class RenderingHelper extends JFrame {
	private static final long serialVersionUID = 795051277355485771L;
	Container c;
	Renderer r;
	int[][] objPos = new int[25][25];
	TextPosMap textPosMap = new TextPosMap();

	public RenderingHelper() {

		c = getContentPane();
		r = new Renderer();
		c.add(r);
	}

	public void render(Snake snake, Pellet pellet) {
		objPos = new int[25][25];
		objPos[snake.getHeadPos().xPos][snake.getHeadPos().yPos] = 2;
		for (Position tailPiece : snake.getTail())
			if (tailPiece != null)
				objPos[tailPiece.xPos][tailPiece.yPos] = 2;
		objPos[pellet.getPos().xPos][pellet.getPos().yPos] = 1;
		r.setObjectPos(objPos);
		repaint();
	}

	public void render(Settings.PossibleSettings currentSetting) {
		textPosMap.clear();
		textPosMap.put(new int[]{10,100}, "Pause");
		textPosMap.put(new int[]{64, 250}, Settings.PossibleSettings.FRAME_RATE.getText());
		textPosMap.put(new int[]{64, 400}, Settings.PossibleSettings.LOGIC_RATE.getText());
		textPosMap.put(new int[]{64, 550}, Settings.PossibleSettings.EPILEPSY_MODE.getText());
		textPosMap.put(new int[]{425, 250}, Integer.toString((int)SnakeDriver.settings.getFrameRendersPerSecond()));
		textPosMap.put(new int[]{425, 400}, Integer.toString((int)SnakeDriver.settings.getSnakeMovementsPerSecond()));
		if (SnakeDriver.settings.isEpilepsyMode())
			textPosMap.put(new int[]{425, 550}, "on");
		else
			textPosMap.put(new int[]{425, 550}, "off");

		switch (currentSetting) {
			case FRAME_RATE:
				textPosMap.put(new int[]{10, 250}, ">");
				break;
			case LOGIC_RATE:
				textPosMap.put(new int[]{10, 400}, ">");
				break;
			case EPILEPSY_MODE:
				textPosMap.put(new int[]{10, 550}, ">");
				break;
			default:
				break;
		}
		r.setTextPosMap(textPosMap);
		repaint();
	}

}
