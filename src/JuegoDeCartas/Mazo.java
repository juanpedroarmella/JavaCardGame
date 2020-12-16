package JuegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

import Pociones.Pocion;

public class Mazo {
	private ArrayList<Carta> cartas;

	public Mazo() {
		this.cartas = new ArrayList<>();
	}

	public void mezclar() {
		Collections.shuffle(this.cartas);
	}

	public void addCarta(Carta carta) {
		if(this.cartas.size() == 0)
			cartas.add(carta);
		else
			if(cartas.get(0).equals(carta))
				cartas.add(carta);
	}
	
	public void agregarPocion(Pocion p,int i) {
		cartas.get(i).setPocion(p);
	}

	public Carta getPrimeraCarta() {
		Carta c = cartas.get(0);
		cartas.remove(0);
		return c;
	}
	
	public int cantidadCartas() {
		return cartas.size();
	}

	public ArrayList<Carta> getCartas() {
		return new ArrayList<Carta>(cartas);
	}
	
}
