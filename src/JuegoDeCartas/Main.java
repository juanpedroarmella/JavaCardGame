package JuegoDeCartas;

import java.util.ArrayList;

import Estrategias.*;
import Pociones.*;


public class Main {
	
	public static void main(String[] args) {
		String mazoCartas = "./src/JuegoDeCartas/autos.json";
		
		//Estrategia e1 = new Timbero();
		Estrategia e2 = new Ambicioso();
		Estrategia e3 = new Obstinado("fuerza");
		
		
		Jugador j1 = new Jugador("Jugador1",e2);
		Jugador j2 = new Jugador("Jugador2",e3);
		
		
		Mazo m = new Mazo();
		
		Pocion p1 = new IncrementarPorcentaje("Fortalecedora",20);
		Pocion p2 = new IncrementarPorcentaje("Fortalecedora Plus",50);
		Pocion p3 = new ReducirPorcentaje("Kriptonita",25);
		Pocion p4 = new ReducirPorcentaje("Reductor de Plomo",55);
		Pocion p5 = new ValorFijo("Quiero Vale Cuatro",4);
		Pocion p6 = new ValorFijo("Numero Mágico",23);
		Pocion p7 = new IncrementarPorcentajeSelectivo("Pócima Selectiva Fuerza",35,"fuerza");
		Pocion p8 = new IncrementarPorcentajeSelectivo("Pócima Selectiva Peso",43,"peso");
		PocionCocktail p9 = new PocionCocktail("Pócima Cocktail");
		p9.addPocion(p1);
		p9.addPocion(p2);
		p9.addPocion(p3);
		p9.addPocion(p4);
		p9.addPocion(p5);
		p9.addPocion(p6);
		p9.addPocion(p7);
		p9.addPocion(p8);
		
		
		ArrayList<Pocion> pociones = new ArrayList<>();
		pociones.add(p1);
		pociones.add(p2);
		pociones.add(p5);
		pociones.add(p6);
		pociones.add(p7);
		pociones.add(p8);
		pociones.add(p9);
		
		
		Juego j = new Juego(m,j1,j2,20,pociones);
		Juego.empezarJuego(mazoCartas, j);
	}
}
