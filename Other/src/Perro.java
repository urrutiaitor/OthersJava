import java.awt.Color;

public class Perro extends Animal {

	Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Perro [color=" + color + "] -> " + super.toString();
	}
	
}
