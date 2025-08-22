import java.awt.*;
import java.util.Iterator;

import javax.swing.*;

public class Renderer extends JPanel {
	private static final long serialVersionUID = -3607275009379437627L;
	private int objPos[][] = new int[25][25];
	private TextPosMap textPosMap = new TextPosMap();

	Renderer() {
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

	public void setTextPosMap(TextPosMap textPosMap) {
		this.textPosMap = textPosMap;
	}

	private void paintGameBoard(Graphics g) {
		double multiplierx = getWidth() / 25.0;
		double multipliery = getHeight() / 25.0;
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				switch (objPos[x][y]) {
				case 0:
					if (SnakeDriver.settings.isEpilepsyMode())
						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
								(int) (Math.random() * 255)));
					else
						g.setColor(new Color(0, 0, 0));
					break;
				case 1:
					g.setColor(new Color(255, 0, 0));
					break;
				case 2:
					g.setColor(new Color(0, 255, 0));
					break;
				}
				g.fillRect((int) (multiplierx * x), (int) (multipliery * y), (int) multiplierx + 1, (int) multipliery + 1);
			}
		}
	}
	
	private void paintPauseMenu(Graphics g) {
		double multiplierx = getWidth() / 600.0;
		double multipliery = getHeight() / 600.0;

		g.setColor(new Color(255,255,255));

		double fontSize = 48;
		if (multiplierx > multipliery)
			fontSize *= multipliery;
		else
			fontSize *= multiplierx;
		g.setFont(new Font("Dialog", Font.PLAIN, (int)fontSize));

		Iterator<TextPosMap.Entry<int[],String>> iterator = textPosMap.entrySet().iterator();

        while (iterator.hasNext()) {
            TextPosMap.Entry<int[],String> textPos = iterator.next();
			g.drawString(textPos.getValue(), (int)(multiplierx * textPos.getKey()[0]), (int)(multipliery * textPos.getKey()[1]));
			iterator.remove();
        }
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Methode der Oberklasse aufrufen
		paintGameBoard(g);
		paintPauseMenu(g);
		
	}
}
