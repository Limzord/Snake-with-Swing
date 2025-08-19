import java.awt.*;
import javax.swing.*;

public class Rendering extends JFrame {
	private static final long serialVersionUID = 795051277355485771L;
	Container c;
	Zeichenbrett z;
	int[][] objPos = new int[25][25];

	public Rendering() {

		c = getContentPane();
		z = new Zeichenbrett();
		c.add(z);
	}

	public void render(Snake snake, Pellet pellet) {
		objPos = new int[25][25];
		objPos[snake.getHeadPos().xPos][snake.getHeadPos().yPos] = 2;
		for (Position tailPiece : snake.getTail())
			if (tailPiece != null)
				objPos[tailPiece.xPos][tailPiece.yPos] = 2;
		objPos[pellet.getPos().xPos][pellet.getPos().yPos] = 1;
		z.setObjectPos(objPos);
		repaint();
	}

}
