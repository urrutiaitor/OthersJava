import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;

public class Principal1 {
	
	ArrayList<Animal> animales;

	public static void main(String[] args) {
		Principal1 principal1 = new Principal1();
	}
	
	public Principal1 () {
		
		animales = new ArrayList<Animal>();
		
		for (int i = 0; i < 10; i++) {
			Perro perro1 = new Perro();
			if (i % 2 == 0) perro1.color = Color.YELLOW;
			if (i % 2 == 1) perro1.color = Color.GREEN;
			perro1.nombre = "PERRO nº " + i;
			
			animales.add(perro1);
		}
		
		ListIterator<Animal> animalesIt = animales.listIterator();
		
		while (animalesIt.hasNext()) {
			if (((Perro) animalesIt.next()).color == Color.YELLOW) animalesIt.remove();
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(animales.get(i).toString());
		}
		
	}

}
