
public class Snake {

	int length = 1;
	private Position headPos = new Position();
	private Position[] tail;
	private static int facingDirection = Position.NORTH;

	Snake() {
	}

	Snake(int xPos, int yPos) {
		headPos.xPos = xPos;
		headPos.yPos = yPos;
		tail = new Position[length];
		tail[0] = headPos;
	}
	
	Snake(Position position){
		headPos.xPos = position.xPos;
		headPos.yPos = position.yPos;
		tail = new Position[length];
		tail[0] = headPos;
	}

	Snake(int xPos, int yPos, int startingLength) {
		headPos.xPos = xPos;
		headPos.yPos = yPos;
		length = startingLength;
		tail = new Position[length];
		tail[0] = headPos;
	}
	
	Snake(Position position, int startingLength){
		headPos.xPos = position.xPos;
		headPos.yPos = position.yPos;
		length = startingLength;
		tail = new Position[length];
		tail[0] = headPos;
	}

	public Position getHeadPos() {
		return headPos;
	}

	public Position[] getTail() {
		return tail;
	}

	public boolean setHeadPos(int xPos, int yPos) {
		headPos.xPos = xPos;
		headPos.yPos = yPos;
		return true;
	}

	public static void setFacingDirection(int facingDirection) {
		Snake.facingDirection = facingDirection;
	}

	public static int getFacingDirection() {
		return Snake.facingDirection;
	}

	public void updateHeadPos() {
		switch (facingDirection) {
		case Position.NORTH:
			headPos.yPos -= 1;
			break;
		case Position.EAST:
			headPos.xPos += 1;
			break;
		case Position.SOUTH:
			headPos.yPos += 1;
			break;
		case Position.WEST:
			headPos.xPos -= 1;
			break;
		}
		headPos.xPos = headPos.xPos % 25;
		if (headPos.xPos < 0)
			headPos.xPos += 25;
		headPos.yPos = headPos.yPos % 25;
		if (headPos.yPos < 0)
			headPos.yPos += 25;
	}

	public void updateTail() {
		for (int i = tail.length - 1; i > 0; i--)
			if (tail[i - 1] != null)
				tail[i] = new Position(tail[i - 1]);
		tail[0] = new Position(headPos);
	}

	public void grow() {
		length += 1;
		Position[] temp = new Position[length];
		for (int i = temp.length - 1; i > 0; i--)
			if (tail[i - 1] != null)
				temp[i] = new Position(tail[i - 1]);
//		temp[1] = new Position(tail[0]);
		temp[0] = new Position(headPos);
		tail = temp;
	}

}
