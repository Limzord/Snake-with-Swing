
public class Pellet {

	Position position = null;
	
	Pellet(){
		do
		position = new Position( (int)(Math.random() * 24),(int)(Math.random() * 24));
	while(GameLogic.intersects(this));
	}
	
	public Position getPos() {
		return position;
	}
	
}
