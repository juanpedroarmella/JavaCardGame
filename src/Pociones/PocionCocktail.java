package Pociones;
import java.util.ArrayList;

import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public class PocionCocktail extends Pocion {
	
	private ArrayList<Pocion> pociones;
	
	public PocionCocktail(String nombre) {
		super(nombre);
		pociones = new ArrayList<>();
	}
	
	public void addPocion(Pocion p) {
		pociones.add(p);
	}
	
	public ArrayList<Pocion> getPociones() {
		return new ArrayList<Pocion>(pociones);
	}
	
	@Override
	public int utilizarPocion(Carta c,Atributo atributoSeleccionado) {
		int total=0;
		for (int i = 0; i < pociones.size(); i++) {
			total+=getPociones().get(i).utilizarPocion(c,atributoSeleccionado);
		}
		return total;
	}
	 
}