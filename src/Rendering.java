import java.awt.*;
import javax.swing.*;

public class Rendering extends JFrame {
	private static final long serialVersionUID = 795051277355485771L;
	Container c;
	Renderer r;
	int[][] objPos = new int[25][25];

	public Rendering() {

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

}
