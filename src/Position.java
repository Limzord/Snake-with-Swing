
public class Position {
	final static int NORTH = 0;
	final static int EAST = 1;
	final static int SOUTH = 2;
	final static int WEST = 3;
	
	public int xPos;
	public int yPos;

	Position() {
		
	}
	Position(int x, int y){
		xPos = x;
		yPos = y;
	}
	Position(Position position){
		this.xPos = position.xPos;
		this.yPos = position.yPos;
	}
	
	public boolean equals(Position object)
	{
		if (this.xPos == object.xPos && this.yPos == object.yPos)
			return true;
		return false;
	}
}
