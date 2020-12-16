package Estrategias;

import JuegoDeCartas.*;


public class Obstinado implements Estrategia  {
	
	private String atributoSeleccionado;
	
	public Obstinado(String a) {
		this.atributoSeleccionado=a;
	}
	
	@Override
	public Atributo implementarEstrategia(Carta c) {
		Atributo a = new Atributo(atributoSeleccionado,-1);
		return c.buscarAtributo(a);
	}

}
