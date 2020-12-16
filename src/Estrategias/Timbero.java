package Estrategias;

import JuegoDeCartas.*;


public class Timbero implements Estrategia{
	
	@Override
	public Atributo implementarEstrategia(Carta c) {
		return c.seleccionarAtributoRandom();
		
	}
}
