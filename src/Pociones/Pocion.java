package Pociones;


import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public abstract class Pocion {
	private String nombre;
	
	public Pocion(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract int utilizarPocion(Carta c,Atributo atributoSeleccionado); //Devuelve el atributo de la carta transformado
}
