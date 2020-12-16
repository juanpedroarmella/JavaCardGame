package JuegoDeCartas;


import Estrategias.Estrategia;

public class Jugador {
	private String nombre;
	private Mazo mazo;
	private Estrategia estrategia;

	public Jugador(String nombre,Estrategia estrategia) {
		this.nombre = nombre;
		this.mazo = new Mazo();
		this.estrategia = estrategia;
	}
	public void addCarta(Carta c) {
		this.mazo.addCarta(c);
	}
	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public int getTamanio() {
		return mazo.cantidadCartas();
	}
	
	public Carta jugarCarta() {
		return this.mazo.getPrimeraCarta();
	}

	public String getNombre() {
		return nombre;
	}
	
	public Atributo seleccionarAtributo() {
		return mazo.getCartas().get(0).seleccionarAtributoRandom();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Atributo implementarEstrategia(Carta c) {
		return estrategia.implementarEstrategia(c);
	}

	
}
