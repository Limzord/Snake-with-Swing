import java.awt.*;
import javax.swing.*;

public class Zeichenbrett extends JPanel {
	private static final long serialVersionUID = -3607275009379437627L;
	private int objPos[][] = new int[25][25];

	Zeichenbrett() {
		addKeyListener(new InputHandler());
	}

	@Override
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public void setObjectPos(int[][] objPos) {
		this.objPos = objPos;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Methode der Oberklasse aufrufen

		double multiplierx = Math.rint(getWidth() * 10.0 / 250);
		double multipliery = Math.rint(getHeight() * 10.0 / 250);
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				switch (objPos[x][y]) {
				case 0:
//					g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
//							(int) (Math.random() * 255)));
					g.setColor(new Color(0, 0, 0));
					break;
				case 1:
					g.setColor(new Color(255, 0, 0));
					break;
				case 2:
					g.setColor(new Color(0, 255, 0));
					break;
				}
				g.fillRect((int) (x * multiplierx), (int) (y * multipliery), (int) multiplierx, (int) multipliery);
			}
		}
	}
}
